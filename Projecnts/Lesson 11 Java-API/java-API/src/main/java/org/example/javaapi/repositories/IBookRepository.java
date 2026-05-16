package org.example.javaapi.repositories;

import org.example.javaapi.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<BookEntity, Long> {

}
