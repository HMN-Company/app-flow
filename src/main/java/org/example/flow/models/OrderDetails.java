package org.example.flow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.validator.constraints.Range;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints = @jakarta.persistence.UniqueConstraint(columnNames = {"orderId", "productId"}))
public class OrderDetails extends BaseEntity {
    private Order order;
    private Product product;
    @Range(min = 0)
    private int quantity;
}
