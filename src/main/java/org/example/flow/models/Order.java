package org.example.flow.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order extends BaseEntity {
    private String fullName;
    private String email;
    private String address;
    private String phone;
    @Enumerated(EnumType.STRING)
    private Status status;
    private Double totalPrice;
}
