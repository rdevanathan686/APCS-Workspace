
import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class Main
{    
    /* Description
     * 
     * When the program is run, a house and two people will be displayed on the screen.
     * The house is controlled with the mouse and the people with the keyboard
     * 
     * Controls
     * 
     * For person on the left
     * W - Up
     * A - Left
     * S - Down
     * D - Right
     * J - Jump
     * C - Change Saber Side
     * Enter - change the color of the saber
     * 
     * For person on the right
     * Up Arrow Key - Up
     * Left Arrow Key - Left
     * Down Arrow Key - Down
     * Right Arrow Key - Right
     * Shift - Jump
     * Control/Command - Change Saber Side
     * Enter - change the color of the saber
     * 
     * House
     * Dragging - moves the mouse
     * Scrolling - zooms in/out
     * 
     */
    
    /*
     * creates the drawing surface with all the characters and displays it in a
     * window
     */
    public static void main(String args[])
    {
        DrawingSurface drawing = new DrawingSurface();
        PApplet.runSketch(new String[]
        { "" }, drawing);
        PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
        PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
        JFrame window = (JFrame) canvas.getFrame();

        window.setSize(500, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setVisible(true);
    }

}
