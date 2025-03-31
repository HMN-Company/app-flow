package org.example.flow.services.impl;

import org.example.flow.dtos.ProductDTO;
<<<<<<< HEAD
import org.example.flow.dtos.ProductResponse;
=======
import org.example.flow.models.Category;
import org.example.flow.models.Media;
>>>>>>> ee2fb8a5bbb6b594b61a74f14b672ca28064479a
import org.example.flow.models.Product;
import org.example.flow.models.ProductCategory;
import org.example.flow.repositories.CategoryRepository;
import org.example.flow.repositories.MediaRepository;
import org.example.flow.repositories.ProductCategoryRepository;
import org.example.flow.repositories.ProductRepository;
<<<<<<< HEAD
import org.example.flow.services.MediaService;
=======
import org.example.flow.services.FileStorageService;
>>>>>>> ee2fb8a5bbb6b594b61a74f14b672ca28064479a
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
<<<<<<< HEAD
import java.util.ArrayList;
=======
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
>>>>>>> ee2fb8a5bbb6b594b61a74f14b672ca28064479a
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
<<<<<<< HEAD
    private final MediaService mediaService;

    public ProductServiceImpl(ProductRepository productRepository, MediaService mediaService) {
        this.productRepository = productRepository;
        this.mediaService = mediaService;
=======
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
>>>>>>> ee2fb8a5bbb6b594b61a74f14b672ca28064479a
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

<<<<<<< HEAD
    @Override
    public Collection<ProductResponse> getProducts() {
        Collection<Product> products = productRepository.findAll();
        Collection<ProductResponse> productResponses = new ArrayList<>();
        for (Product product : products) {
            Collection<String> media = mediaService.getMediasByProductId(product.getId());
            ProductResponse productResponse = new ProductResponse();
            productResponse.setId(product.getId());
            productResponse.setName(product.getName());
            productResponse.setDescription(product.getDescription());
            productResponse.setImage(media.stream().findFirst().orElse(null));
            productResponse.setImages(media);
            productResponse.setOldPrice(product.getPrice());
            productResponse.setNewPrice(product.getPrice() - product.getPrice() * (product.getDiscount() / 100));
            productResponses.add(productResponse);
        }
        return productResponses;
    }
=======

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

    @Override
    public ProductDTO getProductById(String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy sản phẩm"));

        // Lấy danh sách danh mục của sản phẩm
        List<String> categoryNames = productCategoryRepository.findAllByProduct_Id(id)
                .stream()
                .map(pc -> pc.getCategory().getName()) // Lấy tên danh mục từ ProductCategory
                .toList();

        // Lấy danh sách ảnh của sản phẩm
        List<String> imageUrls = mediaRepository.findAllByProduct_Id(id)
                .stream()
                .map(Media::getUrl) // Lấy đường dẫn ảnh
                .toList();

        // Chuyển đổi sang DTO
        return new ProductDTO(product, categoryNames, imageUrls);
    }

    @Override
    @Transactional
    public boolean updateProduct(ProductDTO productDTO, MultipartFile[] imageFiles) {
        try {
            // Lấy sản phẩm từ DB
            Product product = productRepository.findById(productDTO.getId())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm với ID: " + productDTO.getId()));

            // Cập nhật thông tin sản phẩm
            product.setName(productDTO.getName());
            product.setDescription(productDTO.getDescription());
            product.setPrice(productDTO.getPrice());
            product.setDiscount(productDTO.getDiscount());
            product.setUpdatedAt(LocalDateTime.now());

            // Lưu sản phẩm
            Product savedProduct = productRepository.save(product);

            // Xóa danh mục cũ trước khi thêm mới
            productRepository.deleteProductCategories(productDTO.getId());
            for (String categoryName : productDTO.getCategoryNames()) {
                Category category = categoryRepository.findByName(categoryName)
                        .orElseThrow(() -> new RuntimeException("Danh mục không tồn tại: " + categoryName));
                ProductCategory productCategory = new ProductCategory();
                productCategory.setProduct(savedProduct);
                productCategory.setCategory(category);
                productCategoryRepository.save(productCategory);
            }
            // Xóa ảnh cũ trước khi thêm mới
            productRepository.deleteProductImages(productDTO.getId());
            for (String imageUrl : productDTO.getImageUrls()) {
                Media media = new Media();
                String url = imageUrl.replace("[", "").replace("]", "").replace("\"", "");
                media.setUrl(url);
                media.setProduct(savedProduct);
                mediaRepository.save(media);
            }

            // Lưu ảnh mới
            for (MultipartFile file : imageFiles) {
                String imageUrl = uploadFile(file);
                if (imageUrl == null || imageUrl.isEmpty()) {
                    throw new RuntimeException("Lỗi upload ảnh");
                }
                Media media = new Media();
                media.setUrl(imageUrl);
                media.setProduct(savedProduct);
                mediaRepository.save(media);
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace(); // In lỗi để debug
            throw new RuntimeException("Lỗi khi cập nhật sản phẩm", e); // Ném lỗi để rollback
        }
    }


>>>>>>> ee2fb8a5bbb6b594b61a74f14b672ca28064479a
}
