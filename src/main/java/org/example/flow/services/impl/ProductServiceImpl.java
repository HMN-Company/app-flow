package org.example.flow.services.impl;

import org.example.flow.dtos.ProductDTO;
import org.example.flow.dtos.ProductResponse;
import org.example.flow.models.Product;
import org.example.flow.repositories.ProductRepository;
import org.example.flow.services.MediaService;
import org.example.flow.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final MediaService mediaService;

    public ProductServiceImpl(ProductRepository productRepository, MediaService mediaService) {
        this.productRepository = productRepository;
        this.mediaService = mediaService;
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
}
