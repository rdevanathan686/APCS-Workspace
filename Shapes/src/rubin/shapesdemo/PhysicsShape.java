package rubin.shapesdemo;

import processing.core.PApplet;
import rishikesh.shapes.Circle;
import rishikesh.shapes.Line;
import rishikesh.shapes.Shape;

public class PhysicsShape {
	private Shape boundingShape;
	private double xVel, yVel;
	private boolean disperse;
	private Circle[] circles;
	private Line[] line;
	private int xDir, yDir;
	private int fillColorValue;

	public PhysicsShape(Shape boundingShape) {
		this.boundingShape = boundingShape;
		disperse = false;
		xVel = 0;
		yVel = 0;
	}

	public void draw(PApplet drawer) {
		boundingShape.draw(drawer);
		if (disperse) {
			for (int i = 0; i < 4; i++) {
				if (i == 0) {
					xDir = 0;
					yDir = 2;
					circles[i].moveBy(xDir, yDir);
					if(circles[i].getY() >= 500) {
						circles[i].move(boundingShape.getX(),boundingShape.getY());
					}
					circles[i].draw(drawer);
					line[i].setPoint2(circles[i].getX(), circles[i].getY());
					line[i].draw(drawer);
				} else if (i == 1) {
					xDir = -2;
					yDir = 0;
					circles[i].moveBy(xDir, yDir);
					if(circles[i].getX() <= 0) {
						circles[i].move(boundingShape.getX(),boundingShape.getY());
					}
					circles[i].draw(drawer);
					line[i].setPoint2(circles[i].getX(), circles[i].getY());
					line[i].draw(drawer);
				} else if (i == 2) {
					xDir = 0;
					yDir = -2;
					circles[i].moveBy(xDir, yDir);
					if(circles[i].getY() <= 0) {
						circles[i].move(boundingShape.getX(),boundingShape.getY());
					}
					circles[i].draw(drawer);
					line[i].setPoint2(circles[i].getX(), circles[i].getY());
					line[i].draw(drawer);
				} else if (i == 3) {
					xDir = 2;
					yDir = 0;
					circles[i].moveBy(xDir, yDir);
					if(circles[i].getX() >= 600) {
						circles[i].move(boundingShape.getX(),boundingShape.getY());
					}
					circles[i].draw(drawer);
					line[i].setPoint2(circles[i].getX(), circles[i].getY());
					line[i].draw(drawer);
				}
			}
		}
	}

	public Shape getBoundingShape() {
		return boundingShape;
	}

	public void setVelocity(double xVel, double yVel) {
		this.xVel = xVel;
		this.xVel = yVel;
	}

	public void act() {
		boundingShape.move(boundingShape.getX() + xVel, boundingShape.getY() + yVel);
	}

	public void drag(double mouseX, double mouseY) {
		boundingShape.move(mouseX, mouseY);
	}

	public void disperse(boolean disperse) {
		fillColorValue = 10;
		this.disperse = disperse;
		circles = new Circle[4];
		line = new Line[4];
		for (int i = 0; i < 4; i++) {
			circles[i] = new Circle(boundingShape.getX(), boundingShape.getY(), 20);
			circles[i].setFillColor(fillColorValue);
			line[i] = new Line(boundingShape.getX(), boundingShape.getY(),circles[i].getX(), circles[i].getY());
			fillColorValue+=40;
		}
	}
}
