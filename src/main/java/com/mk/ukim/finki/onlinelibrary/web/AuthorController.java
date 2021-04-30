package com.mk.ukim.finki.onlinelibrary.web;

import com.mk.ukim.finki.onlinelibrary.model.Author;
import com.mk.ukim.finki.onlinelibrary.service.AuthorService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    private List <Author> findAll() {
        return this.authorService.findAll();
    }
}