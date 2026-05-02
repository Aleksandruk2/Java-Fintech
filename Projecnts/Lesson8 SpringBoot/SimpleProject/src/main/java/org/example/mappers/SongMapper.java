package org.example.mappers;

import org.example.dtos.SongDto;
import org.example.entities.Song;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SongMapper {
    SongDto toDto(Song song);
}
