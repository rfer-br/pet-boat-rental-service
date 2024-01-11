package com.petscreening.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Pet {

    @Id
    @GeneratedValue
    private BigInteger id;

    @Column(length = 255, nullable = false)
    private String name;

    @ManyToOne
    private Breed breed;

    @Column(length = 3, nullable = false)
    private Integer weight;

    //Todo - rename property after database change
    @Column(name="vaccination_status", nullable = false)
    private boolean vaccinationStatus;

    @Column(name="training_level", length = 2, nullable = false)
    private Integer trainingLevel;

    @ManyToOne
    private Owner owner;
}
