package mind;

import scene.Scene;
import utilities.Vector;

public class Mind {
	
	private final int MAX_MUTATIONS = 9;
	
	private Vector solvePosition;
	private Scene scene;
	
	
	public Mind(Scene scene, Vector startPosition) {
		this.scene = scene;
		this.solvePosition = startPosition;
	}
	
	public Vector getSolvePosition() {
		return this.solvePosition;
	}
	
	public void correctSolve(Vector taskPosition) {
		int error = this.calculateError(taskPosition, this.solvePosition);
		Vector[] mutations = this.generateMutations(error);
		Vector bestMutation = this.findBestMutation(taskPosition, mutations);
		this.solvePosition = bestMutation;
	}
	
	private Vector findBestMutation(Vector taskPosition, Vector[] mutations) {
		int size = mutations.length;
		Vector bestMutation = mutations[0];
		int minError = this.calculateError(taskPosition, bestMutation);
		
		for (Vector mutation : mutations) {
			if (this.scene.isAvailablePosition(mutation)) {
				int error = this.calculateError(taskPosition, mutation);
				if (error < minError) {
					bestMutation = mutation;
					minError = error;
				}
			}
		}
		
		return bestMutation;
	}
	
	private int calculateError(Vector taskPosition, Vector position) {
		float deltaX = (float)(taskPosition.getX() - position.getX());
		float deltaY = (float)(taskPosition.getY() - position.getY());
		float error = (float) Math.sqrt(deltaX * deltaX + deltaY * deltaY);
		return Math.round(error);
	}
	
	private Vector[] generateMutations(int error) {
		Vector[] mutations = new Vector[MAX_MUTATIONS];
		
		int index = 0;
		for (int xRatio = -1; xRatio <= 1; xRatio++) {
			for (int yRatio = -1; yRatio <= 1; yRatio++) {
				int deltaX = error * xRatio;
				int deltaY = error * yRatio;
				Vector mutation = new Vector(
						this.solvePosition.getX() + deltaX,
						this.solvePosition.getY() + deltaY
				);
				mutations[index] = mutation;
				index++;
			}
		}
		
		return mutations;
	}
	
}
