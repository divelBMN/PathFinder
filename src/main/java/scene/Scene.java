package scene;

import utilities.Vector;

public class Scene {
	
	private final static Vector DEFAULT_SIZES = new Vector(20,12);
	
	private Vector sizes;
	
	public Scene() {
		this.sizes = DEFAULT_SIZES;
	}
	
	public Scene(Vector sizes) {
		this.sizes = sizes;
	}
	
	public Vector getSizes() {
		return this.sizes;
	}
	
	public boolean isAvailablePosition(Vector position) {
		return this.inBounds(position);
	}
	
	private boolean inBounds(Vector position) {
		return ((position.getX() >= 0) && (position.getX() < this.sizes.getX()))
			&& ((position.getY() >= 0) && (position.getY() < this.sizes.getY()));
	}
	
}
