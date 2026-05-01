package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.dto.GenreDto;
import org.example.mappers.GenreMapper;
import org.example.repositories.IGenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreService {
    private final IGenreRepository repository;
    private final GenreMapper mapper;

    public List<GenreDto> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public void create(GenreDto dto) {
        if (repository.existsByNameIgnoreCase(dto.getName())) {
            throw new IllegalArgumentException("Такий жанр вже існує");
        }
        repository.save(mapper.toEntity(dto));
    }
}
