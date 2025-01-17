import java.awt.Color;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PShape;

public class Person
{

    // data belonging to the person
    private float xPos, yPos;
    private float altitude, floor;
    private Color color;
    
    // data belonging to the saber (can be perfected by creating a saber class
    private Color saberColor;
    private String saberSide;

    // Constants describing the person
    public static final Color HIT_COLOR = new Color(239, 157, 148);
    public static final Color DEFAULT_COLOR = new Color(239, 192, 122);

    public Person(int initX, int initY, String saberSide)
    {
        xPos = initX;
        yPos = initY;
        altitude = 0.0f;
        floor = 0.0f;
        
        saberColor = Color.RED;
        color = DEFAULT_COLOR;
        this.saberSide = saberSide;
    }

    // method called by the DrawingSurface class draw the person
    public void draw(PApplet drawer)
    {
        drawer.pushMatrix();

        drawer.translate(xPos, yPos);

        PShape person = drawer.createShape(PConstants.GROUP);
        PShape head = drawer.createShape(PConstants.ELLIPSE, 20, 0, 30, 30);
        PShape body = drawer.createShape(PConstants.RECT, 0, 15, 40, 70);
        PShape leftHand = drawer.createShape(PConstants.RECT, -5, 15, 8, 50);
        PShape rightHand = drawer.createShape(PConstants.RECT, 35, 15, 8, 50);
        PShape leftLeg = drawer.createShape(PConstants.RECT, 0, 85, 15, 40);
        PShape rightLeg = drawer.createShape(PConstants.RECT, 25, 85, 15, 40);
        PShape saber = drawer.createShape(PConstants.LINE, 43, 65, 95, 20);


        if (saberSide == DrawingSurface.LEFT)
            saber = drawer.createShape(PConstants.LINE, -5, 65, -57, 20);

        saber.setStrokeWeight(3);
        saber.setStroke(drawer.color(saberColor.getRed(), 
                saberColor.getGreen(), saberColor.getBlue()));

        head.setFill(drawer.color(color.getRed(), color.getGreen(), color.getBlue()));
        body.setFill(drawer.color(color.getRed(), color.getGreen(), color.getBlue()));
        leftHand.setFill(drawer.color(color.getRed(), color.getGreen(), color.getBlue()));
        rightHand.setFill(drawer.color(color.getRed(), color.getGreen(), color.getBlue()));
        leftLeg.setFill(drawer.color(color.getRed(), color.getGreen(), color.getBlue()));
        rightLeg.setFill(drawer.color(color.getRed(), color.getGreen(), color.getBlue()));

        person.addChild(head);
        person.addChild(body);
        person.addChild(rightHand);
        person.addChild(leftHand);
        person.addChild(rightLeg);
        person.addChild(leftLeg);
        person.addChild(saber);

        drawer.shape(person);

        drawer.popMatrix();

    }

    /*
     * method called by the keyPressed listener to handle with the changes in the x
     * and y coordinates of the person
     */
    public void move(String string)
    {
        // bound check
        if (xPos <= 450)
            if (string == DrawingSurface.RIGHT)
                xPos += 5;
        if (xPos >= 0)
            if (string == DrawingSurface.LEFT)
                xPos -= 5;

        if (yPos >= 230)
            if (string == DrawingSurface.UP)
                yPos -= 5;
        if (yPos <= 400)
            if (string == DrawingSurface.DOWN)
                yPos += 5;

    }

    
    public void jump()
    {
        if (altitude == 0)
            altitude = -4;

        if (yPos + altitude > floor)
            altitude = 0;

        if (yPos < floor - 100)
            altitude = -altitude;

        yPos += altitude;
    }

    // returns the boundary of the line and the person
    public Line getSaberLine()
    {
        Line saberLine = null;

        if (saberSide == DrawingSurface.LEFT)
            saberLine = new Line(-5 + xPos, 65 + yPos, -57 + xPos, 20 + yPos);
        else if (saberSide == DrawingSurface.RIGHT)
            saberLine = new Line(43 + xPos, 65 + yPos, 95 + xPos, 20 + yPos);

        return saberLine;
    }

    public Line leftHandLine()
    {
        Line leftHandLine = new Line(-10 + xPos, 15 + yPos, -4 + xPos, 125 + yPos);

        return leftHandLine;
    }

    public Line rightHandLine()
    {

        Line rightHandLine = new Line(48 + xPos, 15 + yPos, 42 + xPos, 125 + yPos);

        return rightHandLine;
    }

    
    // mutators and accessors
    public float getxPos()
    {
        return xPos;
    }

    public void setxPos(float xPos)
    {
        this.xPos = xPos;
    }

    public float getyPos()
    {
        return yPos;
    }
    
    public float getAltitude()
    {
        return altitude;
    }

    public void setAltitude(float altitude)
    {
        this.altitude = altitude;
    }

    public void setyPos(float yPos)
    {
        this.yPos = yPos;
    }
    
    public float getFloor()
    {
        return floor;
    }

    public void setFloor(float floor)
    {
        this.floor = floor;
    }
    
    public void setColor(Color color)
    {
        this.color = color;
    }
    
    public Color getColor()
    {
        return color;
    }

    public Color getSaberColor()
    {
        return saberColor;
    }

    public void setSaberColor(Color saberColor)
    {
        this.saberColor = saberColor;
    }

    public String getSaberSide()
    {
        return saberSide;
    }

    public void setSaberSide(String saberSide)
    {
        this.saberSide = saberSide;
    }
    
    

}
