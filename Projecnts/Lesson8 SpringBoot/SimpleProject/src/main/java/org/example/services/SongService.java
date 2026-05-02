package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.dtos.SongDto;
import org.example.mappers.SongMapper;
import org.example.repositories.ISongRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SongService {
    private final SongMapper mapper;
    private final ISongRepository songRepository;

    public List<SongDto> getAll() {
        return songRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
