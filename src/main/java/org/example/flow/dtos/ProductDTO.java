package org.example.flow.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.flow.models.Product;

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
    private int slot;
    private boolean isStock = true;
    private String tag;
    private int quantitySell;

    private List<String> imageUrls;
    private List<String> categoryNames;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProductDTO(Product product, List<String> categoryNames, List<String> imageUrls) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.discount = product.getDiscount();
        this.slot = product.getSlot();
        this.isStock = product.isStock();
        this.tag = product.getTag();
        this.quantitySell = product.getQuantitySell();
        this.imageUrls = imageUrls;
        this.categoryNames = categoryNames;
        this.createdAt = product.getCreatedAt();
        this.updatedAt = product.getUpdatedAt();
    }
}
