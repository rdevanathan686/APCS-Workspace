import java.awt.Point;
import java.awt.geom.Point2D;

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

    private int level, length;

    public KochCurve(int level, int length)
    {
        this.length = length;
        this.level = level;
    }

    public void draw(PApplet marker)
    {
        drawKochCurve(new Point2D.Double(50, 200), length, 0, 2, marker);
    }

    private void drawKochCurve(Point2D.Double start, double length, double angle, int k, PApplet marker)
    {
        if (k < 1)
            marker.line((float)start.x, (float)start.y, (float)((start.x) + (length * (Math.cos(Math.toRadians(angle))))), (float)(start.y + (length * (Math.sin(Math.toRadians(angle))))));
        else
        {
            drawKochCurve(start, length / 3, angle, k - 1, marker);
            
            double x = ((start.x) + (length / 3 * (Math.cos(Math.toRadians(angle)))));
            double y = (start.y + (length / 3 * (Math.sin(Math.toRadians(angle)))));
            
            drawKochCurve(new Point2D.Double(x, y), length / 3, angle - 60, k - 1, marker);
            
            x += (length / 3 * (Math.cos(Math.toRadians(angle - 60))));
            y += (length / 3 * (Math.sin(Math.toRadians(angle - 60))));
            
            drawKochCurve(new Point2D.Double(x, y), length / 3, angle + 60, k - 1, marker);


//            float lengthX = (x2 - x1) / 3;
//            float lengthY = (y2 - y1) / 3;
//            float length = (float) Point2D.distance(x1, y1, x2, y2);
//            
//            float startX = x1;
//            float startY = y1;
//            float endX = x2 + lengthX;
//            float endY = y2 + lengthY;
//
//            drawKochCurve(startX, startY, endX, endY, k - 1, angle + 60, marker);
//
//            startX = endX;
//            startY = endY;
//            endX = (float) (startX + (int)((lengthX * 0.5) + lengthY * (Math.sin(Math.toRadians(60)))));
//            endY = (float) (startY + (int)((lengthY * 0.5) - lengthX * (Math.sin(Math.toRadians(60)))));
//
//            drawKochCurve(startX, startY, endX, endY, k - 1, marker);
//            
//            startX = endX;
//            startY = endY;
//            endX = x2 - lengthX;
//            endY = y2 - lengthY;
//            
//            drawKochCurve(startX, startY, endX, endY, k - 1, marker);
//
//            startX = endX;
//            startY = endY;
//            endX = x2;
//            endY = y2;
//            
//            drawKochCurve(startX, startY, endX, endY, k - 1, marker);

//
//            startX = endX;
//            startY = endY;
//            endX = (float) (endX + (length * (Math.cos(Math.toRadians(-60)))));
//            endY = (float) (endY - (length * (Math.sin(Math.toRadians(-60)))));
//
//            drawKochCurve(startX, startY, endX, endY, k - 1, marker, length / 3);
//
//            startX = endX;
//            startY = endY;
//            endX += length;
//
//            drawKochCurve(startX, startY, endX, endY, k - 1, marker, length / 3);

        }

    }

    

}
