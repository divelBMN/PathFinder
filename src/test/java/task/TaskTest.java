package task;

import org.junit.Test;
import utilities.Vector;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TaskTest {

	@Test
	public void testGetPosition() {
		Task task = new Task(new Vector(3, 4));
		Vector taskPosition = task.getPosition();
		assertTrue(taskPosition.isEquals(new Vector(3,4)));
	}
	
	@Test
	public void testIsTaskPosition() {
		Task task = new Task(new Vector(3, 4));
		assertTrue(task.isTaskPosition(new Vector(3,4)));
	}
	
	@Test
	public void testIsTaskPosition_NotPosition() {
		Task task = new Task(new Vector(3, 4));
		assertFalse(task.isTaskPosition(new Vector(4,4)));
	}
	
}