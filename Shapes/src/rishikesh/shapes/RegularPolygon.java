package rishikesh.shapes;

import processing.core.PApplet;

public class RegularPolygon extends Shape
{

    private int numSides; 
    private double sideLength; 
    private Circle outCircle; 
    private Circle inCircle; 
    private Line[] sides; 

    /**
     * Default constructor that creates a 
     * triangle with 100 pixel of side length
     */
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
        calcVertexAngle();

    }

    /**
     * Parameter-taking constructor that creates a polygon with the given
     * number of sides and the side length of each side
     * @param numSides
     * @param sideLength
     */
    public RegularPolygon(int numSides, double sideLength)
    {
        this.numSides = numSides;
        this.sideLength = sideLength;
        outCircle = new Circle();
        inCircle = new Circle();
        sides = new Line[numSides];
        calcr();
        calcR();
        calcVertexAngle();

    }

    // private methods
    private void calcr()
    {
        double result = 0.5 * sideLength / Math.tan(Math.PI / numSides);

        inCircle.setRadius(result);
    }

    private void calcR()
    {
        double result = 0.5 * sideLength / Math.sin(Math.PI / numSides);

        outCircle.setRadius(result);
    }

    // public methods
    public double calcVertexAngle()
    {
        double result = (double) (numSides - 2) / numSides;

        return result * 180;

    }

    @Override
    public double getArea()
    {
        double result = 0.5 * numSides * getR() * getR();
        result = Math.sin((2 * Math.PI) / (double) numSides);

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
        int angle = 180;
        double angle_increment = 360 / numSides;

        double previousx = 250 - (sideLength / 2), previousy = 250 - (sideLength / 2);

        for (int i = 0; i < numSides; i++)
        {
            x = 250 + getr() * Math.cos(Math.toRadians(angle));
            y = 250 + getr() * Math.sin(Math.toRadians(angle));

            sides[i] = new Line(x, y, previousx, previousy);

            previousx = x;
            previousy = y;

            angle += angle_increment;
        }

        sides[0] = new Line(sides[sides.length - 1].getX(), sides[sides.length - 1].getY(),
                sides[1].getX2(), sides[1].getY2());

        for (int i = 0; i < numSides; i++)
        {
            sides[i].setStrokeWeight(2);
            sides[i].draw(marker);

        }

    }

    public void drawBoundingCircles(PApplet marker)
    {
        
        inCircle.setX(250);
        inCircle.setY(250);

        outCircle.setX(250);
        outCircle.setY(250);

        outCircle.draw(marker);
        inCircle.draw(marker);
        
    }

    @Override
    public boolean isPointInside(double x, double y)
    {
        // TODO Auto-generated method stub
        return false;
    }

}
