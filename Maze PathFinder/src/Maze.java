import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*

	Represents a 2D maze.

	Coded by: Rishikesh Devanathan
	Modified on: 3/2/2018

*/

public class Maze
{

    private static final int rows = 20;
    private static final int cols = 20;

    private char[][] grid;
    private int startX, startY;

    // Constructs an empty grid
    public Maze()
    {
        grid = new char[rows][cols];
    }

    // Constructs the grid defined in the file specified
    public Maze(String filename)
    {
        this();
        readData(filename, grid);
    }

    // Attempts to find a path through the maze and returns whether a path was found
    // or not
    public boolean solve()
    {
        return solve(startX, startY);
    }

    // Private recursive version of solve()
    private boolean solve(int x, int y)
    {

        if (x < 0 || y < 0 || x >= grid.length || y >= grid[x].length)
            return false;
        if (grid[x][y] == 'X')
            return true;
        if (grid[x][y] == '#' || grid[x][y] == '\u0000')
            return false;
        if (grid[x][y] == '!')
            return false;
        else
        {
            grid[x][y] = '!';

            if (solve(x - 1, y) || solve(x, y - 1) || solve(x + 1, y) || solve(x, y + 1))
                return true;
            else
            {
                if (startX == x && startY == y)
                    grid[x][y] = 'C';
                else
                    grid[x][y] = '.';

                return false;
            }

        }

    }

    // Formats this grid as a String to be printed (one call to this method returns
    // the whole multi-line grid)
    public String toString()
    {
        String result = "";
        for (int i = 0; i < grid.length; i++)
        {
            String row = "";
            for (int j = 0; j < grid[i].length; j++)
            {
                if (grid[i][j] != '\u0000')
                    row += grid[i][j];
            }

            if (row.length() >= 1)
                result += row + '\n';
        }

        return result;
    }

    public void readData(String filename, char[][] gameData)
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
                        if (i < gameData.length && count < gameData[i].length)
                        {
                            if (line.charAt(i) == 'C')
                            {
                                startX = count;
                                startY = i;
                            }
                            gameData[count][i] = line.charAt(i);
                        }

                    count++;
                }
            }
            catch (IOException ex)
            {
                throw new IllegalArgumentException("Data file " + filename + " cannot be read.");
            }
            finally
            {
                if (in != null)
                    in.close();
            }

        }
        else
        {
            throw new IllegalArgumentException("Data file " + filename + " does not exist.");
        }
    }

}