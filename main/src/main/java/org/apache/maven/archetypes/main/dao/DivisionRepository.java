package org.apache.maven.archetypes.main.dao;

import org.apache.maven.archetypes.main.entities.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
public interface DivisionRepository extends JpaRepository<Division, Long> {
    List<Division> findByCountryId(Long countryId);
}
