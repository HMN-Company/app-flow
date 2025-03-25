package org.example.flow.services.impl;

import org.example.flow.models.Product;
import org.example.flow.repositories.ProductRepository;
import org.example.flow.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

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
        return productRepository.findAll();
    }

    public Page<Product> findAllAndSearch(String name, Pageable pageable) {

        if (name != null && !name.isEmpty()) {
            return productRepository.findAllByNameContaining(name, pageable);
        } else {
            return productRepository.findAll(pageable);
        }
    }
    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public void deleteById(String id) {
        productRepository.deleteById(id);
    }

}
