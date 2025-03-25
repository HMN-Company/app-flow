package org.example.flow.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ProductDTOCreate {
    private String name;
    private String description;
    private BigDecimal price;
    private Double discount;
    private List<String> categoryIds; // Chứa danh sách ID danh mục
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
