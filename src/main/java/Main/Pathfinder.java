package Main;

import task.Task;
import utilities.Vector;

public class Pathfinder {
	
	private Task task;
	private Mind mind;
	
	
	
	
	public boolean isSolved() {
		
		Vector solvePosition = this.mind.getSolvePosition();
		return this.task.isTaskPosition(solvePosition);
	
	}
	
	public void nextIteration() {
		
		Vector taskPosition = this.task.getPosition();
		this.mind.correctSolve(taskPosition);
	
	}
}
