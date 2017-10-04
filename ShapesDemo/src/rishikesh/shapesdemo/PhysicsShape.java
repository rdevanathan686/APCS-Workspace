package rishikesh.shapesdemo;
import processing.core.PApplet;
import rella.shapes.Circle;
import rella.shapes.Shape;

public class PhysicsShape
{
    private Shape boundingShape;
    private double vx, vy;
    
    public PhysicsShape(Shape boundingShape)
    {
        this.boundingShape = boundingShape;
        vx = 0;
        vy = 0;
        
    }

    public void draw(PApplet drawer)
    {
        boundingShape.draw(drawer);
    }
    
    public Shape getBoundingShape()
    {
        return boundingShape;
    }
    
    public void setVelocity(double vx, double vy)
    {
        this.vx = vx;
        this.vy = vy;
    }
    
    public void act()
    {
        boundingShape.setPos(vx, vy);
    }
    
}
