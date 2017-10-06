package rishikesh.shapesdemo;


import java.awt.dnd.MouseDragGestureRecognizer;
import java.util.ArrayList;

import processing.core.PApplet;
import rella.shapes.*;


public class DrawingSurface extends PApplet
{

    private PhysicsShape shapeA;
    private ArrayList<PhysicsShape> path;
    
    public DrawingSurface()
    {   
        shapeA = new PhysicsShape(new Circle(100, 100, 20));
        path = new ArrayList<PhysicsShape>();
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
        background(255);
        
        update();
        shapeA.draw(this);
    }
    
    private void update()
    {
        shapeA.setAcceleration(shapeA.getAcceleration() + 0.1);
        shapeA.setVelocity(0 + shapeA.getAcceleration(), 0 + shapeA.getAcceleration());
        shapeA.act();
        
    }
    
    public void mouseDragged()
    {
//        if (mouseButton == LEFT) {
//            path.add(new PhysicsShape(new Line(shapeA. mouseX, mouseY)));
//        } else if (mouseButton == RIGHT)
//            l2.setPoint2(mouseX, mouseY);
        
    }

}
