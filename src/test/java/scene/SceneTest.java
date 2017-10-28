package scene;

import org.junit.Test;
import utilities.Vector;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SceneTest {
	
	@Test
	public void getSizes() throws Exception {
		Scene scene = new Scene(new Vector(10,10));
		Vector sceneSizes = scene.getSizes();
		assertTrue(sceneSizes.isEquals(new Vector(10,10)));
	}
	
	@Test
	public void getSizesForDefaultSceneSizes() throws Exception {
		Scene scene = new Scene();
		Vector sceneSizes = scene.getSizes();
		assertTrue(sceneSizes.isEquals(new Vector(20,12)));
	}
	
	@Test
	public void isAvailablePosition() throws Exception {
		Scene scene = new Scene(new Vector(10,10));
		assertTrue(scene.isAvailablePosition(new Vector(5, 5)));
		
		assertFalse(scene.isAvailablePosition(new Vector(-1, 5)));
		assertFalse(scene.isAvailablePosition(new Vector(10, 5)));
		assertFalse(scene.isAvailablePosition(new Vector(5, -1)));
		assertFalse(scene.isAvailablePosition(new Vector(5, 10)));
	}
	
}