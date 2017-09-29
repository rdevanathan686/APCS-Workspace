package rishikesh.shapes;

import processing.core.PApplet;

public abstract class Shape
{
    protected double x, y;
    private int strokeWeight;
    private int fillColor, strokeColor;

    public Shape()
    {
        this(0.0, 0.0);
        strokeWeight = 1;
        fillColor = 0;
        strokeColor = 0;
    }
    
    public Shape(double x, double y)
    {
        this.x = x;
        this.y = y;
        strokeWeight = 1;
        fillColor = 0;
        strokeColor = 0;
    }

    public void draw(PApplet drawer)
    {
        drawer.pushStyle();
        
        drawer.stroke(strokeColor);
        drawer.fill(fillColor);
        drawer.strokeWeight(strokeWeight);
        
        drawer.popStyle();
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

    public void move(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public void moveBy(double xVel, double yVel)
    {
        this.x += xVel;
        this.y += yVel;
    }

    public double getX()
    {
        return x;
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public double getY()
    {
        return y;
    }

    public void setY(double y)
    {
        this.y = y;
    }

    public double getStrokeWeight()
    {
        return strokeWeight;
    }

    public void setStrokeWeight(int strokeWeight)
    {
        this.strokeWeight = strokeWeight;
    }

    public int getFillColor()
    {
        return fillColor;
    }

    public void setFillColor(int fillColor)
    {
        this.fillColor = fillColor;
    }

    public int getStrokeColor()
    {
        return strokeColor;
    }

    public void setStrokeColor(int strokeColor)
    {
        this.strokeColor = strokeColor;
    }

}
