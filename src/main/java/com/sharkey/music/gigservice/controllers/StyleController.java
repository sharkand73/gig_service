package com.sharkey.music.gigservice.controllers;

import com.sharkey.music.gigservice.models.Skill;
import com.sharkey.music.gigservice.models.Style;
import com.sharkey.music.gigservice.repositories.StyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StyleController {
    @Autowired
    StyleRepository styleRepository;

    @GetMapping(value = "/styles")
    public List<Style> getAllStyles() {return styleRepository.findAll();}

    @GetMapping(value = "/styles/{id}")
    public ResponseEntity<Style> getStyle(@PathVariable Long id){
        return new ResponseEntity(styleRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/styles")
    public ResponseEntity<Style> postStyle(@RequestBody Style style){
        styleRepository.save(style);
        return new ResponseEntity<>(style, HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/styles/batch")
    public ResponseEntity<List<Style>> postStyles(@RequestBody List<Style> styles){
        for(Style style : styles) {
            styleRepository.save(style);
        }
        return new ResponseEntity<>(styles, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/styles/{id}")
    public ResponseEntity<Long> deleteStyle(@PathVariable Long id){
        styleRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping(value = "/styles/{id}")
    public ResponseEntity<Style> putStyle(@RequestBody Style style, @PathVariable Long id){
        Style foundStyle = styleRepository.findById(id).get();
        foundStyle.setName(style.getName());
        styleRepository.save(foundStyle);
        return new ResponseEntity<>(foundStyle, HttpStatus.OK);
    }
}
