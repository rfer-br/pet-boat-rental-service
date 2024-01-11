package com.petscreening.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Breed {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 255)
    private String name;

}
