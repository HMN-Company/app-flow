package org.example.flow.services.impl;

import org.example.flow.dtos.ProductDTO;
import org.example.flow.models.Category;
import org.example.flow.models.Media;
import org.example.flow.models.Product;
import org.example.flow.models.ProductCategory;
import org.example.flow.repositories.CategoryRepository;
import org.example.flow.repositories.MediaRepository;
import org.example.flow.repositories.ProductCategoryRepository;
import org.example.flow.repositories.ProductRepository;
import org.example.flow.services.FileStorageService;
import org.example.flow.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;
    private final MediaRepository mediaRepository;
    private final FileStorageService fileStorageService; // Dịch vụ lưu ảnh
    private final CategoryRepository categoryRepository;



    public ProductServiceImpl(ProductRepository productRepository, ProductCategoryRepository productCategoryRepository, MediaRepository mediaRepository, FileStorageService fileStorageService, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.productCategoryRepository = productCategoryRepository;
        this.mediaRepository = mediaRepository;
        this.fileStorageService = fileStorageService;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void save(Product entity) {
        productRepository.save(entity);
    }

    @Override
    public void update(Product entity) {
        productRepository.save(entity);
    }

    @Override
    public void delete(Product entity) {
        productRepository.delete(entity);
    }

    @Override
    public Product get(String id) {
        return productRepository.getById(id);
    }

    @Override
    public Collection<Product> getAll() {
        return productRepository.findAll();
    }


    @Override
    public Page<Product> findAllAndSearch(String name, Pageable pageable) {

        if (name != null && !name.isEmpty()) {
            return productRepository.findAllByNameContaining(name, pageable);
        } else {
            return productRepository.findAll(pageable);
        }
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public List<ProductDTO> findAllProductDTO() {
        return productRepository.findAllProductDTO()
                .stream()
                .map(this::mapToProductDTO)
                .collect(Collectors.toList());
    }

    private ProductDTO mapToProductDTO(Object[] obj) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"); // Định dạng phù hợp với chuỗi ngày giờ

        return new ProductDTO(
                (String) obj[0], // id
                (String) obj[1], // name
                (String) obj[2], // description
                (Double) obj[3], // price
                (Double) obj[4], // discount
                obj[5] != null ? List.of(((String) obj[5]).split(", ")) : List.of(), // imageUrls
                obj[6] != null ? List.of(((String) obj[6]).split(", ")) : List.of(), // categoryNames
                obj[7] != null ? LocalDateTime.parse(obj[7].toString(), formatter) : null, // createdAt
                obj[8] != null ? LocalDateTime.parse(obj[8].toString(), formatter) : null // updatedAt
        );
    }


    @Override
    public Page<ProductDTO> findAllProductDTO(Pageable pageable) {
        return productRepository.findAllProductDTO(pageable)
                .map(this::mapToProductDTO1);
    }



    private ProductDTO mapToProductDTO1(Object[] obj) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

        return new ProductDTO(
                (String) obj[0], // id
                (String) obj[1], // name
                (String) obj[2], // description
                (Double) obj[3], // price
                (Double) obj[4], // discount
                obj[5] != null ? List.of(((String) obj[5]).split(", ")) : List.of(), // imageUrls
                obj[6] != null ? List.of(((String) obj[6]).split(", ")) : List.of(), // categoryNames
                obj[7] instanceof Timestamp ? ((Timestamp) obj[7]).toLocalDateTime() : null, // createdAt
                obj[8] instanceof Timestamp ? ((Timestamp) obj[8]).toLocalDateTime() : null  // updatedAt
        );
    }

    @Override
    public Page<ProductDTO> searchProducts(String name, String category, Pageable pageable) {
        return productRepository.searchProducts(name, category, pageable)
                .map(this::mapToProductDTO1);    }

    @Override
    @Transactional
    public boolean deleteProduct(String id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteProductCategories(id); // Xóa danh mục
            productRepository.deleteProductImages(id); // Xóa ảnh
            productRepository.deleteById(id); // Xóa sản phẩm
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean createProduct(ProductDTO productDTO, MultipartFile[] imageFiles) {
        try {
            // Tạo sản phẩm mới
            Product product = new Product();
            product.setName(productDTO.getName());
            product.setDescription(productDTO.getDescription());
            product.setPrice(productDTO.getPrice());
            product.setDiscount(productDTO.getDiscount());
            product.setCreatedAt(LocalDateTime.now());
            product.setUpdatedAt(LocalDateTime.now());

            Product savedProduct = productRepository.save(product);

            // **🔹 Tìm ID danh mục dựa trên tên**
            for (String categoryName : productDTO.getCategoryNames()) {
                Category category = categoryRepository.findByName(categoryName)
                        .orElseThrow(() -> new RuntimeException("Danh mục không tồn tại: " + categoryName));
                ProductCategory productCategory = new ProductCategory();
                productCategory.setProduct(savedProduct);
                productCategory.setCategory(category);
                productCategoryRepository.save(productCategory);
            }

            // **🔹 Lưu ảnh**
            for (MultipartFile file : imageFiles) {
                String imageUrl = uploadFile(file); // Hàm upload ảnh
                Media media = new Media();
                media.setUrl(imageUrl);
                media.setProduct(savedProduct);
                mediaRepository.save(media);
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public String uploadFile(MultipartFile file) {
        try {
            // **🔹 Đường dẫn thư mục lưu ảnh**
            String uploadDir = "src/main/resources/static/assets/media/products/";
            File directory = new File(uploadDir);
            if (!directory.exists()) {
                directory.mkdirs(); // Tạo thư mục nếu chưa có
            }

            // **🔹 Lưu ảnh**
            String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
            Path filePath = Paths.get(uploadDir, fileName);
            Files.write(filePath, file.getBytes());

            // **🔹 Trả về đường dẫn để hiển thị ảnh**
            return fileName; // Truy cập ảnh qua http://localhost:8080/uploads/{fileName}
        } catch (IOException e) {
            throw new RuntimeException("Lỗi khi tải lên file: " + e.getMessage());
        }
    }



}
