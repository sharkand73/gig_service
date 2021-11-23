package com.sharkey.music.gigservice.controllers;

import com.sharkey.music.gigservice.models.Act;
import com.sharkey.music.gigservice.repositories.ActRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActController {
    @Autowired
    ActRepository actRepository;

    @GetMapping(value = "/acts")
    public List<Act> getAllActs() {return actRepository.findAll();}
}
