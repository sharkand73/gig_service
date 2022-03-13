package com.sharkey.music.gigservice.controllers;

import com.sharkey.music.gigservice.models.Organisation;
import com.sharkey.music.gigservice.repositories.OrganisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrganisationController {

    @Autowired
    OrganisationRepository organisationRepository;

    @GetMapping(value = "/organisations")
    public List<Organisation> getAllOrganisations(){
        return organisationRepository.findAll();
    }

    @GetMapping(value = "/organisations/{id}")
    public ResponseEntity<Organisation> getOrganisation(@PathVariable Long id){
        return new ResponseEntity(organisationRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/organisations")
    public ResponseEntity<Organisation> postOrganisation(@RequestBody Organisation organisation){
        organisationRepository.save(organisation);
        return new ResponseEntity<>(organisation, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/organisations/{id}")
    public ResponseEntity<Long> deleteOrganisation(@PathVariable Long id){
        organisationRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }


    @PutMapping(value = "/organisations/{id}")
    public ResponseEntity<Organisation> putOrganisation(@RequestBody Organisation organisation, @PathVariable Long id){
        Organisation foundOrganisation = organisationRepository.findById(id).get();
        foundOrganisation.setName(organisation.getName());
        foundOrganisation.setAddress(organisation.getAddress());
        organisationRepository.save(foundOrganisation);
        return new ResponseEntity<>(foundOrganisation, HttpStatus.OK);
    }

}
