package com.mk.ukim.finki.onlinelibrary.model;

import lombok.Data;

@Data
public class BookDto {
    private Long id;

    private String name;

    private Category category;

    private Long author;

    private Integer availableCopies;

}