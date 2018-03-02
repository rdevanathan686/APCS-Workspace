import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.util.Random;

import processing.core.PApplet;
import processing.event.MouseEvent;

public class DrawingSurface extends PApplet
{

    private Tree pTree;
    private int level, length;
    private float deltaAngle;

    public DrawingSurface()
    {
        level = 7;
        length = 125;
        deltaAngle = 30;

        pTree = new Tree(level, length, deltaAngle, new Point2D.Double(250, 450), 1);
    }

    // The statements in the setup() function
    // execute once when the program begins
    public void setup()
    {
        frameRate(30);
    }

    // The statements in draw() are executed until the
    // program is stopped. Each statement is executed in
    // sequence and after the last line is read, the first
    // line is executed again.
    public void draw()
    {

        background(255); // Clear the screen with a white background

        textSize(12);
        fill(0);
        text("Use the mouse wheel to change length, use UP/DOWN keys to change level.\n"
                + "Press R to randomize the tree and SPACE to increase the angle of seperation.\n"
                + "Drag the mouse to move the tree.", 0, 15);

        stroke(0);
        pTree.draw(this);

    }

    public void mouseWheel(MouseEvent event)
    {
        int direction = mouseEvent.getCount();
        float change;

        if (direction > 0.0f)
            change = 1.05f;
        else if (direction < 0.0f)
            change = 1.0f / 1.05f;
        else
            change = 1.0f;

        pTree.zoom(change);

    }

    public void keyPressed()
    {
        if (keyCode == KeyEvent.VK_UP && (level != 15))
        {
            level++;
            pTree = new Tree(level, length, deltaAngle, new Point2D.Double(pTree.getX(), pTree.getY()),
                    pTree.getScaleFactor());

        } else if (keyCode == KeyEvent.VK_DOWN && (level != 1))
        {
            level--;
            pTree = new Tree(level, length, deltaAngle, new Point2D.Double(pTree.getX(), pTree.getY()),
                    pTree.getScaleFactor());
        } else if (keyCode == KeyEvent.VK_SPACE)
        {
            deltaAngle = (float) new Random().nextInt((30 - 20) + 1) + 20;

            pTree = new Tree(level, length, deltaAngle, new Point2D.Double(pTree.getX(), pTree.getY()),
                    pTree.getScaleFactor());
        } else if (keyCode == KeyEvent.VK_R)
        {
            Tree.isRandom = !Tree.isRandom;

            pTree = new Tree(level, length, deltaAngle, new Point2D.Double(pTree.getX(), pTree.getY()),
                    pTree.getScaleFactor());
        }

    }

    public void mouseDragged()
    {
        pTree.move(mouseX - pmouseX, mouseY - pmouseY);
    }

}
