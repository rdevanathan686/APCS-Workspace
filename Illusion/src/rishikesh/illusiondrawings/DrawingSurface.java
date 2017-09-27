package rishikesh.illusiondrawings;

import processing.core.PApplet;

import rishikesh.shapes.Circle;
import rishikesh.shapes.Rectangle;

public class DrawingSurface extends PApplet
{
    Circle[] circleLoop = new Circle[16];

    public DrawingSurface()
    {

    }

    // The statements in the setup() function
    // execute once when the program begins
    public void setup()
    {
        
        // create circle objects and save it in an array
        for (int r = 20, i = 0; i < 16; r += 13, i++)
            circleLoop[i] = new Circle(247, 233, r);
        
        
    }

    // The statements in draw() are executed until the
    // program is stopped. Each statement is executed in
    // sequence and after the last line is read, the first
    // line is executed again.
    public void draw()
    {
        background(255);
        System.out.println(width + " " + height);
        
        // setup and draw the circles from the array
        strokeWeight(10);
        stroke(20);
        noFill();

        for (int i = 0; i < 16; i++)
            circleLoop[i].draw(this);

        // setup and draw the rectangle
        stroke(150);
        rect(75, 70, 350, 330);

    }

}
