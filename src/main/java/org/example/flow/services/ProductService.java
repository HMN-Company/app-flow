package org.example.flow.services;

import org.example.flow.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService extends BaseService<Product> {
    Page<Product> findAll(Pageable pageable);
    void deleteById(String id);

}
