package org.example.mappers;

import org.example.dtos.GenreDto;
import org.example.entities.Genre;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

//@Component
//public class GenreMapper {
//    public GenreDto toDto(Genre genre) {
//        if (genre == null) return null;
//
//        GenreDto dto = new GenreDto();
//        dto.setId(genre.getId());
//        dto.setName(genre.getName());
//        dto.setDescription(genre.getDescription());
//
//        return dto;
//    }
//
//    public Genre toEntity(GenreDto dto) {
//        if (dto == null) return null;
//
//        Genre genre = new Genre();
//        genre.setId(dto.getId());
//        genre.setName(dto.getName());
//        genre.setDescription(dto.getDescription());
//
//        return genre;
//    }
//}

@Mapper(componentModel = "spring")
public interface GenreMapper {
    GenreDto toDto(Genre genre);
    Genre toEntity(GenreDto genreDto);
}
