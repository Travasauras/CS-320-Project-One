// Programmer: Travis Erwin
// Date: Feb 12, 2026
// ContactServiceTest.java
// Course: CS-320
// Instructor: Sherif Antoun
package contactServiceTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import contactService.ContactService;
import contactService.Contact;


class ContactServiceTest {

	@Test
	// Test adding a contact
	void testAddContact() {
		ContactService service = new ContactService();
		service.addContact("351351", "Travis", "Erwin", "3165556996", "4505 North Happy Street");
		
		// Retrieve the contact to verify it was added correctly
		Contact contact = service.getContactByID("351351");
		assertTrue(contact.getContactID().equals("351351"));
		assertTrue(contact.getFirstName().equals("Travis"));
		assertTrue(contact.getLastName().equals("Erwin"));
		assertTrue(contact.getPhone().equals("3165556996"));
		assertTrue(contact.getAddress().equals("4505 North Happy Street"));
		
	}
	@Test
	// Test retrieving a contact with an null ID
	void testGetContactByIDNull() {
		ContactService service = new ContactService();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.getContactByID(null);
		});
	}
	
	@Test
	// Test retrieving a contact with an ID that is too long
	void testGetContactByIDTooLong() {
		ContactService service = new ContactService();
	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.getContactByID("35135112345");
		});
	}
	
	@Test
	// Test adding a contact with null fields
	void testAddContactNull() {
		ContactService service = new ContactService();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addContact(null, "Travis", "Erwin", "3165556996", "4505 North Happy Street");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addContact("351351", null, "Erwin", "3165556996", "4505 North Happy Street");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addContact("351351", "Travis", null, "3165556996", "4505 North Happy Street");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addContact("351351", "Travis", "Erwin", null, "4505 North Happy Street");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addContact("351351", "Travis", "Erwin", "3165556996", null);
		});
		
	}
	
	@Test
	// Test adding a contact with fields that are too long
	void testAddContactTooLong() {
		ContactService service = new ContactService();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addContact("35135112345", "Travis", "Erwin", "3165556996", "4505 North Happy Street");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addContact("351351", "Travis12345", "Erwin", "3165556996", "4505 North Happy Street");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addContact("351351", "Travis", "Erwin123456", "3165556996", "4505 North Happy Street");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addContact("351351", "Travis", "Erwin", "31655569965", "4505 North Happy Street");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addContact("351351", "Travis", "Erwin", "3165556996", "4505 North Happy Street adding extra characters to make this too long for the address field");
		});
		
	}
		

	@Test
	// Test adding a contact with a duplicate ID
	void testAddContactUniqueIDcheck() {
		ContactService service = new ContactService();
		service.addContact("351351", "Travis", "Erwin", "3165556996", "4505 North Happy Street");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addContact("351351", "NotTravis", "NotErwin", "6996555316", "5054 South Sad Street");
		});
	}
	
	@Test
	// Test deleting a contact
	void testDeleteContact() {
		ContactService service = new ContactService();
		service.addContact("351351", "Travis", "Erwin", "3165556996", "4505 North Happy Street");
		service.deleteContact("351351");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.getContactByID("351351");
		});
	}
	
	@Test
	// Test deleting a contact with a null ID
	void testDeleteContactNull() {
		ContactService service = new ContactService();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.deleteContact(null);
		});
	}
	
	@Test
	// Test deleting a contact with an ID that is too long
	void testDeleteContactTooLong() {
		ContactService service = new ContactService();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.deleteContact("35135112345");
		});
	}
	
	@Test
	//test deleting a contact with an ID that does not exist
	void testDeleteContactNotFound() {
		ContactService service = new ContactService();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.deleteContact("351351");
		});
	}
	@Test
	// Test updating a contact
	void testUpdateContact() {
		ContactService service = new ContactService();
		service.addContact("351351", "Travis", "Erwin", "3165556996", "4505 North Happy Street");
		service.updateContact("351351", "NotTravis", "NotErwin", "6996555316", "5054 South Sad Street");
		
		// Retrieve the contact to verify it was updated correctly
		Contact contact = service.getContactByID("351351");
		assertTrue(contact.getFirstName().equals("NotTravis"));
		assertTrue(contact.getLastName().equals("NotErwin"));
		assertTrue(contact.getPhone().equals("6996555316"));
		assertTrue(contact.getAddress().equals("5054 South Sad Street"));
	}
	@Test
	// Test updating a contact with null fields
	void testUpdateContactNull() {
		ContactService service = new ContactService();
		service.addContact("351351", "Travis", "Erwin", "3165556996", "4505 North Happy Street");
		
		service.updateContact("351351", null, null, null, null);
		
		Contact c = service.getContactByID("351351");
		assertTrue(c.getFirstName().equals("Travis"));
		assertTrue(c.getLastName().equals("Erwin"));
		assertTrue(c.getPhone().equals("3165556996"));
		assertTrue(c.getAddress().equals("4505 North Happy Street"));
		}
	
	@Test
	// Test updating a contact with an ID that is null
	void testUpdateContactIDNull() {
		ContactService service = new ContactService();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updateContact(null, "NotTravis", "NotErwin", "6996555316", "5054 South Sad Street");
		});
	}
	
	@Test
	// Test updating a contact with an ID that is too long
	void testUpdateContactIDTooLong() {
		ContactService service = new ContactService();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updateContact("35135112345", "NotTravis", "NotErwin", "6996555316", "5054 South Sad Street");
		});
	}
	
	@Test
	// Test updating a contact with an ID that does not exist
	void testUpdateContactIDNotFound() {
		ContactService service = new ContactService();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updateContact("351351", "NotTravis", "NotErwin", "6996555316", "5054 South Sad Street");
		});
	}
	
	
}
