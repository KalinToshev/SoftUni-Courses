package com.softuni.booksrestserver.service;

import com.softuni.booksrestserver.model.dto.AuthorDTO;
import com.softuni.booksrestserver.model.dto.BookDTO;
import com.softuni.booksrestserver.model.entity.Author;
import com.softuni.booksrestserver.model.entity.Book;
import com.softuni.booksrestserver.repository.AuthorRepository;
import com.softuni.booksrestserver.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookService(BookRepository bookRepository,
                       AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    public long createBook(BookDTO newBook) {
        String authorName = newBook.getAuthor().getName();
        Optional<Author> authorOpt = this.authorRepository.findAuthorEntityByName(authorName);

        Book newBookEntity = new Book().
                setTitle(newBook.getTitle()).
                setIsbn(newBook.getIsbn()).
                setAuthor(authorOpt.orElseGet(() -> createNewAuthor(authorName)));

        return bookRepository.save(newBookEntity).getId();
    }

    private Author createNewAuthor(String authorName) {
        return authorRepository.save(new Author().setName(authorName));
    }

    public void deleteById(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    public Optional<BookDTO> findBookById(Long bookId) {
        return bookRepository.
                findById(bookId).
                map(this::map);
    }

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().
                stream().
                map(this::map).
                toList();
    }

    private BookDTO map(Book bookEntity) {

        AuthorDTO authorDTO = new AuthorDTO().
                setName(bookEntity.getAuthor().getName());

        return new BookDTO().
                setId(bookEntity.getId()).
                setAuthor(authorDTO).
                setIsbn(bookEntity.getIsbn()).
                setTitle(bookEntity.getTitle());
    }
}
