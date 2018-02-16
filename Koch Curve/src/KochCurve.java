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
    private ArrayList<Line> kochLines;
    
    public KochCurve(int level, double length, double angle, Point2D.Double start)
    {
        kochLines = new ArrayList<Line>();
        create(start, length, angle, level);        
    }

    public void draw(PApplet marker)
    {
        for (Line line: kochLines)
            marker.line(line.getX1(), line.getY1(), line.getX2(), line.getY2());
    }

    private void create(Point2D.Double start, double length, double angle, int k)
    {
        if (k < 1)
        {
            kochLines.add(new Line((float)start.x, (float)start.y, (float)((start.x) + (length * (Math.cos(Math.toRadians(angle))))), 
                    (float)(start.y + (length * (Math.sin(Math.toRadians(angle)))))));
        }
        else
        {
            
            create(start, length / 3, angle, k - 1);
            
            double x = ((start.x) + (length / 3 * (Math.cos(Math.toRadians(angle)))));
            double y = (start.y + (length / 3 * (Math.sin(Math.toRadians(angle)))));
            
            create(new Point2D.Double(x, y), length / 3, angle - 60, k - 1);
            
            x += (length / 3 * (Math.cos(Math.toRadians(angle - 60))));
            y += (length / 3 * (Math.sin(Math.toRadians(angle - 60))));
            
            create(new Point2D.Double(x, y), length / 3, angle + 60, k - 1);
            
            x += (length / 3 * (Math.cos(Math.toRadians(angle + 60))));
            y += (length / 3 * (Math.sin(Math.toRadians(angle + 60))));
            
            create(new Point2D.Double(x, y), length / 3, angle, k - 1);

        }

    }

    public class Line
    {
        float x1, y1, x2, y2;
        
        public Line(float x1, float y1, float x2, float y2)
        {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2; 
        }

        public float getX1()
        {
            return x1;
        }

        public void setX1(float x1)
        {
            this.x1 = x1;
        }

        public float getY1()
        {
            return y1;
        }

        public void setY1(float y1)
        {
            this.y1 = y1;
        }

        public float getX2()
        {
            return x2;
        }

        public void setX2(float x2)
        {
            this.x2 = x2;
        }

        public float getY2()
        {
            return y2;
        }

        public void setY2(float y2)
        {
            this.y2 = y2;
        }
    }

}
