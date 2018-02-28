import java.awt.geom.Point2D;
import java.util.ArrayList;

import processing.core.PApplet;


/**
 * KochCurve.java
 * 
 * 
 * @author Rishikesh Devanathan
 * @version 1.0
 */
public class KochCurve
{
    int level;
    double length, angle;
    Point2D.Double start;
    
    public KochCurve(int level, double length, double angle, Point2D.Double start)
    {
        this.length = length;
        this.level = level;
        this.start = start;
    }

    public void draw(PApplet marker)
    {
        create(start, length, angle, level, marker);  
    }

    private void create(Point2D.Double start, double length, double angle, int k, PApplet marker)
    {
        if (k < 1)
        {
            if (length == this.length)
                marker.triangle((float)start.x, (float)start.y, (float)(start.x + (start.x * 0.5)),
                        (float)(start.y + (start.y * 0.866025)), (float)(start.x - (start.x * 0.5)), 
                        (float)(start.y + (start.y * 0.866025)));
            else
                marker.triangle((float)start.x, (float)start.y, (float)((start.x) + (length * (Math.cos(Math.toRadians(angle))))), 
                        (float)(start.y + (length * (Math.sin(Math.toRadians(angle))))), (float)((start.x) + (length * (Math.cos(Math.toRadians(-angle))))), 
                        (float)(start.y + (length * (Math.sin(Math.toRadians(-angle))))));
        } 
        else
        {
            
//            create(start, length / 3, angle, k - 1);
//            
//            double x = ((start.x) + (length / 3 * (Math.cos(Math.toRadians(angle)))));
//            double y = (start.y + (length / 3 * (Math.sin(Math.toRadians(angle)))));
//            
//            create(new Point2D.Double(x, y), length / 3, angle - 60, k - 1);
//            
//            x += (length / 3 * (Math.cos(Math.toRadians(angle - 60))));
//            y += (length / 3 * (Math.sin(Math.toRadians(angle - 60))));
//            
//            create(new Point2D.Double(x, y), length / 3, angle + 60, k - 1);
//            
//            x += (length / 3 * (Math.cos(Math.toRadians(angle + 60))));
//            y += (length / 3 * (Math.sin(Math.toRadians(angle + 60))));
//            
//            create(new Point2D.Double(x, y), length / 3, angle, k - 1);
            
            create(start, length, angle, k, marker);

        }

    }

}