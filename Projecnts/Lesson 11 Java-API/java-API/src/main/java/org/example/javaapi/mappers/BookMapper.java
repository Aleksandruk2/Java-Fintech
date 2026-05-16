package org.example.javaapi.mappers;

import org.example.javaapi.dtos.BookItemDTO;
import org.example.javaapi.entities.BookEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookItemDTO toDto(BookEntity entity);
}
