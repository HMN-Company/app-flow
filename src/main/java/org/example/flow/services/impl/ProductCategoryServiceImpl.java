package org.example.flow.services.impl;

import org.example.flow.models.Product;
import org.example.flow.models.ProductCategory;
import org.example.flow.services.ProductCategoryService;
import org.example.flow.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Override
    public void save(ProductCategory entity) {

    }

    @Override
    public void update(ProductCategory entity) {

    }

    @Override
    public void delete(ProductCategory entity) {

    }

    @Override
    public ProductCategory get(String id) {
        return null;
    }

    @Override
    public Collection<ProductCategory> getAll() {
        return List.of();
    }
}
