package org.example.flow.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class EventSpecial extends BaseEntity{
    private String title;
    private String description;
    private String time;
    private String urlEvent;
    private Boolean status = true;
}
