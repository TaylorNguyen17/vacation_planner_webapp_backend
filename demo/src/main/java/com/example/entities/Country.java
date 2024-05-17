package com.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "countries")
public class Country {

    @Id
    @Column (name = "country_id")
    private Long id;

    @Column(name = "country", nullable = false, length = 255)
    private String country_name;

    @Column(name = "create_date", nullable = false)
    private Date create_date;

    @Column(name = "last_update", nullable = false)
    private Date last_update;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Division> divisions;

}
