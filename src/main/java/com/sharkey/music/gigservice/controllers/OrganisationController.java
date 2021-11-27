package com.sharkey.music.gigservice.controllers;

import com.sharkey.music.gigservice.models.Organisation;
import com.sharkey.music.gigservice.repositories.OrganisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrganisationController {

    @Autowired
    OrganisationRepository organisationRepository;

    @GetMapping(value = "/organisations")
    public List<Organisation> getAllOrganisations(){
        return organisationRepository.findAll();
    }

}
