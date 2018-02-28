import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

import processing.core.PApplet;
import processing.event.MouseEvent;

public class DrawingSurface extends PApplet
{

    private KochCurve curve1, curve2, curve3;

    private int level, length;

    public DrawingSurface()
    {
        level = 3;
        length = 100;
        curve1 = new KochCurve(level, length, 0, new Point2D.Double(150, 100));
        curve2 = new KochCurve(level, length, 120, new Point2D.Double(150 + length, 100));
        curve3 = new KochCurve(level, length, -120, new Point2D.Double(150 + (length * 0.5), 100 + (length * 0.866025403784)));
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
        curve2.draw(this);
        curve3.draw(this);
    }

    public void mouseWheel(MouseEvent event)
    {
        int num = event.getCount();
        length -= num * 10;
        
        if (length > 0)
        {
            curve1 = new KochCurve(level, length, 0, new Point2D.Double(150, 100));
            curve2 = new KochCurve(level, length, 120, new Point2D.Double(150 + length, 100));
            curve3 = new KochCurve(level, length, -120, new Point2D.Double(150 + (length * 0.5), 100 + (length * 0.866025403784)));
        }
        
    }

    public void keyPressed()
    {
        if (keyCode == KeyEvent.VK_UP)
        {
            level++;
            curve1 = new KochCurve(level, length, 0, new Point2D.Double(150, 100));
            curve2 = new KochCurve(level, length, 120, new Point2D.Double(150 + length, 100));
            curve3 = new KochCurve(level, length, -120, new Point2D.Double(150 + (length * 0.5), 100 + (length * 0.866025403784)));
        }
        else if (keyCode == KeyEvent.VK_DOWN )
        {
            level--;
            curve1 = new KochCurve(level, length, 0, new Point2D.Double(150, 100));
            curve2 = new KochCurve(level, length, 120, new Point2D.Double(150 + length, 100));
            curve3 = new KochCurve(level, length, -120, new Point2D.Double(150 + (length * 0.5), 100 + (length * 0.866025403784)));
        }
    }

}
