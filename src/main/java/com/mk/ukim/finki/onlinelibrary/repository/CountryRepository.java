package com.mk.ukim.finki.onlinelibrary.repository;

import com.mk.ukim.finki.onlinelibrary.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}