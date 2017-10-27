package utilities;

import org.junit.Test;

import static org.junit.Assert.*;

public class VectorTest {

	@Test
	public void testEqual() {
		Vector vectorOriginal = new Vector(3, 4);
		Vector vectorComparing = new Vector(3, 4);
		assertTrue(vectorOriginal.isEquals(vectorComparing));
	}
	
	@Test
	public void testEqual_Wrong1() {
		Vector vectorOriginal = new Vector(3, 4);
		Vector vectorComparing = new Vector(4, 4);
		assertFalse(vectorOriginal.isEquals(vectorComparing));
	}
	
	@Test
	public void testEqual_Wrong2() {
		Vector vectorOriginal = new Vector(3, 4);
		Vector vectorComparing = new Vector(3, 3);
		assertFalse(vectorOriginal.isEquals(vectorComparing));
	}
	
	@Test
	public void testLength() {
		Vector vector = new Vector(3, 4);
		float distance = vector.length();
		assertEquals(5f, distance, 0);
	}
	
}