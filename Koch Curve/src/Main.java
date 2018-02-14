import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class Main
{

    public static void main(String args[])
    {
        DrawingSurface drawing = new DrawingSurface();
        PApplet.runSketch(new String[] { "" }, drawing);
        PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
        PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
        JFrame window = (JFrame) canvas.getFrame();

        window.setSize(400, 300);
        window.setMinimumSize(new Dimension(100, 100));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);

        window.setVisible(true);

    }
    
    private void drawKochCurve(PApplet marker, int k, Point start, Point end)
    {
        if (k < 1)
        {
            marker.line(start.x, start.y, end.x, end.y);
        }
        else
        {
            Point distance = new Point((end.x - start.x) / 3, (end.y - start.y) / 3);
            Point pA = new Point(start.x + distance.x, start.y + distance.y);
            Point pB = new Point(end.x - distance.x, end.y - distance.y);
            double sin60 = 0.866025403784438646763723170752936183471402626905190;
            Point pTip = new Point(pA.x + (int) (distance.x * 0.5 + distance.y * sin60),
                    pA.y + (int) (distance.y * 0.5 - distance.x * sin60));

            drawKochCurve(marker, k - 1, start, pA); // if level 1 or higher,
            drawKochCurve(marker, k - 1, pA, pTip); // recursively call self 4 times
            drawKochCurve(marker, k - 1, pTip, pB);
            drawKochCurve(marker, k - 1, pB, end);
        }
    }

}
