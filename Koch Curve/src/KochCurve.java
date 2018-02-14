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
        drawKochCurve(50, 200, 50 + length, 200, 1, marker);
    }

    private void drawKochCurve(float x1, float y1, float x2, float y2, int k, PApplet marker)
    {
        if (k < 1)
            marker.line(x1, y1, x2, y2);
        else
        {

            float lengthX = (x2 - x1) / 3;
            float lengthY = (y2 - y1) / 3;
            float length = (float) Point2D.distance(x1, y1, x2, y2);
            
            float startX = x1;
            float startY = y1;
            float endX = x2 + lengthX;
            float endY = y2 + lengthY;

            drawKochCurve(startX, startY, endX, endY, k - 1, marker);

            startX = endX;
            startY = endY;
            endX = (float) (startX + ((lengthX * 0.5) + lengthY * (Math.sin(Math.toRadians(60)))));
            endY = (float) (startY + ((lengthY * 0.5) - lengthX * (Math.sin(Math.toRadians(60)))));

            drawKochCurve(startX, startY, endX, endY, k - 1, marker);
            
            startX = endX;
            startY = endY;
            endX = x2 - lengthX;
            endY = y2 - lengthY;
            
            drawKochCurve(startX, startY, endX, endY, k - 1, marker);

            startX = endX;
            startY = endY;
            endX = x2;
            endY = y2;
            
            drawKochCurve(startX, startY, endX, endY, k - 1, marker);

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
