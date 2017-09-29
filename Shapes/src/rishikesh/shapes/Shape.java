package rishikesh.shapes;
import processing.core.PApplet;

public class Shape
{
    protected double x, y;
    protected int strokeWeight;
    protected int fillColor, strokeColor;
    
    public Shape()
    {
        x = 0.0;
        y = 0.0;
        strokeWeight = 1;
        fillColor = 0;
        strokeColor = 0;
    }
    
    public void draw(PApplet drawer)
    {
        drawer.pushMatrix();
        
        drawer.popMatrix();
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
