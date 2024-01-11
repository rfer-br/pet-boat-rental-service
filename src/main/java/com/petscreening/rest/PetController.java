package com.petscreening.rest;

import com.petscreening.model.dto.PetDto;
import com.petscreening.service.PetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/boat-rental/pets")
@Slf4j
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> registerPet(@Validated @RequestBody final PetDto petDto) {
        try {
            return new ResponseEntity<>(petService.registerPet(petDto), HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            log.error("Invalid request received!", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            log.error("Unknown exception when processing request!", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<PetDto>> getEligiblePets() {
        try {
            return new ResponseEntity<>(petService.getEligiblePets(), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            log.error("Unknown exception when processing request!", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
