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
public class Role extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private Roles role;
    @ManyToOne
    private User user;
}
