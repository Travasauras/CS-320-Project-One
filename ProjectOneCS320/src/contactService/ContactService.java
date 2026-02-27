// Programmer: Travis Erwin
// Date: Feb 12, 2026
// ContactService.java
// Course: CS-320
// Instructor: Sherif Antoun
package contactService;
import java.util.HashMap;
import java.util.Map;

public class ContactService {
	
	private final Map<String, Contact> contacts = new HashMap<>();
	
	// Retrieve a contact by its ID
	public Contact getContactByID(String contactID) {
		if (contactID == null) {
			throw new IllegalArgumentException("Contact ID cannot be null.");
		}
		
		if (contactID.length() > 10) {
			throw new IllegalArgumentException("Contact ID too long, contact id must be 10 characters or less.");
		}
		
		Contact found = contacts.get(contactID);
		
		if (found == null) {
			throw new IllegalArgumentException("Contact ID not found.");
		}
		
		return found;
		
	}
	
	// Add a new contact with unique ID and valid fields
	public void addContact(String contactID, String firstName, String lastName, String phone, String address) { 
			
		if (contacts.containsKey(contactID)) {
			throw new IllegalArgumentException("Contact ID already exists.  " + contactID + " is already in use.");
		}
		
		if (contactID == null || contactID.length() > 10) {
			throw new IllegalArgumentException("Contact ID too long or null, contact id must be 10 characters or less.");
		}
		
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("First name too long or null, first name must be 10 characters or less.");
		}
		
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Last name too long or null, last name must be 10 characters or less.");
		}
		
		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid phone number, phone number must be exactly 10 digits.");
		}
		
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Address too long or null, address must be 30 characters or less.");
		}
		
		// If unique and fields valid, add the new contact
		contacts.put(contactID, new Contact(contactID, firstName, lastName, phone, address));
	}
		
	// Delete a contact by its ID
	public void deleteContact(String contactID) {
		
		if (contactID == null) {
			throw new IllegalArgumentException("Contact ID cannot be null.");
		}
		
		if (contactID.length() > 10) {
			throw new IllegalArgumentException("Contact ID too long, contact id must be 10 characters or less.");
		}
		
		if (contacts.containsKey(contactID)) {
			contacts.remove(contactID);
		} 
		else {
			throw new IllegalArgumentException("Contact ID not found.  Cannot delete contact.");
			}
	}
	// Update an existing contact
	public void updateContact(String contactID, String firstName, String lastName, String phone, String address) {
		
		if (contactID == null) {
			throw new IllegalArgumentException("Contact ID cannot be null.");
		}
		
		if (contactID.length() > 10) {
			throw new IllegalArgumentException("Contact ID too long, contact id must be 10 characters or less.");
		}
		
		Contact toUpdate = contacts.get(contactID);
		if (toUpdate == null) {
			throw new IllegalArgumentException("Contact ID not found.  Cannot update contact.");
		}
		
		if (firstName != null) toUpdate.setFirstName(firstName);
		if (lastName != null) toUpdate.setLastName(lastName);
		if (phone != null) toUpdate.setPhone(phone);
		if (address != null) toUpdate.setAddress(address);
	}
}
		

		
		
		
		
