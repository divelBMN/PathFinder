package render;

import utilities.Vector;

public class Render {
	
	private int iterationIndex;
	private Vector startPosition;
	private Vector taskPosition;
	
	
	public Render(Vector startPosition, Vector taskPosition) {
		this.startPosition = startPosition;
		this.taskPosition = taskPosition;
		this.iterationIndex = 0;
	}
	
	public void display(Vector solvePosition) {
		this.displayBorderLine();
		this.displayIterationIndex();
		this.displayVector(this.startPosition, "start position");
		this.displayVector(this.taskPosition, "Task");
		this.displayVector(solvePosition, "current solve");
		this.displayBorderLine();
		System.out.println();
		System.out.println();
		
		this.iterationIndex++;
	}
	
	private void displayVector(Vector vector, String message) {
		String vectorString = vector.getX() + " - " + vector.getY();
		System.out.println(message + ": " + vectorString);
	}
	
	private void displayIterationIndex() {
		System.out.println("Index of current iteration: " + this.iterationIndex);
	}
	
	private void displayBorderLine() {
		System.out.println("======================================");
	}

}
