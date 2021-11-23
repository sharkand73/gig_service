package com.sharkey.music.gigservice.components;

import com.sharkey.music.gigservice.models.*;
import com.sharkey.music.gigservice.models.enums.InstrumentName;
import com.sharkey.music.gigservice.models.enums.SkillName;
import com.sharkey.music.gigservice.models.enums.StyleName;
import com.sharkey.music.gigservice.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements ApplicationRunner {


    @Autowired
    AddressRepository addressRepository;
    @Autowired
    DetailsRepository detailsRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    InstrumentRepository instrumentRepository;
    @Autowired
    ActRepository actRepository;
    @Autowired
    SkillRepository skillRepository;
    @Autowired
    StyleRepository styleRepository;
    @Autowired
    VenueRepository venueRepository;


    public DataLoader(){
    }

    public void run(ApplicationArguments args) {

        Address euanAddress = new Address("36 Regent Park Square", "Strathbungo", "Glasgow", "", "G41 2AG", "U.K.");
        addressRepository.save(euanAddress);
        Details euanDetails = new Details(euanAddress, "07985 001812", "", "euanstevenson@gmail.com", "");
        detailsRepository.save(euanDetails);
        Instrument euanPiano = new Instrument(InstrumentName.PIANO);
        instrumentRepository.save(euanPiano);
        Person euan = new Person("Euan", "Stevenson", euanDetails, null);
        euan.addInstrument(euanPiano);
        personRepository.save(euan);

        Skill reading = new Skill(SkillName.READING);
        skillRepository.save(reading);
        Skill chordCharts = new Skill(SkillName.CHORD_CHARTS);
        skillRepository.save(chordCharts);
        Skill improvising = new Skill(SkillName.IMPROVISING);
        skillRepository.save(improvising);
        Skill learningSongs = new Skill(SkillName.LEARNING_SONGS);
        skillRepository.save(learningSongs);
        Skill doubling = new Skill(SkillName.DOUBLING);
        skillRepository.save(doubling);
        Skill arco = new Skill(SkillName.ARCO);
        skillRepository.save(arco);

        Style jazz = new Style(StyleName.JAZZ);
        styleRepository.save(jazz);
        Style vocalJazz = new Style(StyleName.VOCAL_JAZZ);
        styleRepository.save(vocalJazz);
        Style bebop = new Style(StyleName.BEBOP);
        styleRepository.save(bebop);
        Style gypsy = new Style(StyleName.GYPSY_JAZZ);
        styleRepository.save(gypsy);
        Style bigBand = new Style(StyleName.BIG_BAND);
        styleRepository.save(bigBand);
        Style blues = new Style(StyleName.BLUES);
        styleRepository.save(blues);
        Style cabaret = new Style(StyleName.CABARET);
        styleRepository.save(cabaret);
        Style covers = new Style(StyleName.COVERS);
        styleRepository.save(covers);
        Style dixieland = new Style(StyleName.DIXIELAND);
        styleRepository.save(dixieland);
        Style earlyJazz = new Style(StyleName.EARLY_JAZZ);
        styleRepository.save(earlyJazz);
        Style folk = new Style(StyleName.FOLK);
        styleRepository.save(folk);
        Style funk = new Style(StyleName.FUNK);
        styleRepository.save(funk);
        Style fusion= new Style(StyleName.FUSION);
        styleRepository.save(fusion);
        Style latin = new Style(StyleName.LATIN);
        styleRepository.save(latin);
        Style modernJazz = new Style(StyleName.MODERN_JAZZ);
        styleRepository.save(modernJazz);
        Style newOrleans = new Style(StyleName.NEW_ORLEANS);
        styleRepository.save(newOrleans);
        Style pop = new Style(StyleName.POP);
        styleRepository.save(pop);
        Style rock = new Style(StyleName.ROCK);
        styleRepository.save(rock);
        Style rockNRoll = new Style(StyleName.ROCK_N_ROLL);
        styleRepository.save(rockNRoll);
        Style soul = new Style(StyleName.SOUL);
        styleRepository.save(soul);
        Style singerSongwriter = new Style(StyleName.SINGER_SONGWRITER);
        styleRepository.save(singerSongwriter);
        Style swing = new Style(StyleName.SWING);
        styleRepository.save(swing);
        Style westEnd = new Style(StyleName.WEST_END_MUSICAL);
        styleRepository.save(westEnd);


    }
}
