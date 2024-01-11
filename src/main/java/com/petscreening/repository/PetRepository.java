package com.petscreening.repository;

import com.petscreening.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface PetRepository extends JpaRepository<Pet, BigInteger> {

    @Query(value = "SELECT p FROM Pet p WHERE p.weight<25 and p.vaccinationStatus=true " +
            "and upper(p.breed.name)<>'POODLE' and p.trainingLevel>=3")
    List<Pet> getEligiblePets();

}
