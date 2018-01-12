import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import processing.core.PApplet;

/*

	Represents a Game Of Life grid.

	Coded by: Rishikesh Devanathan
	Modified on: 1/12/2018

*/

public class Life
{
    private boolean[][] grid;
    
    
    // Constructs an empty grid
    public Life()
    {
        grid = new boolean[10][20];
    }

    // Constructs the grid defined in the file specified
    public Life(String filename)
    {
        this();
        readData(filename, grid);
    }

    // Runs a single turn of the Game Of Life
    public void step()
    {
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[i].length; j++)
            {
                int numNeighbours = countNeighbours(i, j);
                
                if (numNeighbours <= 1)
                    grid[i][j] = false;
                else if (numNeighbours >= 4)
                    grid[i][j] = false;
                else if (numNeighbours == 3)
                    grid[i][j] = true;
            }
        }
    }

    private int countNeighbours(int i, int j)
    {
        // Math.min(0, x -1) stuff
        int result = 0;
        
        for (int x = 0; x < grid.length; x++)
        {
            for (int y = 0; y < grid[0].length; y++)
            {

                int xMin = x - 1;
                
                int xMax = x + 1;
                int yMin = y - 1;
                int yMax = y + 1;

                if (x == 0)
                    xMin = 0;

                if (y == 0)
                    yMin = 0;

                if (x == grid.length - 1)
                    xMax = grid.length - 1;

                if (y == grid[0].length - 1)
                    yMax = grid[0].length - 1;

//                if (tiles[x][y] instanceof Empty)
//                {
//                    int count = 0;
//
//                    for (int i = xMin; i <= xMax; i++)
//                    {
//                        for (int j = yMin; j <= yMax; j++)
//                        {
//                            if (tiles[i][j] instanceof Bomb)
//                                count++;
//                        }
//                    }
//
//                    ((Empty) tiles[x][y]).setup(this, count);
//
//                }

            }
        }
    }

    // Runs n turns of the Game Of Life
    public void step(int n)
    {
        for (int i = 0; i < n; i++) 
            step();
    }

    // Formats this Life grid as a String to be printed (one call to this method
    // returns the whole multi-line grid)
    public String toString()
    {
        String result = "";
        for (int i = 0; i < grid[0].length; i++)
        {
            for (int j = 0; j < grid.length; j++)
            {
                if (grid[j][i])
                    result += "* ";
                else
                    result += "- ";
            }
            
            result += '\n';
        }
        
        return result;
    }

    // Reads in array data from a simple text file containing asterisks (*)
    public void readData(String filename, boolean[][] gameData)
    {
        File dataFile = new File(filename);

        if (dataFile.exists())
        {
            int count = 0;

            FileReader reader = null;
            Scanner in = null;
            try
            {
                reader = new FileReader(dataFile);
                in = new Scanner(reader);

                while (in.hasNext())
                {
                    String line = in.nextLine();
                    for (int i = 0; i < line.length(); i++)
                        if (i < gameData.length && count < gameData[i].length && line.charAt(i) == '*')
                            gameData[i][count] = true;

                    count++;
                }
            } catch (IOException ex)
            {
                throw new IllegalArgumentException("Data file " + filename + " cannot be read.");
            } finally
            {
                if (in != null)
                    in.close();
            }

        } else
        {
            throw new IllegalArgumentException("Data file " + filename + " does not exist.");
        }
    }

    /**
     * Optionally, complete this method to draw the grid on a PApplet.
     * 
     * @param marker
     *            The PApplet used for drawing.
     * @param x
     *            The x pixel coordinate of the upper left corner of the grid
     *            drawing.
     * @param y
     *            The y pixel coordinate of the upper left corner of the grid
     *            drawing.
     * @param width
     *            The pixel width of the grid drawing.
     * @param height
     *            The pixel height of the grid drawing.
     */
    public void draw(PApplet marker, float x, float y, float width, float height)
    {
    }

    /**
     * Optionally, complete this method to determine which element of the grid
     * matches with a particular pixel coordinate.
     * 
     * @param p
     *            A Point object representing a graphical pixel coordinate.
     * @param x
     *            The x pixel coordinate of the upper left corner of the grid
     *            drawing.
     * @param y
     *            The y pixel coordinate of the upper left corner of the grid
     *            drawing.
     * @param width
     *            The pixel width of the grid drawing.
     * @param height
     *            The pixel height of the grid drawing.
     * @return A Point object representing a coordinate within the game of life
     *         grid.
     */
    public Point clickToIndex(Point p, float x, float y, float width, float height)
    {
        return null;
    }

    /**
     * Optionally, complete this method to toggle a cell in the game of life grid
     * between alive and dead.
     * 
     * @param i
     *            The x coordinate of the cell in the grid.
     * @param j
     *            The y coordinate of the cell in the grid.
     */
    public void toggleCell(int i, int j)
    {
    }

}