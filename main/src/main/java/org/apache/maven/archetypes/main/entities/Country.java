package org.apache.maven.archetypes.main.entities;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country")
    private String country_name;

    @CreationTimestamp
    @Column(name = "create_date")
    private Date create_date;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date last_update;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private Set<Division> divisions;
}
