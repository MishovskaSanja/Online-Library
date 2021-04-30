package com.mk.ukim.finki.onlinelibrary.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(Long id) {
        super(String.format("Author with id: %d NOT FOUND", id));
    }

}
