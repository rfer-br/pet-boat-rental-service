package com.petscreening.repository;

import com.petscreening.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface OwnerRepository extends JpaRepository<Owner, BigInteger> {
}
