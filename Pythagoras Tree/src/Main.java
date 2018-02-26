import java.awt.Dimension;
import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class Main
{
    public static final float SCREEN_WIDTH = 500;
    public static final float SCREEN_HEIGHT = 500;
    
    public static void main(String args[])
    {
        DrawingSurface drawing = new DrawingSurface();
        PApplet.runSketch(new String[] { "" }, drawing);
        PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
        PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
        JFrame window = (JFrame) canvas.getFrame();

        window.setSize((int)SCREEN_WIDTH, (int)SCREEN_HEIGHT);
        window.setMinimumSize(new Dimension((int)SCREEN_WIDTH, (int)SCREEN_HEIGHT));
        window.setLocation(0, 0);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);

        window.setVisible(true);

    }
}
