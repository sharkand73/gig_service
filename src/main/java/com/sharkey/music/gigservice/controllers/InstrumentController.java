package com.sharkey.music.gigservice.controllers;

import com.sharkey.music.gigservice.models.Instrument;
import com.sharkey.music.gigservice.models.Style;
import com.sharkey.music.gigservice.repositories.InstrumentRepository;
import com.sharkey.music.gigservice.repositories.StyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InstrumentController {
    @Autowired
    InstrumentRepository instrumentRepository;

    @GetMapping(value = "/instruments")
    public List<Instrument> getAllStyles() {return instrumentRepository.findAll();}
}
