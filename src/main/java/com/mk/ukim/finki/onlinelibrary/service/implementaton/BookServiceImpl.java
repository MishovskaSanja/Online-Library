package com.mk.ukim.finki.onlinelibrary.service.implementaton;

import com.mk.ukim.finki.onlinelibrary.model.Author;
import com.mk.ukim.finki.onlinelibrary.model.Book;
import com.mk.ukim.finki.onlinelibrary.model.BookDto;
import com.mk.ukim.finki.onlinelibrary.model.exception.AuthorNotFoundException;
import com.mk.ukim.finki.onlinelibrary.model.exception.BookNotFoundException;
import com.mk.ukim.finki.onlinelibrary.repository.AuthorRepository;
import com.mk.ukim.finki.onlinelibrary.repository.BookRepository;
import com.mk.ukim.finki.onlinelibrary.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Optional <Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Optional <Book> edit(Long id, BookDto book) {
        Book b = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        Author author = this.authorRepository.findById(book.getAuthor()).orElseThrow(() -> new AuthorNotFoundException(book.getAuthor()));
        b.setName(book.getName());
        b.setAvailableCopies(book.getAvailableCopies());
        b.setAuthor(author);
        b.setCategory(book.getCategory());

        this.bookRepository.save(b);
        return Optional.of(b);
    }

    @Override
    public Optional <Book> save(BookDto book) {
        Author author = this.authorRepository.findById(book.getAuthor()).orElseThrow(() -> new AuthorNotFoundException(book.getAuthor()));
        Book b = new Book(book.getName(), book.getCategory(), author, book.getAvailableCopies());

        this.bookRepository.save(b);
        return Optional.of(b);
    }

    @Override
    public Optional <Book> markAsRented(Long book) {
        Book b = this.bookRepository.findById(book)
                .orElseThrow(() -> new BookNotFoundException(book));
        if(b.getAvailableCopies() > 0) {
            b.setAvailableCopies(b.getAvailableCopies() - 1);
            this.bookRepository.save(b);
        }

        return Optional.of(b);
    }

    @Override
    public Page <Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }
}
