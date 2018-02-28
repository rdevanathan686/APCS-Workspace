import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Random;

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
public class Box
{
    private double length;
    private int level;
    private Point2D.Double start;
    
    public Box(int level, double length, Point2D.Double start)
    {
        this.start = start;
        this.length = length;
        this.level = level;
    }

    public void draw(PApplet marker)
    {
        marker.pushMatrix();
        
        create(start, level, length, marker);

        
        marker.popMatrix();
    }

    private void create(Point2D.Double start, int k, double length, PApplet marker)
    {
        if (k < 1)
        {
            marker.rect((float)start.x, (float)start.y, (float)(length), (float)(length));
        }
        else
        {
            length /= 3;
            create(new Point2D.Double(start.x, start.y), k - 1, length, marker);
            create(new Point2D.Double(start.x + (length * 2), start.y), k - 1, length, marker);
            create(new Point2D.Double(start.x + (length), start.y + length), k - 1, length, marker);
            create(new Point2D.Double(start.x, start.y + (length * 2)), k - 1, length, marker);
            create(new Point2D.Double(start.x + (length * 2), start.y + (length * 2)), k - 1, length, marker);
        }

    }
}
