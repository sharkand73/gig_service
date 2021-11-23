package com.sharkey.music.gigservice.controllers;

import com.sharkey.music.gigservice.models.Act;
import com.sharkey.music.gigservice.models.Skill;
import com.sharkey.music.gigservice.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SkillController {
    @Autowired
    SkillRepository skillRepository;

    @GetMapping(value = "/skills")
    public List<Skill> getAllSkills() {return skillRepository.findAll();}
}
