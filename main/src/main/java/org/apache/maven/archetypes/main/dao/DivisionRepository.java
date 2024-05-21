package org.apache.maven.archetypes.main.dao;

import org.apache.maven.archetypes.main.entities.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:3306")
public interface DivisionRepository extends JpaRepository<Division, Long> {
}
