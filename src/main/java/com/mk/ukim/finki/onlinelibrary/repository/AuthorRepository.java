package com.mk.ukim.finki.onlinelibrary.repository;

import com.mk.ukim.finki.onlinelibrary.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository <Author, Long> {
}

