package com.sharkey.music.gigservice;

import com.sharkey.music.gigservice.models.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GigserviceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void canCreateAddress(){
	Address euanAddress =  new Address("36 Regent Park Square", "Strathbungo","Glasgow", "", "G41 2AG","U.K.");
	assertEquals("Strathbungo", euanAddress.getAddressLine2());
	}

	@Test
	void canCreateDetails(){
		Address euanAddress =  new Address("36 Regent Park Square", "Strathbungo","Glasgow", "", "G41 2AG","U.K.");
		Details euanDetails = new Details(euanAddress, "07985 001812", "", "euanstevenson@gmail.com", "");
		assertEquals("07985 001812", euanDetails.getMobile());
		assertEquals("G41 2AG", euanDetails.getAddress().getPostcode());
	}

	@Test
	void canCreatePerson(){
		Address euanAddress =  new Address("36 Regent Park Square", "Strathbungo","Glasgow", "", "G41 2AG","U.K.");
		Details euanDetails = new Details(euanAddress, "07985 001812", "", "euanstevenson@gmail.com", "");
		Person euan = new Person("Euan", "Stevenson", euanDetails, null);
		assertEquals("Stevenson", euan.getLastName());
		assertEquals("07985 001812", euan.getDetails().getMobile());
		assertEquals("G41 2AG", euan.getDetails().getAddress().getPostcode());
	}

	@Test
	void canGetPersonDetails(){
		Address euanAddress =  new Address("36 Regent Park Square", "Strathbungo","Glasgow", "", "G41 2AG","U.K.");
		Details euanDetails = new Details(euanAddress, "07985 001812", "", "euanstevenson@gmail.com", "");
		Person euan = new Person("Euan", "Stevenson", euanDetails, null);
		assertEquals("07985 001812", euan.getMobile());
		assertEquals("G41 2AG", euan.getPostcode());
	}

	@Test
	void canCreateBooking(){
		Address euanAddress =  new Address("36 Regent Park Square", "Strathbungo","Glasgow", "", "G41 2AG","U.K.");
		Details euanDetails = new Details(euanAddress, "07985 001812", "", "euanstevenson@gmail.com", "");
		Person euan = new Person("Euan", "Stevenson", euanDetails, null);
		String message = "Hi Andy, are you free for a gig on 25th December 1-5pm at Gelneagles, fee £280?";

		Booking fakeBooking = new Booking(euan, LocalDate.of(2021,11, 13), BookingMethod.TEXT, message, 180);
		assertEquals("Euan", fakeBooking.getBooker().getFirstName());
		assertEquals(13, fakeBooking.getBookingDate().getDayOfMonth());
		assertEquals(180.00, fakeBooking.getFee());
		assertEquals("TEXT", fakeBooking.getBookingMethod().toString());
	}

	@Test
	void paramsStartProperly(){
		Address euanAddress =  new Address("36 Regent Park Square", "Strathbungo","Glasgow", "", "G41 2AG","U.K.");
		Details euanDetails = new Details(euanAddress, "07985 001812", "", "euanstevenson@gmail.com", "");
		Person euan = new Person("Euan", "Stevenson", euanDetails, null);
		String message = "Hi Andy, are you free for a gig on 25th December 1-5pm at Gelneagles, fee £280?";

		Booking fakeBooking = new Booking(euan, LocalDate.of(2021,11, 13), BookingMethod.TEXT, message, 180);

		assertEquals("CONFIRMED", fakeBooking.getStatus().toString());
		assertNull(fakeBooking.getDateConfirmed());
		assertNull(fakeBooking.getDateCancelled());
		assertEquals(0, fakeBooking.getExpenses());
	}

	@Test
	void canCreateVenue(){
		Address venueAddress =  new Address("Guild Street", "","Aberdeen", "", "AB1 1AA","U.K.");
		Venue tivoli = new Venue("Tivoli Theatre", venueAddress, VenueType.SMALL_THEATRE);
		assertEquals("Tivoli Theatre", tivoli.getName());
		assertEquals("AB1 1AA", tivoli.getAddress().getPostcode());
	}

	@Test
	void canCreateAct(){
		Act absoluteElvis = new Act("Absolute Elvis", true, DressCode.ALL_BLACK);
		assertTrue(absoluteElvis.getPrepRequired());
	}


}
