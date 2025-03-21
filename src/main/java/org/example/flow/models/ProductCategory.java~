package org.example.flow.models;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints = @jakarta.persistence.UniqueConstraint(columnNames = {"productId", "categoryId"}))
public class ProductCategory extends BaseEntity {
    private Product product;
    private Category category;
}
