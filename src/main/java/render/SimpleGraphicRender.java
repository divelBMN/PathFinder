package render;

import mind.Mind;
import utilities.Vector;

public class SimpleGraphicRender implements Displaying {
	
	private Vector startPosition;
	private Vector taskPosition;
	private int frameIndex;
	
	
	public SimpleGraphicRender(final Vector startPosition) {
		
		this.frameIndex = 0;
	}
	
	public void display(Mind mind) {
	
	}
}
