package org.example.flow.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
    private Status status;

    public static class Status {
        public static final String PENDING = "PENDING";
        public static final String CONFIRMED = "CONFIRMED";
        public static final String DELIVERED = "DELIVERED";
        public static final String CANCELLED = "CANCELLED";
    }
}
