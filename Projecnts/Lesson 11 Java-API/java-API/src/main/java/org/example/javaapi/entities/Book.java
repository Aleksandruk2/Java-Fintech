package org.example.javaapi.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "books")
public class Book extends BaseEntity<Long>{

    @Column(length = 200, nullable = false)
    private String title;

    @Column(length = 200, nullable = false)
    private String author;

    @Column(length = 200, nullable = false)
    private String text;
}
