// Programmer: Travis Erwin
// Date: Feb 12, 2026
// TaskServiceTest.java
// Course: CS-320
// Instructor: Sherif Antoun


package taskServiceTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import taskService.TaskService;
import taskService.Task;

class TaskServiceTest {

	@Test
	void testAddTask() {
		TaskService service = new TaskService();
		service.addTask("05181987", "Task Testing", "Test Description for Task Testing");
		
		// Retrieve the task to verify it was added correctly
		assertTrue(service.getTaskByID("05181987").getTaskID().equals("05181987"));
		assertTrue(service.getTaskByID("05181987").getName().equals("Task Testing"));
		assertTrue(service.getTaskByID("05181987").getDescription().equals("Test Description for Task Testing"));
	}
	
	@Test
	// Test retrieving a task with an null ID
	void testGetTaskByIDNull() {
		TaskService service = new TaskService();
	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.getTaskByID(null);
		});
	}
	
	@Test
	// Test retrieving a task with an ID that is too long
	void testGetTaskByIDTooLong() {
		TaskService service = new TaskService();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.getTaskByID("051819871234");
		});
	}
	
	@Test
	// Test adding a task with a duplicate ID
	void testAddTaskUniqueIDcheck() {
		TaskService service = new TaskService();
		service.addTask("05181987", "Task Testing", "Test Description for Task Testing");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addTask("05181987", "Not Task Testing", "Not Test Description for Task Testing");
		});
	}
	
	@Test
	// Test adding a task with null fields
	void testAddTaskNull() {
		TaskService service = new TaskService();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addTask(null, "Task Testing", "Test Description for Task Testing");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addTask("05181987", null, "Test Description for Task Testing");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addTask("05181987", "Task Testing", null);
		});
	}
	
	@Test
	// Test adding a task with fields that are too long
	void testAddTaskTooLong() {
		TaskService service = new TaskService();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addTask("051819871234", "Task Testing", "Test Description for Task Testing");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addTask("05181987", "Task Testing long name that should throw error", "Test Description for Task Testing");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addTask("05181987", "Task Testing", "Long description to test out the fifty character limit in task descriptions.");
		});
	}
	
	@Test
	// Test deleting a task
	void testDeleteTask() {
		TaskService service = new TaskService();
		service.addTask("05181987", "Task Testing", "Test Description for Task Testing");
		service.deleteTask("05181987");
	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.getTaskByID("05181987");
		});
	}
	
	@Test
	// Test deleting a task with a null ID
	void testDeleteTaskIDNull() {
		TaskService service = new TaskService();

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.deleteTask(null);
		});
	}
	
	@Test
	// Test deleting a task with an ID that is too long
	void testDeleteTaskIDTooLong() {
		TaskService service = new TaskService();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.deleteTask("051819871234");
		});
	}
	
	@Test
	// Test deleting a task with an ID that does not exist
	void testDeleteTaskNotFound() {
		TaskService service = new TaskService();

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.deleteTask("05181987");
		});
	}
	
	@Test
	// Test updating a task
	void testUpdateTask() {
		TaskService service = new TaskService();
		service.addTask("05181987", "Task Testing", "Test Description for Task Testing");
		service.updateTask("05181987", "Not Task Testing", "Not Test Description for Task Testing");
		
		Task task = service.getTaskByID("05181987");
		assertTrue(task.getName().equals("Not Task Testing"));
		assertTrue(task.getDescription().equals("Not Test Description for Task Testing"));
	}
	@Test
	// Test updating a task with null ID
	void testUpdateTaskIDNull() {
		TaskService service = new TaskService();
	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updateTask(null, "Not Task Testing", "Not Test Description for Task Testing");
		});
	}
	
	@Test
	// Test updating a task with an ID that is too long
	void testUpdateTaskIDTooLong() {
		TaskService service = new TaskService();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updateTask("051819871234", "Not Task Testing", "Not Test Description for Task Testing");
		});
	}
	
	@Test
	// Test updating a task with an ID that does not exist
	void testUpdateTaskNotFound() {
		TaskService service = new TaskService();

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updateTask("05181988", "Not Task Testing", "Not Test Description for Task Testing");
		});
	}
	
	@Test
	// Test updating a task with null fields
	void testUpdateTaskNull() {
		TaskService service = new TaskService();
		service.addTask("05181987", "Task Testing", "Test Description for Task Testing");
		
		service.updateTask("05181987", null, null);
		
		Task task = service.getTaskByID("05181987");
		assertTrue(task.getName().equals("Task Testing"));
		assertTrue(task.getDescription().equals("Test Description for Task Testing"));
	}
}

