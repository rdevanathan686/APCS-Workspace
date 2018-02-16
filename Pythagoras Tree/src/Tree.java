import java.awt.geom.Point2D;
import java.util.ArrayList;



import processing.core.PApplet;
import rishikesh.shapes.Line;
import rishikesh.shapes.Rectangle;


/**
 * KochCurve.java
 * 
 * 
 * @author Rishikesh Devanathan
 * @version 1.0
 */
public class Tree
{
    private ArrayList<Line> branches;
    
    public Tree(int level, double length, double angle, Point2D.Double start)
    {
        branches = new ArrayList<Line>();
        create(start, length, angle, level, level * 2);        
    }

    public void draw(PApplet marker)
    {
        for (Line branch: branches)
            branch.draw(marker);
    }

    private void create(Point2D.Double start, double length, double angle, int k, int stroke)
    {
        if (k < 1)
        {
            Line next = new Line((float)start.x, (float)start.y, (float)((start.x) + (length * (Math.cos(Math.toRadians(angle))))), 
                    (float)(start.y + (length * (Math.sin(Math.toRadians(angle))))));
            next.setStrokeWeight(stroke);
            branches.add(next);
        }
        else
        {
            
            double x = ((start.x) + (length / 3 * (Math.cos(Math.toRadians(angle)))));
            double y = (start.y + (length / 3 * (Math.sin(Math.toRadians(angle)))));
            
            create(new Point2D.Double(x, y), length / 3, angle - 60, k - 1, stroke - 1);
            
            x = ((start.x) - (length / 3 * (Math.cos(Math.toRadians(angle)))));
            y = (start.y - (length / 3 * (Math.sin(Math.toRadians(angle)))));
            
            create(new Point2D.Double(x, y), length / 3, angle + 60, k - 1, stroke - 1);
            
           

        }

    }

}
