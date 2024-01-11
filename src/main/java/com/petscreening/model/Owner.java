package com.petscreening.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
@Entity
public class Owner {

    @Id
    @GeneratedValue
    private BigInteger id;

    @Column(length = 255, nullable = false)
    private String name;

    @Column(length = 320, nullable = false)
    private String email;

    @Column(length = 10, nullable = false)
    private String zipcode;

    @Column(name="address_no", length = 20)
    private String addressNumber;

    @Column(length = 255)
    private String complement;

    @Column(length = 10, nullable = false)
    private String phone;

    @Column(name="social_security_number", length = 11, nullable = false)
    private String socialSecurityNumber;

    @OneToMany(mappedBy = "owner")
    private List<Pet> pets;

}
