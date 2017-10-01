package rishikesh.illusiondrawings;

import java.awt.Dimension;
import javax.swing.JFrame;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class Main
{

    public static void main(String args[])
    {
        DrawingSurface drawing = new DrawingSurface();
        PApplet.runSketch(new String[]
        { "" }, drawing);
        PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
        PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
        JFrame window = (JFrame) canvas.getFrame();

        window.setMinimumSize(new Dimension(830, 840));
        window.setSize(830, 840);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);

        window.setVisible(true);
    }

}
