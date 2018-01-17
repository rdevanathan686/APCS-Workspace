import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import processing.core.PApplet;

public class Board
{
    private boolean[][] grid;
    
    // Shapes of tetrominos
    private boolean[][] I_SHAPE = { { true, true, true, true } };
    private boolean[][] J_SHAPE = { { true, true, true, true }, { false, false, false, true } };
    private boolean[][] L_SHAPE = { { true, true, true, true }, { true, false, false, false } };
    private boolean[][] O_SHAPE = { { true, true }, { true, true } };
    private boolean[][] S_SHAPE = { { false, true, true }, { true, true, false } };
    private boolean[][] T_SHAPE = { { true, true, true }, { false, true, false } };
    private boolean[][] Z_SHAPE = { { true, true, false }, { false, true, true } };

    // Constructs an empty grid
    public Board()
    {
        grid = new boolean[20][20];
    }

    public void create()
    {
        
//        for (int i = 0; i < grid.length; i++)
//        {
//            for (int j = 0; )
//        }
    
    }
    
    public void fall()
    {
        
    }

    public int countNeighbours(int i, int j)
    {

        int count = 0;

        for (int k = (i == 0 ? 0 : i - 1); k <= (i == grid.length - 1 ? grid.length - 1 : i + 1); k++)
            for (int m = (j == 0 ? 0 : j - 1); m <= (j == grid.length - 1 ? grid.length - 1 : j + 1); m++)
                if (grid[k][m] && (k != i || m != j))
                    count++;

        return count;

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

    public int aliveInCol(int col)
    {
        int result = 0;

        for (int i = 0; i < grid[col - 1].length; i++)
            if (grid[col - 1][i])
                result++;

        return result;
    }

    public int aliveInRow(int row)
    {
        int result = 0;

        for (int i = 0; i < grid.length; i++)
            if (grid[i][row - 1])
                result++;

        return result;
    }

    public int totalAlive()
    {
        int result = 0;

        for (int i = 1; i <= grid[0].length; i++)
            result += aliveInCol(i);

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
        marker.pushStyle();

        for (int i = 0; i < grid[0].length; i++)
        {
            for (int j = 0; j < grid.length; j++)
            {
                if (grid[j][i])
                    marker.fill(0, 0, 255);
                else
                    marker.fill(255);

                marker.rect((i * (width / grid.length)) + x, j * (height / grid[0].length) + y,
                        (width / grid.length) + x, (height / grid[0].length) + y);
            }

        }

        marker.popStyle();
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

        float cellWidth = (width / grid.length);
        float cellHeight = (height / grid[0].length);

        int j = (int) ((p.x - x) / cellWidth);
        int i = (int) ((p.y - y) / cellHeight);

        if (j < 0 || j >= grid.length)
            return null;

        if (i < 0 || i >= grid[0].length)
            return null;

        Point answer = new Point(j, i);

        return answer;

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
        grid[j][i] = !grid[j][i];
    }

}