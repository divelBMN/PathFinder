package render;

import utilities.Vector;

public class Render {
	
	private int iterationIndex;
	

	
	public Render() {
		this.iterationIndex = 0;
	}
	
	public void displayStartParametres(Vector taskPosition, Vector startPosition) {
		this.displayVector(startPosition, "start position");
		this.displayVector(taskPosition, "Task");
		
		System.out.println();
		System.out.println();
	}
	
	public void display(Vector solvePosition) {
		this.displayIterationIndex();
		
		this.displayVector(solvePosition, "current solve");
		this.displayLastString();
		
		this.iterationIndex++;
	}
	
	private void displayVector(Vector vector, String message) {
		String vectorString = vector.getX() + " - " + vector.getY();
		System.out.println(message + ": " + vectorString);
	}
	
	private void displayIterationIndex() {
		System.out.println("Index of current iteration: " + this.iterationIndex);
	}
	
	private void displayLastString() {
		System.out.println("");
		System.out.println("======================================");
		System.out.println("");
	}

}
