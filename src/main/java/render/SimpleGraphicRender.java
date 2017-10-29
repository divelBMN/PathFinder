package render;

import mind.Mind;
import scene.Scene;
import utilities.Vector;

public class SimpleGraphicRender implements Displaying {
	
	private final int BORDER_THICKNESS = 1;
	
	private Vector startPosition;
	private Vector taskPosition;
	private Scene scene;
	private int frameIndex;
	
	private char[][] sceneFrame;
	
	
	public SimpleGraphicRender(final Vector startPosition, final Vector taskPosition, final Scene scene) {
		this.startPosition = startPosition;
		this.taskPosition = taskPosition;
		this.scene = scene;
		this.frameIndex = 0;
		
		this.generateSceneFrame();
		this.addingTaskPosition();
		this.addingStartPosition();
	}
	
	private void addingTaskPosition() {
		this.addingSymbolToSceneFrame(this.taskPosition, '$');
	}
	
	private void addingStartPosition() {
		this.addingSymbolToSceneFrame(this.startPosition, 'O');
	}
	
	private void addingSymbolToSceneFrame(Vector position, char symbol) {
		int x = position.getX() + this.BORDER_THICKNESS;
		int y = position.getY() + this.BORDER_THICKNESS;
		this.sceneFrame[x][y] = symbol;
	}
	
	private void generateSceneFrame() {
		int frameWidth = this.scene.getSizes().getX() + 2 * this.BORDER_THICKNESS;
		int frameHeight = this.scene.getSizes().getY() + 2 * this.BORDER_THICKNESS;
		this.sceneFrame = new char[frameWidth][frameHeight];
		this.addingBorderLone(0, frameWidth);
		for (int i = 1; i < frameHeight - 1; i++) {
			this.addingSceneLine(i, frameWidth);
		}
		this.addingBorderLone(frameHeight - 1, frameWidth);
	}
	
	private void addingSceneLine(int lineIndex, int frameWidth) {
		this.sceneFrame[0][lineIndex] = '#';
		
		for (int i = 1; i < frameWidth - 1; i++) {
			this.sceneFrame[i][lineIndex] =' ';
		}
		
		this.sceneFrame[frameWidth - 1][lineIndex] = '#';
	}
	
	private void addingBorderLone(int lineIndex, int frameWidth) {
		char[] borderLine = this.generateBorderLine(frameWidth, '#');
		for (int i = 0; i < frameWidth; i++) {
			this.sceneFrame[i][lineIndex] = borderLine[i];
		}
	}
	
	public void display(Mind mind) {
		this.displayFrameIndex();
		this.displayScene(mind);
		
		
		this.frameIndex++;
		System.out.println();
		System.out.println();
	}
	
	private void displayScene(final Mind mind) {
		this.addingSolvePosition(mind);
		this.displayFrame();
	}
	
	private void addingSolvePosition(Mind mind) {
		
		this.addingSymbolToSceneFrame(mind.getSolvePosition(), '*');
	}
	
	private void displayFrame() {
		int frameWidth = this.scene.getSizes().getX() + 2 * this.BORDER_THICKNESS;
		int frameHeight = this.scene.getSizes().getY() + 2 * this.BORDER_THICKNESS;
		for (int y = 0; y < frameHeight; y++) {
			char[] displayedString = new char[frameWidth];
			for (int x = 0; x < frameWidth; x++) {
				displayedString[x] = this.sceneFrame[x][y];
			}
			System.out.println(displayedString);
		}
	}
	
	private void displayFrameIndex() {
		int width = this.scene.getSizes().getX() + this.BORDER_THICKNESS * 2;
		this.displayBorderLine(width);
		System.out.println("= frame: " + this.frameIndex);
		this.displayBorderLine(width);
		System.out.println();
	}
	
	private void displayBorderLine(final int size) {
		char[] borderLine = this.generateBorderLine(size, '=');
		System.out.println(borderLine);
	}
	
	private char[] generateBorderLine(int size, char symbol) {
		char[] borderLine = new char[size];
		for (int i = 0; i < size; i++) {
			borderLine[i] = symbol;
		}
		return borderLine;
	}
	
}
