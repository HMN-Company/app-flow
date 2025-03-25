package org.example.flow.services;

import org.example.flow.dtos.ProductDTO;
import org.example.flow.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService extends BaseService<Product> {
    Page<Product> findAll(Pageable pageable);
    void deleteById(String id);
    List<ProductDTO> findAllProductDTO();
    Page<Product> findAllAndSearch(String name, Pageable pageable);
    Page<ProductDTO> findAllProductDTO(Pageable pageable);

    Page<ProductDTO> searchProducts( String name, String category, Pageable pageable);
    boolean deleteProduct(String id);

    public boolean createProduct(ProductDTO productDTO, MultipartFile[] imageFiles);

}
