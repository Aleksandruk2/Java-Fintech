package org.example.javaapi.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "bookmarks")

public class BookMarkEntity extends BaseEntity<Long> {

    private Integer position;

    private String label;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity book;
}
