package Main;

public class Application {
	
	public static void main(String[] args) {
		Pathfinder pathfinder = new Pathfinder();
		
		while (!pathfinder.isSolved()) {
			pathfinder.nextIteration();
		}
	}

}
