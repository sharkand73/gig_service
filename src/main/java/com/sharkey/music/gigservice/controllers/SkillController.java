package com.sharkey.music.gigservice.controllers;

import com.sharkey.music.gigservice.models.Address;
import com.sharkey.music.gigservice.models.Skill;
import com.sharkey.music.gigservice.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SkillController {
    @Autowired
    SkillRepository skillRepository;

    @GetMapping(value = "/skills")
    public ResponseEntity<List<Skill>> getAllSkills() {
        return new ResponseEntity<>(skillRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/skills/{id}")
    public ResponseEntity<Skill> getSkill(@PathVariable Long id){
        return new ResponseEntity(skillRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/skills")
    public ResponseEntity<Skill> postSkill(@RequestBody Skill skill){
        skillRepository.save(skill);
        return new ResponseEntity<>(skill, HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/skills/batch")
    public ResponseEntity<List<Skill>> postSkills(@RequestBody List<Skill> skills){
        for(Skill skill : skills) {
            skillRepository.save(skill);
        }
        return new ResponseEntity<>(skills, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/skills/{id}")
    public ResponseEntity<Long> deleteSkill(@PathVariable Long id){
        skillRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping(value = "/skills/{id}")
    public ResponseEntity<Skill> putSkill(@RequestBody Skill skill, @PathVariable Long id){
        Skill foundSkill = skillRepository.findById(id).get();
        foundSkill.setName(skill.getName());
        skillRepository.save(foundSkill);
        return new ResponseEntity<>(foundSkill, HttpStatus.OK);
    }
}
