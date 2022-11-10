package com.softuni.springdataintro.services.book;

import com.softuni.springdataintro.domain.entities.Book;
import com.softuni.springdataintro.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {

        this.bookRepository = bookRepository;

    }

    @Override
    public void seedBooks(List<Book> books) {

        this.bookRepository.saveAll(books);

    }

    @Override
    public List<Book> findAllByReleaseDateAfter(LocalDate date) {

        return this.bookRepository.findAllByReleaseDateAfter(date).orElseThrow(NoSuchElementException::new);

    }

    @Override
    public List<Book> findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName) {

        return this.bookRepository.findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(firstName, lastName)
                .orElseThrow(NoSuchElementException::new);

    }

}
