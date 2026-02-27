// Programmer: Travis Erwin
// Date: Feb 12, 2026
// Task.java
// Course: CS-320
// Instructor: Sherif Antoun

package taskService;

public class Task {

	// Fields
	private final String taskID;
	private String name;
	private String description;

	// Constructor
	public Task(String taskID, String name, String description) {
		if (taskID == null || taskID.length() > 10) {
			throw new IllegalArgumentException("Task ID too long or null, task id must be 10 characters or less.");
		}
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Name too long or null, name must be 20 characters or less.");
		}
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Description too long or null, description must be 50 characters or less.");
		}

		// Initialize fields
		this.taskID = taskID;
		this.name = name;
		this.description = description;
	}
	
	// Getters
	public String getTaskID() {
		return taskID;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	
	// Setters
	public void setName(String name) {
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Name too long or null, name must be 20 characters or less.");
		}
		this.name = name;
	}
	
	public void setDescription(String description) {
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Description too long or null, description must be 50 characters or less.");
		}
		this.description = description;
	}
}