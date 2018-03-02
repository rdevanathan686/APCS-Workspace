import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

import processing.core.PApplet;
import processing.event.MouseEvent;

public class DrawingSurface extends PApplet
{

    private SierpinskiTriangle curve1;

    private int level, length;

    public DrawingSurface()
    {
        level = 3;
        length = 100;
        curve1 = new SierpinskiTriangle(level, length, 0, new Point2D.Double(150, 100));

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

        textSize(10);
        fill(0);
        text("Use the mouse wheel to change length, use UP/DOWN keys to change level.", 0, 15);

        stroke(0);
        curve1.draw(this);

    }

    public void mouseWheel(MouseEvent event)
    {
        int num = event.getCount();
        length -= num * 10;

        if (length > 0)
        {
            curve1 = new SierpinskiTriangle(level, length, 0, new Point2D.Double(150, 100));

        }

    }

    public void keyPressed()
    {
        if (keyCode == KeyEvent.VK_UP)
        {
            level++;
            curve1 = new SierpinskiTriangle(level, length, 0, new Point2D.Double(150, 100));

        } else if (keyCode == KeyEvent.VK_DOWN)
        {
            level--;
            curve1 = new SierpinskiTriangle(level, length, 0, new Point2D.Double(150, 100));

        }
    }

}
