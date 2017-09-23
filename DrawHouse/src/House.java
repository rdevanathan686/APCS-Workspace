import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PShape;

public class House
{
    private float scaleFactor;
    private float xPos;
    private float yPos;

    public House()
    {
        scaleFactor = 1f;
        xPos = 116.0f;
        yPos = -86.0f;
    }

    // method called by the DrawingSurface class to draw the the house
    public void draw(PApplet drawer)
    {

        drawer.pushMatrix();

        PShape house = new PShape();
        house = drawer.createShape(PConstants.GROUP);
        
        house.translate(xPos, yPos);
        
        house.translate(DrawingSurface.SCREEN_WIDTH / 2, DrawingSurface.SCREEN_HEIGHT / 2);
        house.scale(scaleFactor, scaleFactor);
        house.translate(-DrawingSurface.SCREEN_WIDTH / 2, -DrawingSurface.SCREEN_HEIGHT / 2);
        
        PShape body  = drawer.createShape(PConstants.RECT, 125, 250, 250, 160);
        PShape roof = drawer.createShape(PConstants.TRIANGLE, 125, 250, 375, 250, 250, 125);
        PShape windowLeft = drawer.createShape(PConstants.RECT, 148, 270, 40, 40);
        PShape windowRight = drawer.createShape(PConstants.RECT, 313, 275, 40, 40);
        PShape door = drawer.createShape(PConstants.RECT, 230, 330, 40, 80);
        
        body.setFill(drawer.color(191, 229, 153));
        roof.setFill(drawer.color(226, 88, 24));
        windowLeft.setFill(drawer.color(99, 141, 211));
        windowRight.setFill(drawer.color(99, 141, 211));
        door.setFill(drawer.color(209, 176, 79));
        
        house.addChild(body);
        house.addChild(roof);
        house.addChild(windowLeft);
        house.addChild(windowRight);
        house.addChild(door);

        
        drawer.shape(house);
        
        drawer.popMatrix();

    }

    /*
     * method called by the mouseWheel listener to handle with the changes in the
     * size of the house
     */
    public void zoom(float change)
    {
        scaleFactor *= change;
    }

    /*
     * method called by the mouseDragged listener to handle with the changes in the
     * x and y coordinates of the house
     */
    public void move(int changeX, int changeY)
    {
        xPos += changeX;
        yPos += changeY;
    }
    
    
    // mutators and accessors
    public float getScaleFactor()
    {
        return scaleFactor;
    }

    public void setScaleFactor(float scaleFactor)
    {
        this.scaleFactor = scaleFactor;
    }

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

    public void setyPos(float yPos)
    {
        this.yPos = yPos;
    }


}
