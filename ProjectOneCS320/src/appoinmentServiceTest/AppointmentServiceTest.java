//Programmer: Travis Erwin
//Date: Feb 12, 2026
//AppointmentServiceTest.java
//Course: CS-320
//Instructor: Sherif Antoun

package appoinmentServiceTest;

import static org.junit.jupiter.api.Assertions.*;
import appointmentService.AppointmentService;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.Calendar;



class AppointmentServiceTest {

	@Test
	// Test for valid appointment creation
	void testaddAppointment() {
		AppointmentService service = new AppointmentService();
		Date date = new Date();
		
		service.addAppointment("05181987", date, "Appointment Test");
		
		
		// Retrieve the appointment to verify it was added correctly
		assertTrue(service.getAppointmentByID("05181987").getAppointmentID().equals("05181987"));
		assertTrue(service.getAppointmentByID("05181987").getAppointmentDate().equals(date));
		assertTrue(service.getAppointmentByID("05181987").getDescription().equals("Appointment Test"));
	}
	@Test
		// Ensure null fields are not accepted in add appointment method
	void testaddAppointmentNull() {
		AppointmentService service = new AppointmentService();
		 
	assertThrows(IllegalArgumentException.class, () -> {
			 service.addAppointment(null, new Date(), "Appointment Test");
		 });
		 assertThrows(IllegalArgumentException.class, () -> {
			 service.addAppointment("05181987", null, "Appointment Test");
		 });
		 assertThrows(IllegalArgumentException.class, () -> {
			 service.addAppointment("05181987", new Date(), null);
			});
	}
	
	@Test
	// Ensure past date is not accepted in add appointment method
	void testaddAppointmentPastDate() {
		AppointmentService service = new AppointmentService();
		 assertThrows(IllegalArgumentException.class, () -> {
			 service.addAppointment("05181987", new Date(0), "Appointment Test");
			});
	}
	
	@Test
	// Ensure fields that are too long are not accepted in add appointment method
	void testaddAppointmentTooLong() {
		AppointmentService service = new AppointmentService();
		 assertThrows(IllegalArgumentException.class, () -> {
			 service.addAppointment("051819871234", new Date(), "Appointment Test");
			});
		 assertThrows(IllegalArgumentException.class, () -> {
			 service.addAppointment("05181987", new Date(), "Appointment Test that is too long and should throw an exception");
			});
		 
	}
	
	
	@Test
	// Test adding an appointment with a duplicate ID
	void testAddAppointmentUniqueIDcheck() {
		AppointmentService service = new AppointmentService();
		
		// set date to tomorrow for valid date to avoid past date exception during appointment creation
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, 1); 
		Date date = cal.getTime();
		
		// add an appointment and then attempt to add another appointment with the same ID throw an exception if appointment ID is not unique
		service.addAppointment("05181987", date, "Appointment Test");
		assertThrows(IllegalArgumentException.class, () -> {
			service.addAppointment("05181987", date, "Not Appointment Test");
		});
		
	}
	
	@Test
	// Test adding appointment with a null field
	void testAddAppointmentNull() {
		AppointmentService service = new AppointmentService();
	
		 assertThrows(IllegalArgumentException.class, () -> {
			 service.addAppointment(null, new Date(), "Appointment Test");
		 });
		 assertThrows(IllegalArgumentException.class, () -> {
			 service.addAppointment("05181987", null, "Appointment Test");
		 });
		 assertThrows(IllegalArgumentException.class, () -> {
			 service.addAppointment("05181987", new Date(), null);
		 });
		 assertThrows(IllegalArgumentException.class, () -> {
			 service.addAppointment("05181987", new Date(0), "Appointment Test");
		 });
	}
	
	@Test
	// Test deleting an appointment
	void testDeleteAppointment() {
		AppointmentService service = new AppointmentService();
		Date date = new Date();
		
		service.addAppointment("05181987", date, "Appointment Test");
		service.deleteAppointment("05181987");
		
		// Attempt to retrieve the deleted appointment
		assertThrows(IllegalArgumentException.class, () -> {
			service.getAppointmentByID("05181987");
		});
	}
	
	@Test
	// Test adding an appointment with an ID that is too long
	void testAddAppointmentIDTooLong() {
		AppointmentService service = new AppointmentService();
		
		 assertThrows(IllegalArgumentException.class, () -> {
			 service.addAppointment("051819871234", new Date(), "Appointment Test");
		 });
		 assertThrows(IllegalArgumentException.class, () -> {
			 service.addAppointment("05181987", new Date(), "Appointment Test that is too long and should throw an exception");
		 });
		
	}
	@Test
	// Test getting an appointment by a null field
	void testGetAppointmentByIDNull() {
		AppointmentService service = new AppointmentService();
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.getAppointmentByID(null);
		});
	}
	
	@Test
	// Test getting an appointment by an ID that is too long
	void testGetAppointmentByIDTooLong() {
		AppointmentService service = new AppointmentService();
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.getAppointmentByID("051819871234");
		});
	}
	
	@Test
	// Test get appointment by an ID that does not exist
	void testGetAppointmentByIDNotFound() {
		AppointmentService service = new AppointmentService();
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.getAppointmentByID("NonExistentID");
		});
	}
	
	@Test
	// Test deleting an appointment with an ID that is too long
	void testDeleteAppointmentIDTooLong() {
		AppointmentService service = new AppointmentService();
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.deleteAppointment("051819871234");
		});
	}
	
	@Test
	// Test deleting an appointment with an ID that doesn't exist
	void testDeleteAppointmentIDNotFound() {
		AppointmentService service = new AppointmentService();
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.deleteAppointment("NonExistentID");
		});
	}
	
	@Test
	// Test deleting an appointment with a null ID
	void testDeleteAppointmentIDNull() {
		AppointmentService service = new AppointmentService();
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.deleteAppointment(null);
		});
	}
	
	@Test
	// Test else condition in delete appointment method by attempting to delete an appointment that does not exist
	void testDeleteAppointmentIDNotFoundBranch() {
		AppointmentService service = new AppointmentService();
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.deleteAppointment("05181987");
		});
	}
}
