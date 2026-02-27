// Programmer: Travis Erwin
// Date: Feb 12, 2026
// TaskService.java
// Course: CS-320
// Instructor: Sherif Antoun

package taskService;
import java.util.HashMap;
import java.util.Map;

public class TaskService {
	
	private final Map<String, Task> tasks = new HashMap<>();
	
	// Retrieve a task by its ID
	public Task getTaskByID(String taskID) {
		if (taskID == null) {
			throw new IllegalArgumentException("Task ID cannot be null.");
		}
		
		if (taskID.length() > 10) {
			throw new IllegalArgumentException("Task ID too long, task id must be 10 characters or less.");
		}
		
		Task found = tasks.get(taskID);
		
		if (found == null) {
			throw new IllegalArgumentException("Task ID not found.");
		}
		
		return found;
	}
	
	// Add a new task with unique ID and valid fields
	public void addTask(String taskID, String name, String description) { 
			
		if (tasks.containsKey(taskID)) {
			throw new IllegalArgumentException("Task ID already exists.  " + taskID + " is already in use.");
		}
		
		if (taskID == null || taskID.length() > 10) {
			throw new IllegalArgumentException("Task ID too long or null, task id must be 10 characters or less.");
		}
		
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Name too long or null, name must be 20 characters or less.");
		}
		
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Description too long or null, description must be 50 characters or less.");
		}
		// If ID unique and valid, add the task to the map
		tasks.put(taskID, new Task(taskID, name, description));
	}
	
	// Delete a task by its ID
	public void deleteTask(String taskID) {
		
		if (taskID == null) {
			throw new IllegalArgumentException("Task ID cannot be null.");
		}
		
		if (taskID.length() > 10) {
			throw new IllegalArgumentException("Task ID too long, task id must be 10 characters or less.");
		}
		if (tasks.containsKey(taskID)) {
			tasks.remove(taskID);
		} else {
			throw new IllegalArgumentException("Task ID not found.  Cannot delete task.");
		}
	}
	
	// Update an existing task
	public void updateTask(String taskID, String name, String description) {
		
		if (taskID == null) {
			throw new IllegalArgumentException("Task ID cannot be null.");
		}
		
		if (taskID.length() > 10) {
			throw new IllegalArgumentException("Task ID too long, task id must be 10 characters or less.");
		}
		
		Task taskToUpdate = tasks.get(taskID);
		if (taskToUpdate == null) {
			throw new IllegalArgumentException("Task ID not found.  Cannot update task.");
		}
			
		if (name != null) taskToUpdate.setName(name);
		if (description != null) taskToUpdate.setDescription(description);		
	}
}

