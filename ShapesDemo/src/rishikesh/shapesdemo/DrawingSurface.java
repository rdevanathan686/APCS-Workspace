package rishikesh.shapesdemo;


import processing.core.PApplet;
import rella.shapes.*;


public class DrawingSurface extends PApplet
{

    private PhysicsShape shapeA;
    
    public DrawingSurface()
    {   
        shapeA = new PhysicsShape(new Circle(100, 100, 20));
    }
    // The statements in the setup() function
    // execute once when the program begins
    public void setup()
    {

        background(255);


    }

    // The statements in draw() are executed until the
    // program is stopped. Each statement is executed in
    // sequence and after the last line is read, the first
    // line is executed again.
    public void draw()
    {
        
        

    }

}
