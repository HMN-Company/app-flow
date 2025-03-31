package org.example.flow.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event extends BaseEntity {
    private String title1;
    private String title2;
    private String title3;
    private String title4;
    private String title5;
    private String urlRedirect;
    private String background1;
    private String background2;
}
