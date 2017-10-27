package Main;

public class Pathfinder {
	
	Task task;
	Mind mind;
	
	
	
	public boolean isSolved() {
	
		Vector taskPosition = this.task.getPosition();
		Vector solvePosition = this.mind.getSolvePosition();
		
		return solvePosition.equals(taskPosition);
	
	}
}
