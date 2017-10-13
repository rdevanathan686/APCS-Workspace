package rishikesh.shapes;
import processing.core.PApplet;
import processing.core.PConstants;

/**
 * This class represents a Circle modeled for processing.js
 * 
 * @author rdevanathan686
 * @version 9.20.2017
 * 
 */
public class Circle extends Shape
{
    private double radius;

    /**
     * Creates a default instance of a Circle object with all dimensions 
     * (x, y, radius) set to zero.
     * 
     */
    public Circle()
    {
        this(0, 0, 0);
    }

    /**
     * Creates a new instance of a Circle object with the center point being
     * x and y and the radius set to the parameter radius
     * 
     * @param x the x-coordinate of the center coordinate
     * @param y the y-coordinate of the center coordinate
     * @param radius the radius of the Circle
     */
    public Circle(double x, double y, double radius)
    {

        super(x, y);
        this.radius = radius;

    }
    
    @Override
    public double getPerimeter()
    {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea()
    {
        return Math.PI * radius * radius;
    }

    @Override
    public boolean isPointInside(double x, double y)
    {
        if (getDistance(x, y) < radius)
            return true;
            
        return false;
    }
    
    /**
     * Determines if the Circle overlaps with the given Circle
     * 
     * @param other the Circle to check the overlap on
     * @return boolean value representing if the other Circle overlaps on the implicit Circle
     */
    public boolean overlaps(Circle other)
    {
        double x2 = other.x;
        double y2 = other.y;
        double radius2 = other.radius;
        
        if (Math.abs(radius2 - radius) <= getDistance(x2, y2) 
                && getDistance(x2, y2)  <= (radius2 + radius))
            return true;
        
        return false;
    }
    
    /**
     * Determines the distance between point x,y and the center of the circle
     * 
     * @param x the x-coordinate of the point to determine the distance
     * @param y the y-coordinate of the point to determine the distance
     * @return the distance between the point x,y and the center of the circle
     */
    public double getDistance(double x, double y)
    {
        double distance = Math.pow((this.x - x), 2) 
                + Math.pow((this.y - y), 2);
        
        return Math.sqrt(distance);
    }

    /**
     * Draws the Circle object with the center point being
     * x and y and the radius set to the parameter radius
     * 
     * @param drawer the canvas to draw the objects on
     * @pre drawer must not be null, and appropriate settings should have been selected (color, fill, etc)
     * @post the drawer will have its ellipse mode modified to PApplet.RADIUS
     */
    public void draw(PApplet drawer)
    {
        
        super.draw(drawer);
        
        drawer.ellipseMode(PConstants.CENTER);
        drawer.ellipse((float) x, (float) y, (float) radius, (float) radius);
    }

    /**
     * Returns the radius of the circle
     * @return
     */
    public double getRadius()
    {
        return radius;
    }

    /**
     * Sets the radius of the circle to the given value
     * @param radius the radius of the shape to set to, must be greater than 0
     */
    public void setRadius(double radius)
    {
        this.radius = radius;
    }
    

}
