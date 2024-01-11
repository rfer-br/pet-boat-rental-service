package com.petscreening.model.dto;

import lombok.Builder;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;


@Builder
public record PetDto(BigInteger id, @NotNull(message = "name is mandatory") String name,
                     @NotNull(message = "weight is mandatory") Integer weight,
                     @NotNull(message = "vaccinationStatus is mandatory") boolean vaccinationStatus,
                     @NotNull(message = "trainingLevel is mandatory") @Min(1) @Max(10) Integer trainingLevel,
                     @NotNull(message = "owner is mandatory") BigInteger ownerId,
                     @NotNull(message = "breed' is mandatory") Integer breedId) {
}