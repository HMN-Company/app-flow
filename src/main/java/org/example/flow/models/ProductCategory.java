package org.example.flow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints = @jakarta.persistence.UniqueConstraint(columnNames = {"product_id", "category_id"}))
public class ProductCategory extends BaseEntity {
    @ManyToOne
    private Product product;
    @ManyToOne
    private Category category;
}
