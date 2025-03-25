package org.example.flow.services.impl;

import org.example.flow.dtos.ProductDTO;
import org.example.flow.models.Product;
import org.example.flow.repositories.ProductRepository;
import org.example.flow.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
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
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public void deleteById(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductDTO> findAllProductDTO() {
        return productRepository.findAllProductDTO().stream().map(this::mapToProductDTO).collect(Collectors.toList());
    }

    private ProductDTO mapToProductDTO(Object[] obj) {
        return new ProductDTO(
                (String) obj[0], // id
                (String) obj[1], // name
                (String) obj[2], // description
                (Double) obj[3], // price
                (Double) obj[4], // discount
                List.of(((String) obj[5]).split(", ")), // imageUrls
                List.of(((String) obj[6]).split(", ")), // categoryNames
                obj[7] != null ? LocalDateTime.parse(obj[7].toString()) : null, // createdAt
                obj[8] != null ? LocalDateTime.parse(obj[8].toString()) : null // updatedAt
        );
    }
}
