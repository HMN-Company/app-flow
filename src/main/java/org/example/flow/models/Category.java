package org.example.flow.models;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BaseEntity {
    private String name;
}
