import java.awt.geom.*; // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import processing.core.PApplet; // for Processing
import rishikesh.shapes.Shape;

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
        for (int i = 0; i < myPolygon.size() - 1; i++)
        {
            marker.line((float) myPolygon.get(i).getX(), (float) myPolygon.get(i).getY(), 
                    (float) myPolygon.get(i + 1).getX(), (float) myPolygon.get(i + 1).getY());
        }
        
        if (myPolygon.size() >= 2)
            marker.line((float) myPolygon.get(0).getX(), (float) myPolygon.get(0).getY(), 
                (float) myPolygon.get(myPolygon.size() - 1).getX(), (float) myPolygon.get(myPolygon.size() - 1).getY());
    }

    @Override
    public double getArea()
    {
        double area = 0;
        
        for (int i = 0; i < myPolygon.size(); i++)
        {
            
        }
        return area;
    }

    @Override
    public double getPerimeter()
    {
        double perimeter = 0;
        
        for(int i = 0; i < myPolygon.size() - 1; i++)        
        {
            perimeter += myPolygon.get(i).distance(myPolygon.get(i + 1));
        }
        
        return perimeter;
    }

    @Override
    public boolean isPointInside(double arg0, double arg1)
    {
        // TODO Auto-generated method stub
        return false;
    }
}
