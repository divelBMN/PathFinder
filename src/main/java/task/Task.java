package task;

import scene.Scene;
import utilities.Vector;

import java.util.Random;

public class Task {
	
	private Vector position;
	
	
	public Task(Scene scene) {
		Vector randomPosition = this.generateRandomPosition(scene);
		this.position = randomPosition;
	}
	
	private Vector generateRandomPosition(Scene scene) {
		Vector sceneSizes = scene.getSizes();
		Random random = new Random();
		Vector randomPosition;
		
		do {
			int x = random.nextInt(sceneSizes.getX());
			int y = random.nextInt(sceneSizes.getY());
			randomPosition = new Vector(x, y);
		} while (!scene.isAvailablePosition(randomPosition));
		
		return randomPosition;
	}
	
	public Task(Vector position) {
		this.position = position;
	}
	
	
	public Vector getPosition() {
		return this.position;
	}
	
	public boolean isTaskPosition(Vector vector) {
		return this.position.isEquals(vector);
	}
}
