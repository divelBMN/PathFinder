package Main;

import org.junit.Test;

import static org.junit.Assert.*;

public class PathfinderTest {

	@Test
	public void taskIsSolved() {
		Pathfinder pathfinder = new Pathfinder();
		
		while (!pathfinder.isSolved()) {
			pathfinder.nextIteration();
		}
		assertTrue(pathfinder.isSolved());
	}
	
}