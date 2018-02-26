import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Random;

import processing.core.PApplet;
import rishikesh.shapes.Line;

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
    private float x, y;
    private float scaleFactor;
    private float deltaAngle;
    public static boolean isRandom;

    public Tree(int level, double length, float angle, Point2D.Double start, float scaleFactor)
    {
        this.scaleFactor = scaleFactor;
        this.deltaAngle = angle;
        
        branches = new ArrayList<Line>();
        create(start, length, 90, level, level);

    }

    public void draw(PApplet marker)
    {
        marker.pushMatrix();
        
        marker.translate(Main.SCREEN_WIDTH / 2, Main.SCREEN_HEIGHT / 2);
        marker.scale(scaleFactor, scaleFactor);
        marker.translate(-Main.SCREEN_WIDTH / 2, -Main.SCREEN_HEIGHT / 2);
        
        for (Line branch : branches)
            branch.draw(marker);
        
        x = (float) branches.get(branches.size() - 1).getX();
        y = (float) branches.get(branches.size() - 1).getY();
        
        marker.popMatrix();
    }

    private void create(Point2D.Double start, double length, double angle, int k, int stroke)
    {
        if (k < 1)
            return;
        else
        {
            
            if (isRandom && angle != 90)
            {
                angle += (float) new Random().nextInt((20 - -20) + 1) - 20;
                length += (float) new Random().nextInt((5 - -5) + 1) - 5;
            }
                
            Line next = new Line((float) start.x, (float) start.y,
                    (float) (start.x - (length * (Math.cos(Math.toRadians(angle))))),
                    (float) (start.y - (length * (Math.sin(Math.toRadians(angle))))));

            next.setStrokeWeight(stroke);

            double x = (start.x - (length * (Math.cos(Math.toRadians(angle)))));
            double y = (start.y - (length * (Math.sin(Math.toRadians(angle)))));

            create(new Point2D.Double(x, y), length / (1.5), (angle) - deltaAngle, k - 1, stroke - 1);
            create(new Point2D.Double(x, y), length / (1.5), (angle) + deltaAngle, k - 1, stroke - 1);
            
            branches.add(next);

        }

    }

    public void move(float deltaX, float deltaY)
    {
        for (Line branch: branches) 
        {
            branch.setX(branch.getX() + deltaX);
            branch.setX2(branch.getX2() + deltaX);
            branch.setY(branch.getY() + deltaY);
            branch.setY2(branch.getY2() + deltaY);
        }
        
    }
    
    public void zoom(float change)
    {
        scaleFactor *= change;
    }

    public float getX()
    {
        return x;
    }

    public void setX(float x)
    {
        this.x = x;
    }

    public float getY()
    {
        return y;
    }

    public void setY(float y)
    {
        this.y = y;
    }

    public float getScaleFactor()
    {
        return scaleFactor;
    }

    public void setScaleFactor(float scaleFactor)
    {
        this.scaleFactor = scaleFactor;
    }

    public float getDeltaAngle()
    {
        return deltaAngle;
    }

    public void setDeltaAngle(float deltaAngle)
    {
        this.deltaAngle = deltaAngle;
    }

    
    

}
