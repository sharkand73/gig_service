package com.sharkey.music.gigservice.controllers;

import com.sharkey.music.gigservice.models.Act;
import com.sharkey.music.gigservice.models.Venue;
import com.sharkey.music.gigservice.repositories.ActRepository;
import com.sharkey.music.gigservice.repositories.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VenueController {
    @Autowired
    VenueRepository venueRepository;

    @GetMapping(value = "/venues")
    public List<Venue> getAllVenues() {return venueRepository.findAll();}
}
