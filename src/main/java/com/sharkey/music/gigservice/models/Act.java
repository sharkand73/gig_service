package com.sharkey.music.gigservice.models;

import java.util.ArrayList;
import java.util.List;

public class Act {

    private String name;
    private List<Style> styles;
    private List<Skill> skillsRequired;
    private boolean prepRequired;
    private DressCode defaultDressCode;

    public Act(String name, boolean prepRequired, DressCode defaultDressCode){
        this.name = name;
        this.styles = new ArrayList<>();
        this.skillsRequired = new ArrayList<>();
        this.prepRequired = prepRequired;
        this.defaultDressCode = defaultDressCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Style> getStyles() {
        return styles;
    }

    public void setStyles(List<Style> styles) {
        this.styles = styles;
    }

    public List<Skill> getSkillsRequired() {
        return skillsRequired;
    }

    public void setSkillsRequired(List<Skill> skillsRequired) {
        this.skillsRequired = skillsRequired;
    }

    public boolean getPrepRequired() {
        return prepRequired;
    }

    public void setPrepRequired(boolean prepRequired) {
        this.prepRequired = prepRequired;
    }

    public DressCode getDefaultDressCode() {
        return defaultDressCode;
    }

    public void setDefaultDressCode(DressCode defaultDressCode) {
        this.defaultDressCode = defaultDressCode;
    }
}
