package rishikesh.drawings.tester;

import processing.core.PApplet;
import rishikesh.shapes.Circle;
import rishikesh.shapes.Rectangle;
import rishikesh.shapes.RegularPolygon;


public class DrawingSurface extends PApplet
{

    // Testers
    Rectangle rectA;
    Rectangle rectB;
    Rectangle rectC;

    Circle circleA;
    Circle circleB;
    Circle circleC;
    
    RegularPolygon triangle = new RegularPolygon(10, 100);

    public DrawingSurface()
    {
        rectA = new Rectangle();
        rectB = new Rectangle(0, 80, 400, 160);
        rectC = new Rectangle(0, 100, 20, -300);

        circleA = new Circle();
        circleB = new Circle(50, 50, 10);
        circleC = new Circle(40, 60, -10);
    }

    // The statements in the setup() function
    // execute once when the program begins
    public void setup()
    {
        System.out.println(rectB.getArea());
        System.out.println(rectB.getPerimeter());
        System.out.println(rectB.isPointInside(50, 250));
        System.out.println(rectB.inWindow(width, height));
        System.out.println(rectB.overlaps(rectC) + "\n");

        System.out.println(circleB.getArea());
        System.out.println(circleB.getPerimeter());
        System.out.println(circleB.isPointInside(50, 59));
        System.out.println(circleB.overlaps(circleC));
        
        circleB.setFillColor(color(255, 0, 0));
        circleB.setStrokeWeight(3);
        circleB.setStrokeColor(color(0, 255, 0));
        
        System.out.println(triangle.getr());
        

    }

    // The statements in draw() are executed until the
    // program is stopped. Each statement is executed in
    // sequence and after the last line is read, the first
    // line is executed again.
    public void draw()
    {
        noFill();
        background(255);
        rectA.draw(this);
        rectB.draw(this);
        rectC.draw(this);

        circleA.draw(this);
        circleB.draw(this);
        circleC.draw(this);
        
        triangle.drawBoundingCircles(this);
        triangle.draw(this);
        
        

    }

}
