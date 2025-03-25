package org.example.flow.services;

import org.example.flow.dtos.ProductDTO;
import org.example.flow.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService extends BaseService<Product> {
    Page<Product> findAll(Pageable pageable);
    void deleteById(String id);
    List<ProductDTO> findAllProductDTO();
    Page<Product> findAllAndSearch(String name, Pageable pageable);

}
