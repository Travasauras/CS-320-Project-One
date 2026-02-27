// Programmer: Travis Erwin
// Date: Feb 12, 2026
// ContactTest.java
// Course: CS-320
// Instructor: Sherif Antoun

package contactServiceTest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import contactService.Contact;

class ContactTest {

	@Test
	// Test for valid contact creation
	void testContact() {
		Contact contact = new Contact("351351", "Travis", "Erwin", "3165556996", "4505 North Happy Street");
		assertTrue(contact.getContactID().equals("351351"));
		assertTrue(contact.getFirstName().equals("Travis"));
		assertTrue(contact.getLastName().equals("Erwin"));
		assertTrue(contact.getPhone().equals("3165556996"));
		assertTrue(contact.getAddress().equals("4505 North Happy Street"));
	}
	
	@Test
	// Test for null fields
	void testContactNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Travis", "Erwin", "3165556996", "4505 North Happy Street");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("351351", null, "Erwin", "3165556996", "4505 North Happy Street");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("351351", "Travis", null, "3165556996", "4505 North Happy Street");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("351351", "Travis", "Erwin", null, "4505 North Happy Street");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("351351", "Travis", "Erwin", "3165556996", null);
		});
	}
	
	@Test 
	// Test for fields that are too long
	void testContactTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("35135135135", "Travis", "Erwin", "3165556996", "4505 North Happy Street");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("351351", "TravisTravis", "Erwin", "3165556996", "4505 North Happy Street");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("351351", "Travis", "ErwinErwinErwin", "3165556996", "4505 North Happy Street");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("351351", "Travis", "Erwin", "3165556996123", "4505 North Happy Street");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("351351", "Travis", "Erwin", "3165556996", "4505 North Happy Street, Apartment 3999, Wichita, KS 67212");
		});
	}
	
	@Test
	// Test setters
	void testSetters() {
		Contact contact = new Contact("351351", "Travis", "Erwin", "3165556996", "4505 North Happy Street");
		contact.setFirstName("NotTravis");
		contact.setLastName("NotErwin");
		contact.setPhone("3165551237");
		contact.setAddress("4506 North Happy Street");
		
		// Test for null fields
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName(null);
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName(null);
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhone(null);
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress(null);
		});
		
		// Test for fields that are too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName("TravisTravis");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName("ErwinErwinErwin");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhone("3165556996123");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress("4505 North Happy Street, Apartment 3999, Wichita, KS 67212");
		});
		
		
	}
	
}
