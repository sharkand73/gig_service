package com.sharkey.music.gigservice.controllers;

import com.sharkey.music.gigservice.models.Gig;
import com.sharkey.music.gigservice.repositories.GigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GigController {
    @Autowired
    GigRepository gigRepository;

    @GetMapping(value = "/gigs")
    public List<Gig> getAllGigs() {return gigRepository.findAll();}
}
