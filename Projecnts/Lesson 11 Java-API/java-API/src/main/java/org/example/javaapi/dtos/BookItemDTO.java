package org.example.javaapi.dtos;

import lombok.Data;
import org.mapstruct.Mapper;

import java.time.LocalDateTime;


@Data
public class BookItemDTO {
    private Long id;
    private String title;
    private String author;
    private String text;
    private LocalDateTime createdAt;
}
