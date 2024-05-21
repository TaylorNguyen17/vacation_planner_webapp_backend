package org.apache.maven.archetypes.main.controllers;

import org.apache.maven.archetypes.main.dao.CountryRepository;
import org.apache.maven.archetypes.main.entities.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/countries")
public class CountryController {
    @Autowired
    private CountryRepository countryRepository;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllCountries() {
        List<Country> countries = countryRepository.findAll();
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> embedded = new HashMap<>();
        embedded.put("countries", countries);
        response.put("_embedded", embedded);
        return ResponseEntity.ok(response);
    }
}