//Programmer: Travis Erwin
//Date: Feb 12, 2026
//AppointmentTest.java
//Course: CS-320
//Instructor: Sherif Antoun

package appoinmentServiceTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import appointmentService.Appointment;
import java.util.Calendar;
import java.util.Date;



class AppointmentTest {

	@Test
	void test() {
		Date date = new Date();
		Appointment appointment = new Appointment("05181987", date, "Appointment Test");
		
		assertTrue(appointment.getAppointmentID().equals("05181987"));
		assertTrue(appointment.getAppointmentDate().equals(date));
		assertTrue(appointment.getDescription().equals("Appointment Test"));
		
	}
	
	@Test
	// Test for null fields
	void testAppointmentNull() {
		Date date = new Date();
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, date, "Appointment Test");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("05181987", null, "Appointment Test");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("05181987", date, null);
		});
	}
	
	@Test
	// Test for past date field
	void testAppointmentPastDate() {
		Date pastDate = new Date(0);
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("05181987", pastDate, "Appointment Test");
		});
	}
	
	@Test
	// Test for fields that are too long
	void testAppointmentTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("051819871234", new Date(), "Appointment Test");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("05181987", new Date(), "This description is definitely way too long to be valid because it exceeds fifty characters.");
		});
	}
	
	@Test
	// Test setters
	void testSetters() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, 1); 
		Date date = cal.getTime();
		
		Appointment appointment = new Appointment("05181987", date, "Appointment Test");
		
		cal.add(Calendar.DAY_OF_YEAR, 1);
		Date newDate = cal.getTime();
		appointment.setAppointmentDate(newDate);
		assertTrue(appointment.getAppointmentDate().equals(newDate));
		
		// Set new valid description
		appointment.setDescription("Set Description Test");
		assertTrue(appointment.getDescription().equals("Set Description Test"));
		
		// Test for invalid date
		Date pastDate = new Date(0);
		assertThrows(IllegalArgumentException.class, () -> {
			appointment.setAppointmentDate(pastDate);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			appointment.setAppointmentDate(null);
		});
		
		// Test for invalid description
		assertThrows(IllegalArgumentException.class, () -> {
			appointment.setDescription(null);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			appointment.setDescription("This description is definitely way too long to be valid because it exceeds fifty characters.");
		});
	}
}
