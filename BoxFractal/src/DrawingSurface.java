import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.util.Random;

import processing.core.PApplet;
import processing.event.MouseEvent;

public class DrawingSurface extends PApplet
{

    private Box fractal;
    private int level, length;
    private double x, y;

    public DrawingSurface()
    {
        level = 0;
        length = 300;
        x = 100;
        y = 100;
        fractal = new Box(level, length, new Point2D.Double(x, y));
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
        fractal.draw(this);
        


    }

    public void mouseWheel(MouseEvent event)
    {
        int num = event.getCount();
        length -= num * 10;
        
        if (length >= 0)
            fractal = new Box(level, length, new Point2D.Double(x, y));
           
        

    }

    public void keyPressed()
    {
        if (keyCode == KeyEvent.VK_UP && (level != 15))
        {
            level++;
            fractal = new Box(level, length, new Point2D.Double(x, y));

        }
        else if (keyCode == KeyEvent.VK_DOWN && (level != 1))
        {
            level--;
            fractal = new Box(level, length, new Point2D.Double(x, y));
        }
        
    }

}
