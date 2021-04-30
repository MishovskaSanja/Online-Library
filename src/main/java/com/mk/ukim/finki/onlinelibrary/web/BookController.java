package com.mk.ukim.finki.onlinelibrary.web;

import com.mk.ukim.finki.onlinelibrary.model.Book;
import com.mk.ukim.finki.onlinelibrary.model.BookDto;
import com.mk.ukim.finki.onlinelibrary.service.BookService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    private List<Book> findAll(Pageable pageable) {
        return this.bookService.findAll(pageable).getContent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return this.bookService.findById(id)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/rent/{book}")
    public ResponseEntity<Book> markAsRented(@PathVariable Long book) {
        return this.bookService.markAsRented(book)
                .map(rentedBook -> ResponseEntity.ok().body(rentedBook))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }



    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> edit(@PathVariable Long id, @RequestBody BookDto book) {
        return this.bookService.edit(id, book)
                .map(editedBook -> ResponseEntity.ok().body(editedBook))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Book> save(@RequestBody BookDto book) {
        return this.bookService.save(book)
                .map(savedBook -> ResponseEntity.ok().body(savedBook))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.bookService.deleteById(id);
        if(this.bookService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}

