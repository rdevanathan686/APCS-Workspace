package rishikesh.shapes;

import processing.core.PApplet;

/**
 * This is an abstract class for shapes such as Circle, Rectangle and Line modeled for processing.js
 * 
 * @author rdevanathan686
 * @version 9.20.2017
 * 
 */
public abstract class Shape
{
    /**
     * The x and y coordinates of the shape
     */
    protected double x, y;
    private int strokeWeight;
    private int fillColor, strokeColor;
    
    /**
     * Default value of the strokeWeight of a shape is 1 px
     */
    public static final int DEFAULT_STROKE_WEIGHT = 1;
    /**
     * Default value of the fillColor of a shape is white
     */
    public static final int DEFAULT_FILL_COLOR = 255;
    /**
     * Default value of the strokeColor of a shape is black
     */
    public static final int DEFAULT_STROKE_COLOR = 0;
    

    /**
     * Default constructor that calls the x, y constructor to set
     * x, y to zero, strokeWeight to 1, fillColor to white and strokeColor to black
     */
    public Shape()
    {
        this(0.0, 0.0);
    }
    
    /**
     * x, y constructor that calls the x, y, strokeWeight, fillColor and strokeColor 
     * constructor to set x and y to zero, strokeWeight to 1, 
     * fillColor to white and strokeColor to black
     * 
     * @param x the x coordinates of the shape
     * @param y the y coordinates of the shape
     */
    public Shape(double x, double y)
    {
        this(x, y, 1, 255, 0);
    }
    
    /**
     * x, y, strokeWeight, fillColor and strokeColor constructor that sets x and y to zero, 
     * strokeWeight to 1, fillColor to white and strokeColor to black
     * 
     * @param x the x coordinates of the shape
     * @param y the x coordinates of the shape
     * @param strokeWeight the strokeWeight of the shape; must be > 0 or it'll be set to the default stroke weight
     * @param fillColor 
     * @param strokeColor
     */
    public Shape(double x, double y, int strokeWeight, int fillColor, int strokeColor)
    {
        this.x = x;
        this.y = y;
        
        if (!setStrokeWeight(strokeWeight))
            this.strokeWeight = DEFAULT_STROKE_WEIGHT;
        if (!setFillColor(fillColor))
            this.fillColor = DEFAULT_FILL_COLOR;
        if (!setStrokeColor(strokeColor))
            this.strokeColor = DEFAULT_STROKE_COLOR;
       
    }

    public void draw(PApplet drawer)
    {
        drawer.pushStyle();
        
        drawer.stroke(strokeColor);
        drawer.fill(fillColor);
        drawer.strokeWeight(strokeWeight);
        
        drawer.pushStyle();
    }

    /**
     * Determines whether the point x,y is contained inside the Shape
     * 
     * @param x the x-coordinate of the point to check
     * @param y the y-coordinate of the point to check
     * @return boolean value representing whether the point is contained in the Shape
     */
    public abstract boolean isPointInside(double x, double y);

    /**
     * Calculates and returns the area of the Shape
     * @return the area of the Shape
     */
    public abstract double getArea();

    /**
     * Calculates and returns the perimeter of the Shape
     * @return the perimeter of the Shape
     */
    public abstract double getPerimeter();

    /**
     * Moves the shape to the specified x,y coordinate
     * 
     * @param x the x-coordinate to move to
     * @param y the y-coordinate to move to
     */
    public void move(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Moves the shape by the specified velocity
     * 
     * @param xVel the velocity of the shape in the x-direction
     * @param yVel the velocity of the shape in the y-direction
     */
    public void moveBy(double xVel, double yVel)
    {
        this.x += xVel;
        this.y += yVel;
    }

    /**
     * Returns the x-coordinate of the shape
     * @return x coordinate of the shape
     */
    public double getX()
    {
        return x;
    }

    /**
     * Sets the x-coordinate of the shape to the specified x-coordinate
     * @param x - the x-coordinate to replace the current x-coordinate with
     */
    public void setX(double x)
    {
        this.x = x;
    }

    /**
     * Returns the y-coordinate of the shape
     * @return y coordinate of the shape
     */
    public double getY()
    {
        return y;
    }

    /**
     * Sets the y-coordinate of the shape to the specified y-coordinate
     * @param y - the y-coordinate to replace the current y-coordinate with
     */
    public void setY(double y)
    {
        this.y = y;
    }

    /**
     * Returns the stroke weight of the shape
     * @return stroke weight of the shape
     */
    public double getStrokeWeight()
    {
        return strokeWeight;
    }

    /**
     * Sets the stroke weight of the shape to the specified stroke weight
     * 
     * @param strokeWeight the stroke weight to replace the current stroke weight with
     * @pre strokeWeight must be grater than zero
     * @return true if it's set to the new value and false if not
     * @post strokeWeight of the shape may not be set if the param is less than zero
     */
    public boolean setStrokeWeight(int strokeWeight)
    {
        if (strokeWeight < 0)
            return false;
            
        this.strokeWeight = strokeWeight;
        return true;
    }

    /**
     * Returns the fill color of the shape
     * @return fill color of the shape
     */
    public int getFillColor()
    {
        return fillColor;
    }

    /**
     * Sets the fill color of the shape to the specified fill color
     * @param fillColor the fillColor to replace the current fillColor with
     * @pre the fillColor must be a valid color between white and black
     * @return true if it's set to the new value and false if not
     * @post fill color of the shape may not be set if the param is not a valid color
     */
    public boolean setFillColor(int fillColor)
    {
        if (fillColor < 0 || fillColor > 16777216)
            return false;
            
        this.fillColor = fillColor;
        return true;
    }

    /**
     * Returns the stroke color of the shape
     * @return stroke color of the shape
     */
    public int getStrokeColor()
    {
        return strokeColor;
    }

    /**
     * Sets the stroke color of the shape to the specified stroke color
     * @param strokeColor the strokeColor to replace the current strokeColor with
     * @pre the strokeColor must be a valid color between white and black
     * @return true if it's set to the new value and false if not
     * @post stroke color of the shape may not be set if the param is not a valid color
     */
    public boolean setStrokeColor(int strokeColor)
    {
        if (strokeColor < 0 || strokeColor > 16777216)
            return false;
            
        this.strokeColor = strokeColor;
        return true;
    }

}
