package org.example.javaapi.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "books")
public class BookEntity extends BaseEntity<Long>{

    @Column(length = 200, nullable = false)
    private String title;

    @Column(length = 200, nullable = false)
    private String author;

    @Column(nullable = false)
    private String text;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookMarkEntity> bookmarks;
}
