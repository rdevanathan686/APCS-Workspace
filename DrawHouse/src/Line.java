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

public class Line
{

    // startPoints
    private double x1, y1;
    // endPoints
    private double x2, y2;

    // Constructor initializing fields
    public Line(double x1, double y1, double x2, double y2)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    // draws the line
    public void draw(DrawingSurface drawingSurface)
    {
        drawingSurface.line((int) x1, (int) y1, (int) x2, (int) y2);
        
    }

    // returns the x intersection coordinate
    public double getPx(Line l2)
    {
        double x3 = l2.x1;
        double x4 = l2.x2;
        double y3 = l2.y1;
        double y4 = l2.y2;

        double num1 = ((x1 * y2 - y1 * x2) * (x3 - x4)) - ((x1 - x2) * (x3 * y4 - y3 * x4));
        double denom = ((x1 - x2) * (y3 - y4)) - ((y1 - y2) * (x3 - x4));

        if (Double.compare(denom, 0.0) == 0.0)
            return 0.0;

        double pX = num1 / denom;

        return pX;
    }

    // returns the y intersection coordinate
    public double getPy(Line l2)
    {
        
        double x3 = l2.x1;
        double x4 = l2.x2;
        double y3 = l2.y1;
        double y4 = l2.y2;

        double num2 = ((x1 * y2 - y1 * x2) * (y3 - y4)) - ((y1 - y2) * (x3 * y4 - y3 * x4));
        double denom = ((x1 - x2) * (y3 - y4)) - ((y1 - y2) * (x3 - x4));

        if (Double.compare(denom, 0.0) == 0.0)
            return 0.0;

        double pY = num2 / denom;

        return pY;
    }

    // check if the intersection point is in the bounds
    public boolean intersects(Line l2)
    {

        if (this.inBounds(getPx(l2), getPy(l2)) 
                && l2.inBounds(l2.getPx(this), l2.getPy(this)))
            
                return true;
        
        return false;

    }

    public boolean inBounds(double pX, double pY)
    {
        return (pX >= Math.min(x1, x2) && pX <= Math.max(x1, x2) && pY >= Math.min(y1, y2)
                && pY <= Math.max(y1, y2));

    }

    // set end points
    public void setPoint2(double x2, double y2)
    {

        this.x2 = x2;
        this.y2 = y2;

    }

    // mutators and accessors
    public double getX1()
    {
        return x1;
    }

    public void setX1(double x1)
    {
        this.x1 = x1;
    }

    public double getY1()
    {
        return y1;
    }

    public void setY1(double y1)
    {
        this.y1 = y1;
    }

    public double getX2()
    {
        return x2;
    }

    public void setX2(double x2)
    {
        this.x2 = x2;
    }

    public double getY2()
    {
        return y2;
    }

    public void setY2(double y2)
    {
        this.y2 = y2;
    }

}
