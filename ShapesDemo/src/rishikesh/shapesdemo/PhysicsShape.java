package rishikesh.shapesdemo;
import processing.core.PApplet;
import rella.shapes.Circle;
import rella.shapes.Shape;

public class PhysicsShape
{
    private Shape boundingShape;
    private double vx, vy;
    private double acceleration;

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
        boundingShape.move(boundingShape.getX() + vx, boundingShape.getY() + vy);
    }
    
    public double getVx()
    {
        return vx;
    }

    public void setVx(double vx)
    {
        this.vx = vx;
    }

    public double getVy()
    {
        return vy;
    }

    public void setVy(double vy)
    {
        this.vy = vy;
    }

    public double getAcceleration()
    {
        return acceleration;
    }

    public void setAcceleration(double acceleration)
    {
        this.acceleration = acceleration;
    }

    public void setBoundingShape(Shape boundingShape)
    {
        this.boundingShape = boundingShape;
    }
    
}
