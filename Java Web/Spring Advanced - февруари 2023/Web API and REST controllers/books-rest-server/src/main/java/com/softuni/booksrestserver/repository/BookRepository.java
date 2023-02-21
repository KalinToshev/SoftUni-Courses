package com.softuni.booksrestserver.repository;

import com.softuni.booksrestserver.model.entity.Author;
import com.softuni.booksrestserver.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}

