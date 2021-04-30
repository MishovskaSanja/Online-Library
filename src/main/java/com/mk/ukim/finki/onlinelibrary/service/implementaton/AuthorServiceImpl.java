package com.mk.ukim.finki.onlinelibrary.service.implementaton;

import com.mk.ukim.finki.onlinelibrary.model.Author;
import com.mk.ukim.finki.onlinelibrary.repository.AuthorRepository;
import com.mk.ukim.finki.onlinelibrary.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List <Author> findAll() {
        return authorRepository.findAll();
    }
}
