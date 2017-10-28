package Main;

import mind.Mind;
import scene.Scene;
import task.Task;
import utilities.Vector;

import java.util.Random;

public class Pathfinder {
	
	private Vector startPosition;
	private Task task;
	private Mind mind;
	private Scene scene;
	
	
	//TODO дописать конструктор
	public Pathfinder() {
	
	}
	
	public boolean isSolved() {
		
		Vector solvePosition = this.mind.getSolvePosition();
		return this.task.isTaskPosition(solvePosition);
	
	}
	
	public void nextIteration() {
		
		Vector taskPosition = this.task.getPosition();
		this.mind.correctSolve(taskPosition);
	
	}
	
	private Vector generateRandomPosition() {
		Vector sceneSizes = this.scene.getSizes();
		Random random = new Random();
		Vector randomPosition;
		
		do {
			int x = random.nextInt(sceneSizes.getX());
			int y = random.nextInt(sceneSizes.getY());
			randomPosition = new Vector(x, y);
		} while (!this.scene.isAvailablePosition(randomPosition));
		
		return randomPosition;
	}
	
}
