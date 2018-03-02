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
public class SierpinskiTriangle
{
    int level;
    double length, angle;
    Point2D.Double start;

    public SierpinskiTriangle(int level, double length, double angle, Point2D.Double start)
    {
        this.length = length;
        this.level = level;
        this.start = start;
    }

    public void draw(PApplet marker)
    {
        create(start, length, level, marker);
    }

    private void create(Point2D.Double start, double length, int k, PApplet marker)
    {
        if (k < 1)
        {
            marker.triangle((float) start.x, (float) start.y,
                    (float) ((start.x) + (length * (Math.cos(Math.toRadians(60))))),
                    (float) (start.y + (length * (Math.sin(Math.toRadians(60))))),
                    (float) ((start.x) - (length * (Math.cos(Math.toRadians(60))))),
                    (float) (start.y + (length * (Math.sin(Math.toRadians(60))))));
        } 
        else
        {

            length /= 2;

            create(start, length, k - 1, marker);
            create(new Point2D.Double(start.x + (length / 2), start.y + length * (Math.sin(Math.toRadians(60)))),
                    length, k - 1, marker);
            create(new Point2D.Double(start.x - (length / 2), start.y + length * (Math.sin(Math.toRadians(60)))),
                    length, k - 1, marker);

        }

    }

}