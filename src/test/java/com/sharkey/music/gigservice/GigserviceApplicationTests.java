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
	void canCreatePayment(){
		Payment elvisAberdeen = new Payment(150.00, PaymentMethod.BACS);
		assertEquals("BACS", elvisAberdeen.getPaymentMethod().toString());
	}

	@Test
	void datePaidStartsAsNull(){
		Payment elvisAberdeen = new Payment(150.00, PaymentMethod.BACS);
		assertNull(elvisAberdeen.getDatePaid());
	}

	@Test
	void paymentWaitStartsAsZero(){
		Payment elvisAberdeen = new Payment(150.00, PaymentMethod.BACS);
		assertEquals(0, elvisAberdeen.getPaymentWaitInDays());
	}

	@Test
	void canCreateBooking(){
		Address euanAddress =  new Address("36 Regent Park Square", "Strathbungo","Glasgow", "", "G41 2AG","U.K.");
		Details euanDetails = new Details(euanAddress, "07985 001812", "", "euanstevenson@gmail.com", "");
		Person euan = new Person("Euan", "Stevenson", euanDetails, null);
		Payment euanGig = new Payment(180.00, PaymentMethod.BACS);
		String message = "Hi Andy, are you free for a gig on 25th December 1-5pm at Gelneagles, fee £280?";

		Booking fakeBooking = new Booking(euan, LocalDate.of(2021,11, 13), message, BookingMethod.TEXT, euanGig);
		assertEquals("Euan", fakeBooking.getBooker().getFirstName());
		assertEquals(13, fakeBooking.getBookingDate().getDayOfMonth());
		assertEquals(180.00, fakeBooking.getFee().getAmount());
	}

	@Test
	void paramsStartProperly(){
		Address euanAddress =  new Address("36 Regent Park Square", "Strathbungo","Glasgow", "", "G41 2AG","U.K.");
		Details euanDetails = new Details(euanAddress, "07985 001812", "", "euanstevenson@gmail.com", "");
		Person euan = new Person("Euan", "Stevenson", euanDetails, null);
		Payment euanGig = new Payment(180.00, PaymentMethod.BACS);
		String message = "Hi Andy, are you free for a gig on 25th December 1-5pm at Gelneagles, fee £280?";

		Booking fakeBooking = new Booking(euan, LocalDate.of(2021,11, 13), message, BookingMethod.TEXT, euanGig);
		assertFalse(fakeBooking.isCancelled());
		assertFalse(fakeBooking.isConfirmed());
		assertNull(fakeBooking.getDateConfirmed());
		assertNull(fakeBooking.getExpenses());

	}

}
