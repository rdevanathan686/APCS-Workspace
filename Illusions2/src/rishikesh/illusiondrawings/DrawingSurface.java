package rishikesh.illusiondrawings;

import processing.core.PApplet;
import rishikesh.shapes.Circle;
import rishikesh.shapes.Rectangle;

public class DrawingSurface extends PApplet
{

    Rectangle[][] rectArr = new Rectangle[10][12];
    int[][] test = new int[9][11];
    
    public DrawingSurface()
    {
//        for (int i = 0; i <= 9; i++)
//        {
//            for (int j = 0; j <= 11; j++)
//            {
//                Rectangle rect = new Rectangle(j * 85, i * 85, 80, 80);
//                
//                
//                
//                
//                rectArr[i][j] = rect;
//            }
//        }
            
                
        
        
       
            
        
        
    }
    
//    private Rectangle[] drawRow(int startX, int startY, int numSq, int size)
//    {
//        Rectangle[] result = new Rectangle[numSq];
//        
//        for (int column = 0; column < numSq; column++)
//        {
//            Rectangle rect = new Rectangle(startX, startY, size, size);
//            
//            rect.setStrokeColor(100);
//            if (column % 2 == 0)
//            {
//                rect.setFillColor(color(0, 200, 0));
//                rect.setStrokeColor(0);
//            }
//            
//            rect.setStrokeWeight(3);
//          
//            result[column] = rect;
//            
//            startX += size + 3;
//
//        }
//        
//        return result;
//    }
    
    public static void drawRow( int x, int y, int pairs, int size, PApplet drawer) {
        // loop for each pair.
        for (int i = 0; i < pairs; i++) {
            Rectangle rectA = new Rectangle(x + size/2, y + size/2, size / 2, size/2);
            rectA.setFillColor(drawer.color(0, 200, 0));

            Rectangle rectB = new Rectangle(x+size+size/2, y + size/2, size / 2, size/2);
            rectB.setFillColor(drawer.color(255, 255, 255));

            rectA.draw(drawer);
            rectB.draw(drawer);
            x += size * 2;
        }
    }
    
    public static void drawGrid( int x, int y, int rows, int pairs, int size, 
            int offset, PApplet drawer)
    {
        int startingX = x;
        for(int line = 0; line < rows; line++) {
            x = startingX + (line % 2) * offset;
            drawRow(x, y, pairs, size, drawer);

            y = y + size + 2;
        }
    }

    
    // The statements in the setup() function
    // execute once when the program begins
    public void setup()
    {

        background(120);


    }

    // The statements in draw() are executed until the
    // program is stopped. Each statement is executed in
    // sequence and after the last line is read, the first
    // line is executed again.
    public void draw()
    {
//        for (int i = 0; i <= 9; i++)
//        {
//            for (int j = 0; j <= 11; j++)
//            {
//                Rectangle rect = rectArr[i][j];
//                
//                rect.draw(this);
//            }
//               
//        }
        
//        for (int row = 0; row < 9; row++)
//        {
//            for (int colomn = 0; colomn < 11; colomn++)
//            {
//                Rectangle rect = new Rectangle(row * 90, colomn * 93, 90, 90);
//                
//                rect.draw(this);
//                
//            }
//            Rectangle[] rectRow = drawRow((row % 2) * 10, row * 88, 12, 90);
//            
//            for (Rectangle rect: rectRow)
//                rect.draw(this);
//        }
        
        drawGrid(0, 0, 11, 5, 90, 10, this);

        

    }

}
