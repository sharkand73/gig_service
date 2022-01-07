package com.sharkey.music.gigservice;

import com.sharkey.music.gigservice.models.*;
import com.sharkey.music.gigservice.models.enums.BookingMethod;
import com.sharkey.music.gigservice.models.enums.BookingStatus;
import com.sharkey.music.gigservice.models.enums.DressCode;
import com.sharkey.music.gigservice.models.enums.VenueType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GigserviceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void canCreateAddress(){
	Address royAddress =  new Address("Lady Road", "","Edinburgh", "", "EH16 5PA","U.K.");
	assertEquals("EH16 5PA", royAddress.getPostcode());
	}

	@Test
	void canCreateDetails(){
		Address royAddress =  new Address("Lady Road", "","Edinburgh", "", "EH16 5PA","U.K.");
		Details royDetails = new Details(royAddress, "07884 184925", "", "roy.percy4@gmail.com", "");
		assertEquals("07884 184925", royDetails.getMobile());
		assertEquals("EH16 5PA", royDetails.getAddress().getPostcode());
	}

	@Test
	void canCreatePerson(){
		Address royAddress =  new Address("Lady Road", "","Edinburgh", "", "EH16 5PA","U.K.");
		Details royDetails = new Details(royAddress, "07884 184925", "", "roy.percy4@gmail.com", "");
		Person roy = new Person("Roy", "Percy", royDetails, null);
		assertEquals("Percy", roy.getLastName());
		assertEquals("07884 184925", roy.getDetails().getMobile());
		assertEquals("EH16 5PA", roy.getDetails().getAddress().getPostcode());
	}

	@Test
	void canGetPersonDetails(){
		Address royAddress =  new Address("Lady Road", "","Edinburgh", "", "EH16 5PA","U.K.");
		Details royDetails = new Details(royAddress, "07884 184925", "", "roy.percy4@gmail.com", "");
		Person roy = new Person("Roy", "Percy", royDetails, null);
		assertEquals("07884 184925", roy.findMobile());
		assertEquals("EH16 5PA", roy.findPostcode());
	}

	@Test
	void canCreateVenue(){
		Address venueAddress =  new Address("Guild Street", "","Aberdeen", "", "AB1 1AA","U.K.");
		Venue tivoli = new Venue("Tivoli Theatre", venueAddress, VenueType.SMALL_THEATRE);
		assertEquals("Tivoli Theatre", tivoli.getName());
		assertEquals("AB1 1AA", tivoli.getAddress().getPostcode());
	}

	@Test
	void canCreateAct() {
		Act absoluteElvis = new Act("Absolute Elvis", true, DressCode.ALL_BLACK);
		assertTrue(absoluteElvis.getPrepRequired());
	}

	@Test
	void canCreateBookingGroup() {
		Address rsnoAddress =  new Address("19 Killermont Street", "","Glasgow", "", "G2 3NX","U.K.");
		Organisation rsno = new Organisation( "The R.S.N.O.", rsnoAddress);
		Person emma = new Person("Emma", "Hunter", null, rsno);
		BookingGroup octGigs = new BookingGroup(emma, LocalDate.of(2021, 9, 17));
		assertEquals("The R.S.N.O.", octGigs.getBooker().getOrganisation().getName());
		assertEquals(9, octGigs.getBookingDate().getMonthValue());
	}

	@Test
	void canCreateBookings() {
		Address rsnoAddress =  new Address("19 Killermont Street", "","Glasgow", "", "G2 3NX","U.K.");
		Organisation rsno = new Organisation( "The R.S.N.O.", rsnoAddress);
		Person emma = new Person("Emma", "Hunter", null, rsno);
		BookingGroup octGigs = new BookingGroup(emma, LocalDate.of(2021, 9, 17));

		Booking glaBooking = new Booking(100, BookingStatus.CLOSED);
		glaBooking.setBookingGroup(octGigs);
		Booking ediBooking = new Booking(100, BookingStatus.CLOSED);
		ediBooking.setBookingGroup(octGigs);
		assertEquals("Hunter", ediBooking.getBookingGroup().getBooker().getLastName());
	}
}
