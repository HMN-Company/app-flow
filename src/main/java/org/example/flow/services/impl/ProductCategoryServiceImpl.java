package org.example.flow.services.impl;

import org.example.flow.models.Product;
import org.example.flow.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductService {
    @Override
    public void save(Product entity) {

    }

    @Override
    public void update(Product entity) {

    }

    @Override
    public void delete(Product entity) {

    }

    @Override
    public Product get(String id) {
        return null;
    }

    @Override
    public Collection<Product> getAll() {
        return List.of();
    }
}
