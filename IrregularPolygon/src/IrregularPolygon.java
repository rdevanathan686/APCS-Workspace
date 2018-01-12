import java.awt.geom.*; // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import processing.core.PApplet; // for Processing
import rishikesh.shapes.Shape;

/*
 * I like the idea of using the center of mass, as it shows me roughly where the middle of the shape is. 
 * 
 * I think the center of mass function should only work when there is more than 3 points. 
 * If there's 2 points and it draws a random point it looks a bit weird
 * 
 * Another improvement i would recommend is to create a separate array list for each side. 
 * This would make expandability easier and bug fixing easier as well.
 */

public class IrregularPolygon extends Shape
{
    private ArrayList<Point2D.Double> myPolygon;

    // constructors
    public IrregularPolygon()
    {
        myPolygon = new ArrayList<Point2D.Double>();
    }

    // public methods
    public void add(Point2D.Double aPoint)
    {
        myPolygon.add(aPoint);
    }

    public void draw(PApplet marker)
    {

        for (int i = 0; i < myPolygon.size(); i++)
        {
            marker.line((float) myPolygon.get(i).getX(), (float) myPolygon.get(i).getY(),
                    (float) myPolygon.get((i + 1) % myPolygon.size()).getX(),
                    (float) myPolygon.get((i + 1) % myPolygon.size()).getY());
        }

    }

    @Override
    public double getArea()
    {
        int n = myPolygon.size();
        int area = 0;

        for (int i = 0; i < n; i++)
        {
            area += myPolygon.get(i).x * (myPolygon.get((i + 1) % n).y - myPolygon.get((i + n - 1) % n).y);
            // area += myPolygon.get(i)
        }

        return Math.abs(area / 2.0);
    }

    @Override
    public double getPerimeter()
    {
        double perimeter = 0;

        for (int i = 0; i < myPolygon.size(); i++)
        {
            perimeter += myPolygon.get(i).distance(myPolygon.get((i + 1) % myPolygon.size()));
        }

        return perimeter;
    }

    @Override
    public boolean isPointInside(double arg0, double arg1)
    {
        // TODO Auto-generated method stub
        return false;
    }

    public Point2D.Double centerOfMass()
    {
        Point2D.Double center = new Point2D.Double();

        double x = 0;
        double y = 0;

        for (int i = 0; i < myPolygon.size(); i++)
        {
            x += myPolygon.get(i).x;
            y += myPolygon.get(i).y;
        }

        center.setLocation(x / myPolygon.size(), y / myPolygon.size());

        return center;
    }

    public boolean isEquilateral()
    {

        if (myPolygon.size() <= 0)
            return false;

        for (int i = 0; i < myPolygon.size() - 1; i++)
        {

            if (!(Math.abs(myPolygon.get(i).distance(centerOfMass())
                    - myPolygon.get(i + 1).distance(centerOfMass())) <= 0.00001))
                return false;

        }

        return true;

    }

    public void translate(Point2D.Double a)
    {

        for (int i = 0; i < myPolygon.size(); i++)
            myPolygon.get(i).setLocation(myPolygon.get(i).x + a.x, myPolygon.get(i).y + a.y);

    }

}
