package org.example.flow.models;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    private String content;
    private String email;
    private String name;
    @Range(min = 0, max = 5)
    private byte rate;
    @ManyToOne
    private Product product;
    private String img;
}
