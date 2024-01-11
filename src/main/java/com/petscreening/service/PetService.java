package com.petscreening.service;

import com.petscreening.model.Breed;
import com.petscreening.model.Owner;
import com.petscreening.model.Pet;
import com.petscreening.model.dto.PetDto;
import com.petscreening.repository.BreedRepository;
import com.petscreening.repository.OwnerRepository;
import com.petscreening.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetService {
    private final PetRepository petRepository;
    private final OwnerRepository ownerRepository;
    private final BreedRepository breedRepository;

    public PetService(PetRepository petRepository, OwnerRepository ownerRepository,
                      BreedRepository breedRepository) {
        this.petRepository = petRepository;
        this.ownerRepository = ownerRepository;
        this.breedRepository = breedRepository;
    }

    public BigInteger registerPet(PetDto petDto) {

        Owner owner = ownerRepository
                .findById(petDto.ownerId()).orElseThrow(() -> new IllegalArgumentException("Invalid owner!"));
        Breed breed = breedRepository
                .findById(petDto.breedId()).orElseThrow(() -> new IllegalArgumentException("Invalid breed!"));

        Pet pet = Pet.builder().
                name(petDto.name())
                .breed(breed)
                .weight(petDto.weight())
                .vaccinationStatus(petDto.vaccinationStatus())
                .trainingLevel(petDto.trainingLevel())
                .owner(owner)
                .build();

        return petRepository.save(pet).getId();

    }

    public List<PetDto> getEligiblePets() {
        List<Pet> eligiblePets = petRepository.getEligiblePets();
        return eligiblePets.stream()
                .map(p -> PetDto.builder()
                        .id(p.getId())
                        .name(p.getName())
                        .breedId(p.getBreed().getId())
                        .weight(p.getWeight())
                        .vaccinationStatus(p.isVaccinationStatus())
                        .trainingLevel(p.getTrainingLevel())
                        .ownerId(p.getOwner().getId())
                        .build()
                ).collect(Collectors.toList());
    }

}
