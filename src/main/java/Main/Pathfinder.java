package Main;

import mind.Mind;
import render.Displaying;
import render.SimpleGraphicRender;
import scene.Scene;
import task.Task;
import utilities.Vector;

import java.util.Random;

public class Pathfinder {
	
	private Vector startPosition;
	private Task task;
	private Mind mind;
	private Scene scene;
	private Displaying render;
	
	
	public Pathfinder() {
		this.scene = new Scene(new Vector(40,20));
		this.task = new Task(this.scene);
		this.startPosition = this.generateRandomPosition();
		this.mind = new Mind(this.scene, this.startPosition);
		this.render = new SimpleGraphicRender(
				this.startPosition,
				this.task.getPosition(),
				this.scene);
	}
	
	public boolean isSolved() {
		
		Vector solvePosition = this.mind.getSolvePosition();
		return this.task.isTaskPosition(solvePosition);
	
	}
	
	public void nextIteration() {
		Vector taskPosition = this.task.getPosition();
		this.mind.correctSolve(taskPosition);
		this.render.display(this.mind);
	}
	
	private Vector generateRandomPosition() {
		Vector sceneSizes = this.scene.getSizes();
		Random random = new Random();
		Vector randomPosition;
		
		do {
			int x = random.nextInt(sceneSizes.getX());
			int y = random.nextInt(sceneSizes.getY());
			randomPosition = new Vector(x, y);
		} while ((!this.scene.isAvailablePosition(randomPosition))
			   && this.task.isTaskPosition(randomPosition));
		
		return randomPosition;
	}
	
}
