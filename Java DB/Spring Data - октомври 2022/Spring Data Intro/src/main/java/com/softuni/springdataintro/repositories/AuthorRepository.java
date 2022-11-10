package com.softuni.springdataintro.repositories;

import com.softuni.springdataintro.domain.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findAuthorById(Long id);

    Optional<List<Author>> findDistinctByBooksReleaseDateBefore(LocalDate date);

    @Query("SELECT a FROM Author a ORDER BY a.books.size")
    Optional<List<Author>> findAllDistinctOrderByBooks();

}

