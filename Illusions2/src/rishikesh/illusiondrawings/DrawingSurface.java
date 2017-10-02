package rishikesh.illusiondrawings;


import processing.core.PApplet;
import rishikesh.shapes.Line;

public class DrawingSurface extends PApplet
{

    
    
    public DrawingSurface()
    {
        
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

        for (int theta = 0; theta < 360; theta += 9)
        {
            double endX = 350 * Math.cos(theta);
            double endY = 350 * Math.sin(theta);
            Line line = new Line(415, 400, 415 + endX, 400 + endY);
            line.setStrokeWeight(8);
            line.draw(this);
        }
        
        for (int i = 1; i <= 6; i++)
        {
            Line line = new Line((i * 110) + 30, 50, (i * 110) + 30, 750);
            line.setStrokeWeight(10);
            line.setStrokeColor(color(255, 0, 0));
            line.draw(this);
        }

    }

}
