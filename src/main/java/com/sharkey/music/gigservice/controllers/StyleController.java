package com.sharkey.music.gigservice.controllers;

import com.sharkey.music.gigservice.models.Act;
import com.sharkey.music.gigservice.models.Style;
import com.sharkey.music.gigservice.repositories.StyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StyleController {
    @Autowired
    StyleRepository styleRepository;

    @GetMapping(value = "/styles")
    public List<Style> getAllStyles() {return styleRepository.findAll();}
}
