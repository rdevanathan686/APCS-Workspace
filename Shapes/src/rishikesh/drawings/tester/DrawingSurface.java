package rishikesh.drawings.tester;

import processing.core.PApplet;
import rishikesh.shapes.Circle;
import rishikesh.shapes.Rectangle;
import rishikesh.shapes.RegularPolygon;


public class DrawingSurface extends PApplet
{

    // Testers for Rectangle
    Rectangle rectA;
    Rectangle rectB;
    Rectangle rectC;

    // Testers for Circle
    Circle circleA;
    Circle circleB;
    Circle circleC;
    
    // Testers for Polygon
    RegularPolygon square;
    RegularPolygon octagon;
    RegularPolygon enneadecagon;
    RegularPolygon enneacontakaihenagon; 

    public DrawingSurface()
    {
        rectA = new Rectangle();
        rectB = new Rectangle(0, 80, 400, 160);
        rectC = new Rectangle(0, 100, 20, -300);

        circleA = new Circle();
        circleB = new Circle(50, 50, 10);
        circleC = new Circle(40, 60, -10);
        
        square = new RegularPolygon(4, 10);
        octagon = new RegularPolygon(8, 5.75);
        enneadecagon = new RegularPolygon(19, 2);
        enneacontakaihenagon = new RegularPolygon(91, 0.5);
    }

    // The statements in the setup() function
    // execute once when the program begins
    public void setup()
    {
        System.out.println("Rectangle Testers:");
        System.out.println("Area of a Rectangle: " + rectB.getArea());
        System.out.println("Perimeter of a Rectangle: " + rectB.getPerimeter());
        System.out.println("Is point(50, 250) inside the rectangle? " + rectB.isPointInside(50, 250));
        System.out.println("Is the rectangle contained inside the window? " + rectB.inWindow(width, height));
        System.out.println("Does the rectangle(B) overlap with the other rectangle(C)? " + rectB.overlaps(rectC) + "\n");

        System.out.println("Circle Testers:");
        System.out.println("Area of a Circle: " + circleB.getArea());
        System.out.println("Perimeter of a Circle: " + circleB.getPerimeter());
        System.out.println("Is point(50, 59) inside the Circle? " + circleB.isPointInside(50, 59));
        System.out.println("Does the Circle(B) overlap with the other Circle(C)? " + circleB.overlaps(circleC) + "\n");
        
        // Testing Colors
        circleB.setFillColor(color(255, 0, 0));
        circleB.setStrokeWeight(3);
        circleB.setStrokeColor(color(0, 255, 0));
        
        System.out.println("Regular Polygon Testers:");
        System.out.println("Inner-circle radius of a square: " + square.getr());
        System.out.println("Outer-circle radius of an octagon: " + octagon.getR());
        System.out.println("Perimeter of a Enneadecagon: " + enneadecagon.getPerimeter());
        System.out.println("Area of a Enneacontakaihenagon: " + enneacontakaihenagon.getArea());

    }

    // The statements in draw() are executed until the
    // program is stopped. Each statement is executed in
    // sequence and after the last line is read, the first
    // line is executed again.
    public void draw()
    {

        background(255);
        
        // Drawing rectangles
        rectA.draw(this);
        rectB.draw(this);
        rectC.draw(this);

        // Drawing circles
        circleA.draw(this);
        circleB.draw(this);
        circleC.draw(this);
        
        // Drawing octagon of RegularPolygon class
        octagon.drawBoundingCircles(this);
        octagon.draw(this);
    }

}
