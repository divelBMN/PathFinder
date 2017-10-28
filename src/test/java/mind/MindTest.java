package mind;

import org.junit.Test;
import scene.Scene;
import task.Task;
import utilities.Vector;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MindTest {
	
	@Test
	public void getSolvePosition() throws Exception {
		Scene scene = new Scene(new Vector(12, 10));
		Mind mind = new Mind(scene, new Vector(5, 5));
		assertTrue(mind.getSolvePosition().isEquals(new Vector(5,5)));
		assertFalse(mind.getSolvePosition().isEquals(new Vector(4,5)));
	}
	
	@Test
	public void correctSolve() throws Exception {
		Scene scene = new Scene(new Vector(12, 10));
		Mind mind = new Mind(scene, new Vector(5, 5));
		Task task = new Task(new Vector(8, 6));
		mind.correctSolve(task.getPosition());
		assertTrue(mind.getSolvePosition().isEquals(new Vector(8,5)));
	}
	
}