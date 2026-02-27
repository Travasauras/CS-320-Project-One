// Progammer: Travis Erwin
// Date: Feb 12, 2026
// TaskTest.java
// Course: CS-320
// Instructor: Sherif Antoun

package taskServiceTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import taskService.Task;

class TaskTest {

	@Test
	void test() {
		Task task = new Task("05181987", "Task Testing", "Test Description for Task Testing");
		assertTrue(task.getTaskID().equals("05181987"));
		assertTrue(task.getName().equals("Task Testing"));
		assertTrue(task.getDescription().equals("Test Description for Task Testing"));
	}
	
	@Test
	// Test for null fields
	void testTaskNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "Task Testing", "Test Description for Task Testing");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("05181987", null, "Test Description for Task Testing");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("05181987", "Task Testing", null);
		});
	}
	
	@Test
	// Test for fields that are too long
	void testTaskTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("051819871234", "Task Testing", "Test Description for Task Testing");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("05181987", "Task Testing long name that should throw error", "Test Description for Task Testing");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("05181987", "Task Testing", "Long description to test out the fifty character limit in task descriptions.");
		});
	}
	
	@Test
	// Test setters for name and description
	void testSetters() {
		Task task = new Task("05181987", "Task Testing", "Test Description for Task Testing");
		task.setName("Updated Name");
		task.setDescription("Updated Description");
		assertTrue(task.getName().equals("Updated Name"));
		assertTrue(task.getDescription().equals("Updated Description"));
		
		// Test for invalid name
		assertThrows(IllegalArgumentException.class, () -> {
			task.setName(null);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			task.setName("This name is definitely way too long to be valid");
		});
		
		// Test for invalid description
		assertThrows(IllegalArgumentException.class, () -> {
			task.setDescription(null);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			task.setDescription("This description is way too long to be valid because it exceeds the fifty character limit imposed by the Task class.");
		});
	}
	
}
