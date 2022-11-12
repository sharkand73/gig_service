package com.sharkey.music.gigservice.controllers;

import com.sharkey.music.gigservice.models.Address;
import com.sharkey.music.gigservice.models.Organisation;
import com.sharkey.music.gigservice.repositories.AddressRepository;
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
    @Autowired
    AddressRepository addressRepository;

    @GetMapping(value = "/organisations")
    public ResponseEntity<List<Organisation>> getAllOrganisations(){
        return new ResponseEntity<>(organisationRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/organisations/count")
    public ResponseEntity<Long> getOrganisationCount(){
        return new ResponseEntity<>(organisationRepository.count(), HttpStatus.OK);
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

    @PostMapping(value = "/organisations/full")
    public ResponseEntity<Organisation> postOrganisationFull(@RequestBody Organisation organisation){
        Address address = organisation.getAddress();
        addressRepository.save(address);
        organisation.setAddress(address);
        organisationRepository.save(organisation);
        return new ResponseEntity<>(organisation, HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/organisations/batch")
    public ResponseEntity<List<Organisation>> postOrganisations(@RequestBody List<Organisation> organisations){
        organisationRepository.saveAll(organisations);
        return new ResponseEntity<>(organisations, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/organisations/{id}")
    public ResponseEntity<Long> deleteOrganisation(@PathVariable Long id){
        Organisation organisation = organisationRepository.findById(id).get();
        Address address = organisation.getAddress();
        organisationRepository.delete(organisation);
        addressRepository.delete(address);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping(value = "/organisations/{id}")
    public ResponseEntity<Organisation> putOrganisation(@RequestBody Organisation organisation, @PathVariable Long id){
        Organisation foundOrganisation = organisationRepository.findById(id).get();
        foundOrganisation.setName(organisation.getName());
        Address address = organisation.getAddress();
        foundOrganisation.setAddress(address);
        addressRepository.save(address);
        organisationRepository.save(foundOrganisation);
        return new ResponseEntity<>(foundOrganisation, HttpStatus.OK);
    }

}
