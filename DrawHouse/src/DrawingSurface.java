import java.awt.Color;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PShape;

public class DrawingSurface extends PApplet
{

    private House house;
    private Person person, person2;

    public static final float SCREEN_WIDTH = 500f;
    public static final float SCREEN_HEIGHT = 500f;

    public static final String RIGHT = "RIGHT";
    public static final String LEFT = "LEFT";
    public static final String UP = "UP";
    public static final String DOWN = "DOWN";

    // create the house and person objects
    public DrawingSurface()
    {
        house = new House();
        person = new Person(100, 300, RIGHT);
        person2 = new Person(402, 300, LEFT);
    }

    // loops 60 times/sec to draw the characters with the updated changes
    public void draw()
    {
        // to scale the window
        scale((float) width / SCREEN_WIDTH, (float) height / SCREEN_HEIGHT);

        // drawing the background first
        PShape background = createShape(PApplet.GROUP);
        PShape floor = createShape(PConstants.RECT, 0, 300, 500, 300);
        PShape sky = createShape(PConstants.RECT, 0, 0, 500, 300);

        floor.setFill(color(174, 239, 158));
        sky.setFill(color(158, 189, 239));

        background.addChild(floor);
        background.addChild(sky);

        shape(background);

        // drawing the house and the two people
        house.draw(this);
        person.draw(this);
        person2.draw(this);
        
        // control the jump of the person
        if (person.getAltitude() != 0)
            person.jump();
        if (person2.getAltitude() != 0)
            person2.jump();

        
        if (person.getSaberLine() != null && person2.getSaberLine() != null)
        {
            // change the color of the person if the saber hits them
            if (person.getSaberLine().intersects(person2.leftHandLine()) 
                    || person.getSaberLine().intersects(person2.rightHandLine()))
                person2.setColor(Person.HIT_COLOR);
            else
                person2.setColor(Person.DEFAULT_COLOR);

            if (person.rightHandLine().intersects(person2.getSaberLine())
                    || person.leftHandLine().intersects(person2.getSaberLine()))
                person.setColor(Person.HIT_COLOR);
            else
                person.setColor(Person.DEFAULT_COLOR);

            // draw the sparks in the line of intersection
            if (person.getSaberLine().intersects(person2.getSaberLine()))
            {
                float intersectionX = (float) person.getSaberLine().getPx(person2.getSaberLine());
                float intersectionY = (float) person.getSaberLine().getPy(person2.getSaberLine());

                line(intersectionX, intersectionY - 5, intersectionX - 2, intersectionY - 20);
                line(intersectionX - 5, intersectionY, intersectionX - 10, intersectionY);
                line(intersectionX + 2, intersectionY + 2, intersectionX + 10, intersectionY - 2);
                line(intersectionX, intersectionY + 4, intersectionX + 2, intersectionY + 10);

            }

        }

    }

    /*
     * mouseDragged listener that calls the move method in the house to change its x
     * and y coordinates
     */
    public void mouseDragged()
    {

        int translateX = mouseX - (pmouseX);
        int translateY = mouseY - (pmouseY);
        
        house.move(translateX, translateY);

    }

    /*
     * mouseWheel listener that calls the zoom method in the house to change its
     * scaleFactor
     */
    @SuppressWarnings("deprecation")
    public void mouseWheel()
    {
        int direction = mouseEvent.getCount();
        float change;

        if (direction > 0.0f)
            change = 1.05f;
        else if (direction < 0.0f)
            change = 1.0f / 1.05f;
        else change = 1.0f;

        house.zoom(change);

    }

    /*
     * keyPressed listener that controls the keyboard based movements
     */
    public void keyPressed()
    {
        if (!person.leftHandLine().intersects(person2.rightHandLine()))
            if (keyCode == PApplet.RIGHT)
                person2.move(RIGHT);
        if (!person.rightHandLine().intersects(person2.leftHandLine()))
            if (keyCode == PApplet.LEFT)
                person2.move(LEFT);
        if (keyCode == PApplet.UP)
            person2.move(UP);
        if (keyCode == PApplet.DOWN)
            person2.move(DOWN);
        if (keyCode == PApplet.SHIFT)
        {
            if (person2.getAltitude() == 0)
            {
                person2.setFloor(person2.getyPos());
                person2.jump();
            }
            
        }
        if (keyCode == PApplet.CONTROL)
        {
            if (person2.getSaberSide() == LEFT)
                person2.setSaberSide(RIGHT);
            else
                person2.setSaberSide(LEFT);
        }
            
            
        if (!person.rightHandLine().intersects(person2.leftHandLine()))
            if (keyCode == 'D')
                person.move(RIGHT);
        if (!person.leftHandLine().intersects(person2.rightHandLine()))
            if (keyCode == 'A')
                person.move(LEFT);
        if (keyCode == 'S')
            person.move(DOWN);
        if (keyCode == 'W')
            person.move(UP);
        if (keyCode == 'J')
        {
            if (person.getAltitude() == 0)
            {
                person.setFloor(person.getyPos());
                person.jump();
            }
            
        }
        if (keyCode == 'C')
        {
            if (person.getSaberSide() == LEFT)
                person.setSaberSide(RIGHT);
            else
                person.setSaberSide(LEFT);
        }
        

        if (keyCode == PApplet.ENTER)
        {
            
            Color random1 = new Color((int) (Math.random() * 255), (int) (Math.random() * 255),
                    (int) (Math.random() * 255));
            Color random2 = new Color((int) (Math.random() * 255), (int) (Math.random() * 255),
                    (int) (Math.random() * 255));
            person.setSaberColor(random1);
            person2.setSaberColor(random2);
            
            
        }

    }

}
