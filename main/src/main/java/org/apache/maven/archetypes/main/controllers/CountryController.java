package org.apache.maven.archetypes.main.controllers;

import org.apache.maven.archetypes.main.dao.CountryRepository;
import org.apache.maven.archetypes.main.entities.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {
    @Autowired
    private CountryRepository countryRepository;

    @GetMapping
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
}