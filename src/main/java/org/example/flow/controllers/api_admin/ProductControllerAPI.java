package org.example.flow.controllers.api_admin;


import org.example.flow.dtos.ProductDTO;
import org.example.flow.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin-manager/product")
public class ProductControllerAPI {
    private final ProductService productService;

    public ProductControllerAPI(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts(
    ) {
        List<ProductDTO> products = productService.findAllProductDTO();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<ProductDTO>> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("created_at").descending());
        Page<ProductDTO> products = productService.findAllProductDTO(pageable);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/pagee")
    public ResponseEntity<Page<ProductDTO>> searchProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category) {

        Pageable pageable = PageRequest.of(page, size);
        Page<ProductDTO> productPage = productService.searchProducts(name, category, pageable);

        return ResponseEntity.ok(productPage);


    }
}
