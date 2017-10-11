package rishikesh.shapes;

import processing.core.PApplet;

public class RegularPolygon extends Shape
{

    private int numSides; // # of sides
    private double sideLength; // length of side
    private Circle outCircle; // the circumscribed Circle
    private Circle inCircle; // the inscribed Circle
    private Line[] sides; // array of Line objects for each side

    // constructors
    public RegularPolygon()
    {
        super(0.0, 0.0);
        this.numSides = 3;
        this.sideLength = 100.0;
        outCircle = new Circle();
        inCircle = new Circle();
        sides = new Line[numSides];
        calcr();
        calcR();
        

    }

    public RegularPolygon(int numSides, double sideLength)
    {
        this.numSides = numSides;
        this.sideLength = sideLength;
        outCircle = new Circle();
        inCircle = new Circle();
        sides = new Line[numSides];
        calcr();
        calcR();

    }

    // private methods
    private void calcr()
    {
        double result = 0.5 * sideLength;
        result *= (1 / Math.tan(Math.PI / numSides));
        
        inCircle.setRadius(result);
    }

    private void calcR()
    {
        double result = 0.5 * sideLength;
        result *= (1 / Math.sin(Math.PI / numSides));
        
        outCircle.setRadius(result);
    }

    // public methods
    public double calcVertexAngle()
    {
        double result = (numSides - 2) / numSides;    
        
        return result * 180;
        
    }

    @Override
    public double getArea()
    {
        double result = 0.5 * numSides * getR() * getR();
        result = Math.sin((2 * Math.PI) / numSides);
        
        return result;
    }

    @Override
    public double getPerimeter()
    {
        return numSides * sideLength;
    }

    public int getNumSides()
    {
        return numSides;
    }

    public double getSideLength()
    {
        return sideLength;
    }

    public double getR()
    {
        return outCircle.getRadius();
    }

    public double getr()
    {
        return inCircle.getRadius();
    }

    public void draw(PApplet marker)
    {
        int angle = 90;
        double angle_increment = 360 / numSides;
        
        double previousx = 250, previousy = 250;
        
        for (int i = 0; i < numSides; i++)
        {
            x = 250 + getr() * Math.cos(angle) * sideLength;
            y = 250 + getr() * Math.sin(angle) * sideLength;
            
            sides[i] = new Line(x, y, previousx, previousy);
            
            previousx = x;
            previousy = y;
            angle += angle_increment;
        }
        
        for (int i = 0; i < numSides; i++)
        {
           
            sides[i].draw(marker);
            
           
        }
        
    }

    public void drawBoundingCircles(PApplet marker)
    {
    }

    @Override
    public boolean isPointInside(double x, double y)
    {
        // TODO Auto-generated method stub
        return false;
    }


    
}
