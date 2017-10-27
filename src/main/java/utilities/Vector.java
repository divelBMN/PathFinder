package utilities;

public class Vector {
	
	private int x;
	
	private int y;
	
	
	public Vector(final int x, final int y) {
		this.x = x;
		this.y = y;
	}
	
	
	public boolean isEquals(Vector vector) {
		return ((this.x == vector.x) && (this.y == vector.y));
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public float length() {
		return (float)Math.sqrt(this.x * this.x + this.y * this.y);
	}
	
}
