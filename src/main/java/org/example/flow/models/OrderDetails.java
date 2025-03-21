package org.example.flow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.validator.constraints.Range;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints = @jakarta.persistence.UniqueConstraint(columnNames = {"order_id", "product_id"}))
public class OrderDetails extends BaseEntity {
    @ManyToOne
    private Order order;
    @ManyToOne
    private Product product;
    @Range(min = 0)
    private int quantity;
}
