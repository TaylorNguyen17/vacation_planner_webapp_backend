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
@Table(name = "divisions")
public class Division {

    @Id
    @Column(name = "division_id")
    private Long id;

    @Column(name = "division_id", nullable = false, length = 255)
    private String division_name;

    @Column(name = "create_date", nullable = false)
    private Date create_date;

    @Column(name = "last_update", nullable = false)
    private Date last_update;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @OneToMany(mappedBy = "division", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Customer> customers;

}
