package rishikesh.shapesdemo;

import java.awt.Color;
import java.util.Stack;

import processing.core.PApplet;
import rella.shapes.*;

public class DrawingSurface extends PApplet
{
    private PhysicsShape shapeA;
    private Stack<Line> path;
    private boolean runStarted;
    private int currentPath = 0;

    public DrawingSurface()
    {
        shapeA = null;
        runStarted = false;
        path = new Stack<Line>();
    }

    public void draw()
    {
        
        background(255);
        
//        pushStyle();
//        textSize(17);
//        fill(color(0, 0, 255));
//        text("Draw a path then press enter for the circle to follow", 30, 20);
//        pushStyle();
        
        for (Line road : path)
            road.draw(this);

        if (runStarted)
            moveToPath(currentPath);

        if (shapeA != null)
            shapeA.draw(this);

        
    }

    private void moveToPath(int pathIndex)
    {
        Line road = path.get(pathIndex);
        
        double finalX = road.getXf();
        double displacementX = finalX - shapeA.getBoundingShape().getX();
        shapeA.setVx(displacementX * PhysicsShape.FRICTION);

        double finalY = road.getYf();
        double displacementY = finalY - shapeA.getBoundingShape().getY();
        shapeA.setVy(displacementY * PhysicsShape.FRICTION);
        
        if((Math.abs(shapeA.getVx()) <= PhysicsShape.STOP_VELOCITY 
                || Math.abs(shapeA.getVy()) <= PhysicsShape.STOP_VELOCITY)
                && pathIndex < path.size() - 1)
            currentPath++;

        shapeA.act();

    }

    public void mousePressed()
    {
        if (path.isEmpty())
        {
            Line newLine = new Line(mouseX, mouseY, mouseX, mouseY);
            newLine.setStrokeWidth(10);
            path.add(newLine);
        }
        else 
        {
            Line lastLine = path.peek();
            Line newLine = new Line(lastLine.getXf(), lastLine.getYf(), mouseX, mouseY);
            newLine.setStrokeWidth(10);
            path.add(newLine);
        }
            

    }

    public void mouseDragged()
    {
        Line finalLine = path.pop();
        finalLine.setPoint2(mouseX, mouseY);
        finalLine.setStrokeWidth(10);
        path.add(finalLine);
    }

    public void keyPressed()
    {
        if (!runStarted)
        {
            
            Circle boundingShape = new Circle(path.firstElement().getX(), path.firstElement().getY(), 30);
            boundingShape.setFillColor(Color.GREEN);
            boundingShape.setStrokeWidth(0);
            shapeA = new PhysicsShape(boundingShape);
            runStarted = true;
            
        }
            
    }

}
