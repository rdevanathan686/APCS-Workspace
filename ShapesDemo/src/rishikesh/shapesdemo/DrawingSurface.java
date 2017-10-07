package rishikesh.shapesdemo;

import java.awt.Color;
import java.util.ArrayList;

import processing.core.PApplet;
import rella.shapes.*;

public class DrawingSurface extends PApplet
{

    private PhysicsShape shapeA;
    private ArrayList<Line> path;
    private boolean startRun;
    int counter = 0;

    public DrawingSurface()
    {
        shapeA = null;
        startRun = false;
        path = new ArrayList<Line>();
    }

    // The statements in the setup() function
    // execute once when the program begins
    public void setup()
    {

        background(255);

    }

    // The statements in draw() are executed until the
    // program is stopped. Each statement is executed in
    // sequence and after the last line is read, the first
    // line is executed again.
    public void draw()
    {
        background(255);

        if (startRun)
            update(counter);

        if (shapeA != null)
            shapeA.draw(this);

            

        for (Line road : path)
            road.draw(this);
    }

    private void update(int counter)
    {
        Line road = path.get(counter);
        double targetX = road.getXf();
        double dx = targetX - shapeA.getBoundingShape().getX();
        shapeA.setVx(dx * 0.05);

        double targetY = road.getYf();
        double dy = targetY - shapeA.getBoundingShape().getY();
        shapeA.setVy(dy * 0.05);
        
        if(Math.abs(shapeA.getVx()) < 0.01 && counter < path.size() - 1)
            this.counter++;

        shapeA.act();

    }

    public void mousePressed()
    {
        if (path.isEmpty())
            path.add(new Line(mouseX, mouseY, mouseX, mouseY));
        else path.add(new Line(path.get(path.size() - 1).getXf(), path.get(path.size() - 1).getYf(),
                mouseX, mouseY));

    }

    public void mouseDragged()
    {
        Line finalLine = path.get(path.size() - 1);
        finalLine.setPoint2(mouseX, mouseY);
        path.remove(path.size() - 1);
        path.add(finalLine);
    }

    public void keyPressed()
    {
        Circle boundingShape = new Circle(path.get(0).getX(), path.get(0).getY(), 20);
        boundingShape.setFillColor(new Color(0, 255, 0));
        shapeA = new PhysicsShape(boundingShape);
        startRun = true;

    }

}
