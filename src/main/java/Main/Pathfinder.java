package Main;

import utilities.Vector;

public class Pathfinder {
	
	private Task task;
	private Mind mind;
	
	
	
	
	public boolean isSolved() {
	
		Vector taskPosition = this.task.getPosition();
		Vector solvePosition = this.mind.getSolvePosition();
		
		return solvePosition.isEquals(taskPosition);
	
	}
	
	public void nextIteration() {
		
		Vector taskPosition = this.task.getPosition();
		this.mind.correctSolve(taskPosition);
	
	}
}
