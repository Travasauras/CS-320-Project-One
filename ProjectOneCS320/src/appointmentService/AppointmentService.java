//Programmer: Travis Erwin
//Date: Feb 12, 2026
//AppointmentService.java
//Course: CS-320
//Instructor: Sherif Antoun

package appointmentService;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;



public class AppointmentService {
	
	private final Map<String, Appointment> appointments = new HashMap<>();
	
	// Retrieve an appointment by its ID
	public Appointment getAppointmentByID(String appointmentID) {
		if (appointmentID == null) {
			throw new IllegalArgumentException("Appointment ID cannot be null.");
		}
		
		if (appointmentID.length() > 10) {
			throw new IllegalArgumentException("Appointment ID too long, appointment id must be 10 characters or less.");
		}
		
		Appointment found = appointments.get(appointmentID);
		if (found == null) {
			throw new IllegalArgumentException("Appointment ID not found.");
		}
		return found;
	}
	
	
	// Add a new appointment
	public void addAppointment(String appointmentID, Date appointmentDate, String description) { 
			
		if (appointments.containsKey(appointmentID)) {
			throw new IllegalArgumentException("Appointment ID already exists.  " + appointmentID + " is already in use.");
		}
		
		if (appointmentID == null || appointmentID.length() > 10) {
			throw new IllegalArgumentException("Appointment ID null or too long, appointment ID must be 10 characters or less.");
		}
		if (appointmentDate == null || appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Appointment dates cannot be null or in the past.");
		}
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Description null or too long, description must be 50 characters or less.");
		}
		
		// If ID unique and valid, add the appointment to the map
		appointments.put(appointmentID, new Appointment(appointmentID, appointmentDate, description));
	}
	
	// Delete an appointment by its ID
	public void deleteAppointment(String appointmentID) {
		
		if (appointmentID == null) {
			throw new IllegalArgumentException("Appointment ID cannot be null.");
		}
		
		if (appointmentID.length() > 10) {
			throw new IllegalArgumentException("Appointment ID too long, appointment id must be 10 characters or less.");
		}
		
		if (appointments.containsKey(appointmentID)) {
			appointments.remove(appointmentID);
		} 
		else {
			throw new IllegalArgumentException("Appointment ID not found.  Cannot delete appointment.");
			}
	}

}
