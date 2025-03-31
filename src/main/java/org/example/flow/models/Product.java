package org.example.flow.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity {
    private String name;
    private String description;
    private double price;
    @Range(min = 0, max = 100)
    private double discount;
    @Range(min = 0)
    private int slot;
    private boolean isStock = true;
    private String tag;
    private int quantitySell;
}
