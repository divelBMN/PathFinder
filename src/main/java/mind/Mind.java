package mind;

import scene.Scene;
import utilities.Vector;

public class Mind {
	
	private final int MAX_MUTATIONS = 9;
	private final int CURRENT_MUTATION_INDEX = 4;
	
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
		float error = this.calculateError(taskPosition, this.solvePosition);
		Vector[] mutations = this.generateMutations(Math.round(error));
		Vector bestMutation = this.findBestMutation(taskPosition, mutations);
		this.solvePosition = bestMutation;
	}
	
	private Vector findBestMutation(Vector taskPosition, Vector[] mutations) {
		Vector bestMutation = mutations[CURRENT_MUTATION_INDEX];
		float minError = this.calculateError(taskPosition, bestMutation);
		
		for (Vector mutation : mutations) {
			if (this.scene.isAvailablePosition(mutation)) {
				float error = this.calculateError(taskPosition, mutation);
				if (error < minError) {
					bestMutation = mutation;
					minError = error;
				}
			}
		}
		
		return bestMutation;
	}
	
	private float calculateError(Vector taskPosition, Vector position) {
		float deltaX = (float)(taskPosition.getX() - position.getX());
		float deltaY = (float)(taskPosition.getY() - position.getY());
		float error = (float) Math.sqrt(deltaX * deltaX + deltaY * deltaY);
		return error;
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
