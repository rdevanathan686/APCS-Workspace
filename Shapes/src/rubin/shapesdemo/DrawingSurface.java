package rubin.shapesdemo;

import processing.core.PApplet;
import rishikesh.shapes.Circle;

/**
 * 
 * @author rluitel403
 *
 */
public class DrawingSurface extends PApplet {
	
	private PhysicsShape shapeA;
	private Circle circle;
	private Interactions interactions;
	public DrawingSurface() {
		circle = new Circle(100,100,20);
		interactions = new Interactions();
		circle.setFillColor(150);
		shapeA = new PhysicsShape(circle);
		runSketch();
	}

	// The statements in the setup() function
	// execute once when the program begins
	public void setup() {
		
	
	}

	public void draw() {
		background(255, 255, 255);
		shapeA.draw(this);
		interactions.draw(this);

	}
	public void mousePressed() {
		shapeA.disperse(true);
	}
	public void mouseReleased() {
	}
	public void mouseDragged() {
		shapeA.disperse(false);
		shapeA.drag(mouseX, mouseY);
	}

}