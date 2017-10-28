package render;

import mind.Mind;
import utilities.Vector;

public class SimpleTextRender implements Displaying {
	
	private int iterationIndex;
	private Vector startPosition;
	private Vector taskPosition;
	
	
	public SimpleTextRender(final Vector startPosition, final Vector taskPosition) {
		this.startPosition = startPosition;
		this.taskPosition = taskPosition;
		this.iterationIndex = 0;
	}
	
	public void display(final Mind mind) {
		this.displayBorderLine();
		this.displayIterationIndex();
		this.displayVector(this.startPosition, "start position");
		this.displayVector(this.taskPosition, "Task");
		this.displayVector(mind.getSolvePosition(), "current solve");
		this.displayBorderLine();
		System.out.println();
		System.out.println();
		
		this.iterationIndex++;
	}
	
	private void displayVector(final Vector vector, final String message) {
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
