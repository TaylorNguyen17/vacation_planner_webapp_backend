package org.apache.maven.archetypes.main.controllers;

import org.apache.maven.archetypes.main.dao.DivisionRepository;
import org.apache.maven.archetypes.main.entities.Division;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/divisions")
public class DivisionController {
    @Autowired
    private DivisionRepository divisionRepository;

    @GetMapping("/country/{countryId}")
    public List<Division> getDivisionsByCountry(@PathVariable Long countryId) {
        return divisionRepository.findByCountryId(countryId);
    }
}
