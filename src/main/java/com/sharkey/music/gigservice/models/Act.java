package com.sharkey.music.gigservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sharkey.music.gigservice.models.enums.DressCode;
import com.sharkey.music.gigservice.models.enums.SkillName;
import com.sharkey.music.gigservice.models.enums.StyleName;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Act")
public class Act {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @JsonIgnoreProperties("acts")
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "act_style",
            joinColumns = {
                    @JoinColumn(name = "act_id", nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "style_id", nullable = false, updatable = false)
            }
    )
    private List<Style> styles;

    @JsonIgnoreProperties("acts")
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "act_skill",
            joinColumns = {
                    @JoinColumn(name = "act_id", nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "skill_id", nullable = false, updatable = false)
            }
    )
    private List<Skill> skillsRequired;

    @Column
    private boolean prepRequired;

    @Column
    private DressCode defaultDressCode;

    @JsonIgnoreProperties("act")
    @OneToMany(mappedBy = "act", fetch = FetchType.LAZY)
    private List<Gig> gigs;

    public Act(String name, boolean prepRequired, DressCode defaultDressCode){
        this.name = name;
        this.styles = new ArrayList<>();
        this.skillsRequired = new ArrayList<>();
        this.prepRequired = prepRequired;
        this.defaultDressCode = defaultDressCode;
    }

    public Act() {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPrepRequired() {
        return prepRequired;
    }

    public List<Gig> getGigs() {
        return gigs;
    }

    public void setGigs(List<Gig> gigs) {
        this.gigs = gigs;
    }

    public void addStyle(Style style) {
        if (!this.styles.contains(style))
        this.styles.add(style);
    }

    public void removeStyle(Style style) {
        if (this.styles.contains(style)){
            this.styles.remove(style);
        }
    }

    public void addSkill(Skill skill) {
        if (!this.skillsRequired.contains(skill))
            this.skillsRequired.add(skill);
    }

    public void removeSkill(Skill skill) {
        if (this.skillsRequired.contains(skill)){
            this.skillsRequired.remove(skill);
        }
    }
}
