package com.mk.ukim.finki.onlinelibrary.service.implementaton;

import com.mk.ukim.finki.onlinelibrary.model.Country;
import com.mk.ukim.finki.onlinelibrary.repository.CountryRepository;
import com.mk.ukim.finki.onlinelibrary.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List <Country> findAll() {
        return countryRepository.findAll();
    }
}
