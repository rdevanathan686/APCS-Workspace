package rishikesh.shapes;
import processing.core.PApplet;
import rishikesh.tester.DrawingSurface;

/*
 * Commentaries
 * 
 * Positives
 *i like how you made a new variable for the other lines x and y
 *i like how u made a new method for checking if the intersection point is in the range
 *i like how u made a separate variable for the numerator and denominator, makes it more clear and easier to debug
 *i like how u made a dot showing where the lines intersected
 *
 *Deltas
 *try initializing your fields in the constructor    
 *maybe only show the dot of intersection only when the lines actually intersect
 */

/**
 * This class represents a Line modeled for processing.js
 * 
 * @author rdevanathan686
 * @version 9.20.2017
 *
 */
public class Line extends Shape
{
 
	private double x2, y2;

	/**
	 * Creates a new instance of a Circle object with the center point being
     * x and y and the radius set to the parameter radius
     * 
	 * @param x the start x-coordinate of the line
	 * @param y the start y-coordinate of the line
	 * @param x2 the end x-coordinate of the line
	 * @param y2 the end y-coordinate of the line
	 */
	public Line(double x, double y, double x2, double y2) 
	{
		this.x = x;
		this.y = y;
		this.x2 = x2;
		this.y2 = y2;
	}

    /**
     * Draws a new instance of a Line object with the start point at x, y
     * and end point at x2, y2
     * 
     * @param drawer the canvas to draw the objects on
     * @pre drawer must not be null, and appropriate settings should have been selected (color, fill, etc)
     */
    @Override
	public void draw(PApplet drawer) 
	{
        super.draw(drawer);

		drawer.line((int) x, (int) y, (int) x2, (int) y2);
	}
	
	/**
	 * Calculates and returns the x-coordinate of the intersection between the implicit Line and the
	 * argument Line
	 * 
	 * @param l2 the Line object that is used to calculate the x-coordinate of the intersection
	 * @return the x-coordinate of the intersection of the implicit Line and the argument Line
	 */
	public double getPx(Line l2)
	{
		double x3 = l2.x;
		double x4 = l2.x2;
		double y3 = l2.y;
		double y4 = l2.y2;

		double num1 = ((x * y2 - y * x2) * (x3 - x4)) - ((x - x2) * (x3 * y4 - y3 * x4));
		double denom = ((x - x2) * (y3 - y4)) - ((y - y2) * (x3 - x4));
		
		if (Double.compare(denom, 0.0) == 0)
			return -99999.0;
		
		
		double pX = num1 / denom;
		
		return pX;
	}
	
	/**
     * Calculates and returns the y-coordinate of the intersection between the implicit Line and the
     * argument Line
     * 
     * @param l2 the Line object that is used to calculate the y-coordinate of the intersection
     * @return the y-coordinate of the intersection of the implicit Line and the argument Line
     */
	public double getPy(Line l2)
	{
		double x3 = l2.x;
		double x4 = l2.x2;
		double y3 = l2.y;
		double y4 = l2.y2;

		double num2 = ((x * y2 - y * x2) * (y3 - y4)) - ((y - y2) * (x3 * y4 - y3 * x4));
		double denom = ((x - x2) * (y3 - y4)) - ((y - y2) * (x3 - x4));
		
		
		if (Double.compare(denom, 0.0) == 0)
		    if ((y2 >= Math.min(l2.y, l2.y2) && y2 <= Math.max(l2.y, l2.y2)))
			    return -99999.0;
		
		double pY = num2 / denom;

		return pY;
	}

	/**
     * Determines if the line intersects with the given line
     * 
     * @param l2 the line to check the intersection on
     * @return boolean value representing if the argument line intersects on the implicit line
     */
    public boolean intersects(Line l2)
    {
        
        if (this.inBounds(getPx(l2), getPy(l2)) && l2.inBounds(l2.getPx(this), l2.getPy(this)))
            return true;

        return false;

    }

	private boolean inBounds(double pX, double pY)
	{
	    
		return (pX >= Math.min(x, x2) && pX <= Math.max(x, x2) 
				&& pY >= Math.min(y, y2) && pY <= Math.max(y, y2)); 

	}

	/**
	 * Sets the end coordinates of the line to the given coordinates
	 * 
	 * @param x2 the x-coordinate of the end point
	 * @param y2 the y-coordinate of the end point
 	 */
	public void setPoint2(double x2, double y2) 
	{
		this.x2 = x2;
		this.y2 = y2;

	}

}
