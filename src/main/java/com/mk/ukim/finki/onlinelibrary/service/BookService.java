package com.mk.ukim.finki.onlinelibrary.service;

import com.mk.ukim.finki.onlinelibrary.model.Book;
import com.mk.ukim.finki.onlinelibrary.model.BookDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BookService {

    Optional<Book> findById(Long id);

    void deleteById(Long id);

    Optional<Book> edit(Long id, BookDto book);

    Optional<Book> save(BookDto book);

    Optional <Book> markAsRented(Long book);

    Page <Book> findAll(Pageable pageable);

}
