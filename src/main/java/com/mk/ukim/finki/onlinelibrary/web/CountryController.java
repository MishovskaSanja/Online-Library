package com.mk.ukim.finki.onlinelibrary.web;

import com.mk.ukim.finki.onlinelibrary.model.Country;
import com.mk.ukim.finki.onlinelibrary.service.CountryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    private List <Country> findAll() {
        return this.countryService.findAll();
    }
}