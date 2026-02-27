//Programmer: Travis Erwin
//Date: Feb 12, 2026
//Appointment.java
//Course: CS-320
//Instructor: Sherif Antoun

package appointmentService;

import java.util.Date;



public class Appointment {
	
	// Fields
	private final String appointmentID;
	private Date appointmentDate;
	private String description;
	
	// Constructor
	public Appointment(String appointmentID, Date appointmentDate, String description) {
		if (appointmentID == null || appointmentID.length() > 10) {
			throw new IllegalArgumentException("Appointment ID too long or null, appointment id must be 10 characters or less.");
		}
		if (appointmentDate == null || appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Appointment dates cannot be in the past or null.");
		}
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Description too long or null, description must be 50 characters or less.");
		}

		// Initialize fields
		this.appointmentID = appointmentID;
		this.appointmentDate = appointmentDate;
		this.description = description;
	}
	
	// Getters
	public String getAppointmentID() {
		return appointmentID;
	}
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	public String getDescription() {
		return description;
	}
	
	// Setters
	public void setAppointmentDate(Date appointmentDate) {
		if (appointmentDate == null || appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Appointment dates cannot be in the past or null.");
		}
		this.appointmentDate = appointmentDate;
	}
	
	public void setDescription(String description) {
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Description too long or null, description must be 50 characters or less.");
		}
		this.description = description;
	}
	

}
