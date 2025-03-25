package org.example.flow.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private String id;
    private String name;
    private String description;
    private double price;
    private double discount;
    private List<String> imageUrls;
    private List<String> categoryNames;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
