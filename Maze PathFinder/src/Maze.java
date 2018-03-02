import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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

    // Constructs an empty grid
    public Maze()
    {
        grid = new char[20][20];
    }

    // Constructs the grid defined in the file specified
    public Maze(String filename)
    {
        this();
        readData(filename, grid);
    }

     //Attempts to find a path through the maze and returns whether a path was found
    // or not
     public boolean solve() 
     {
         
     }
    
     // Private recursive version of solve()
     private boolean solve(....) {
     }

    // Formats this grid as a String to be printed (one call to this method returns
    // the whole multi-line grid)
    public String toString()
    {
        String result = "";
        for (int i = 0; i < grid[0].length; i++)
        {
            for (int j = 0; j < grid.length; j++)
            {
                result += grid[j][i];
            }

            result += '\n';
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
                            gameData[i][count] = line.charAt(i);

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

}