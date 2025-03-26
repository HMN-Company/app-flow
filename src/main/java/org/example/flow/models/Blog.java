package org.example.flow.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog extends BaseEntity {
    private String title;
    private String content1;
    private String content2;
    private String content3;
    private String content4;
    private String content5;
    private String subContent;
    private String authorSubContent;
    private String author;
    private String avatarAuthor;
    private String background;
    private String image1;
    private String image2;

}
