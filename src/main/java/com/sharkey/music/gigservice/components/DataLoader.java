package com.sharkey.music.gigservice.components;

import com.sharkey.music.gigservice.models.*;
import com.sharkey.music.gigservice.models.enums.*;
import com.sharkey.music.gigservice.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    ActRepository actRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    DetailsRepository detailsRepository;
    @Autowired
    GigRepository gigRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    InstrumentRepository instrumentRepository;
    @Autowired
    OrganisationRepository organisationRepository;
    @Autowired
    SkillRepository skillRepository;
    @Autowired
    StyleRepository styleRepository;
    @Autowired
    VenueRepository venueRepository;


    public DataLoader(){
    }

    public void run(ApplicationArguments args) {

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



//        Address euanAddress = new Address("36 Regent Park Square", "Strathbungo", "Glasgow", "", "G41 2AG", "U.K.");
//        addressRepository.save(euanAddress);
//        Details euanDetails = new Details(euanAddress, "07985 001812", "", "euanstevenson@gmail.com", "");
//        detailsRepository.save(euanDetails);
//        Instrument euanPiano = new Instrument(InstrumentName.PIANO);
//        instrumentRepository.save(euanPiano);
//        Person euan = new Person("Euan", "Stevenson", euanDetails, null);
//        euan.addInstrument(euanPiano);
//        personRepository.save(euan);
//
//        Address rsnoAddress = new Address("19 Killermont Street", "", "Glasgow", "", "G2 3NX", "U.K.");
//        addressRepository.save(rsnoAddress);
//        Organisation rsno = new Organisation("The R.S.N.O.", rsnoAddress);
//        organisationRepository.save(rsno);
//        Person emmaH = new Person("Emma", "Hunter", null, rsno);
//        personRepository.save(emmaH);
//
//        Booking rsnoBooking = new Booking(emmaH, LocalDate.of(2021,11,24), BookingMethod.EMAIL, "", 350);
//        rsnoBooking.setStatus(BookingStatus.UNCONFIRMED);
//        bookingRepository.save(rsnoBooking);
//
//        Act rsnoAct = new Act("The R.S.N.O.", false, DressCode.WHITE_JACKET);
//        rsnoAct.addStyle(westEnd);
//        rsnoAct.addStyle(pop);
//        rsnoAct.addSkill(reading);
//        actRepository.save(rsnoAct);
//
//
//        Address grchAddress = new Address("2 Sauchiehall Street", "", "Glasgow", "", "G2 3NY", "U.K.");
//        Address usherAddress = new Address("Lothian Road", "", "Edinburgh", "", "EH1 2EA", "U.K.");
//        addressRepository.save(grchAddress);
//        addressRepository.save(usherAddress);
//
//        Venue rsnoCentre = new Venue("The R.S.N.O. Centre", rsnoAddress, VenueType.OTHER);
//        venueRepository.save(rsnoCentre);
//        Venue grch = new Venue("Glasgow Royal Concert Hall", grchAddress, VenueType.CONCERT_HALL);
//        venueRepository.save(grch);
//        Venue usherHall = new Venue("Usher Hall", usherAddress, VenueType.CONCERT_HALL);
//        venueRepository.save(usherHall);
//
//        Gig rsnoGig1 = new Gig(rsnoBooking,
//                                rsnoAct,
//                                LocalDateTime.of(2021,12, 1, 9, 30, 0),
//                                LocalDateTime.of(2021,12, 1, 10, 00, 0),
//                                LocalDateTime.of(2021,12, 1, 13, 00, 0),
//                                180, rsnoCentre, true, DressCode.CASUAL, false, false);
//
//        Gig rsnoGig2 = new Gig(rsnoBooking,
//                rsnoAct,
//                LocalDateTime.of(2021,12, 4, 10, 00, 0),
//                LocalDateTime.of(2021,12, 4, 10, 30, 0),
//                LocalDateTime.of(2021,12, 4, 16, 30, 0),
//                240, grch, false, DressCode.WHITE_JACKET, true, false);
//
//        Gig rsnoGig3 = new Gig(rsnoBooking,
//                rsnoAct,
//                LocalDateTime.of(2021,12, 5, 10, 00, 0),
//                LocalDateTime.of(2021,12, 5, 10, 30, 0),
//                LocalDateTime.of(2021,12, 5, 16, 30, 0),
//                240, usherHall, false, DressCode.WHITE_JACKET, true, false);
//
//        gigRepository.save(rsnoGig1);
//        gigRepository.save(rsnoGig2);
//        gigRepository.save(rsnoGig3);

    }



}
