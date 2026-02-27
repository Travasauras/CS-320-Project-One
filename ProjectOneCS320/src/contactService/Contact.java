// Programmer: Travis Erwin
// Date: Feb 12, 2026
// Contact.java
// Course: CS-320
// Instructor: Sherif Antoun
package contactService;

public class Contact {
	
	// Fields
	private final String contactID;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	// Constructor
	public Contact(String contactID, String firstName, String lastName, String phone, String address) {
		if (contactID == null || contactID.length() > 10) {
			throw new IllegalArgumentException("Contact ID too long or null, contact id must be 10 characters or less.");
		}
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("First name too long or null, first name must be 10 characters or less.");
		}
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Last name too long or null, last name must be 10 characters or less.");
		}
		if (phone == null || phone.length() > 10) {
			throw new IllegalArgumentException("Invalid phone number, phone number must be exactly 10 digits.");
		}
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Address too long or null, address must be 30 characters or less.");
		}
		
		// Initialize fields
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	// Getters
	public String getContactID() {
		return contactID;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	
	// Setters
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("First name too long or null, first name must be 10 characters or less.");
		}
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Last name too long or null, last name must be 10 characters or less.");
		}
		this.lastName = lastName;
	}
	public void setPhone(String phone) {
		if (phone == null || phone.length() > 10) {
			throw new IllegalArgumentException("Invalid phone number, phone number must be exactly 10 digits.");
		}
		this.phone = phone;
	}
	public void setAddress(String address) {
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Address too long or null, address must be 30 characters or less.");
		}
		this.address = address;
	}
}

