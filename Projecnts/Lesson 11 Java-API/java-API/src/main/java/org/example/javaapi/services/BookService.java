package org.example.javaapi.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.javaapi.dtos.BookItemDTO;
import org.example.javaapi.mappers.BookMapper;
import org.example.javaapi.repositories.IBookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
    private final IBookRepository bookRepository;
    private final BookMapper bookMapper;

    public List<BookItemDTO> getAll() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }
}
