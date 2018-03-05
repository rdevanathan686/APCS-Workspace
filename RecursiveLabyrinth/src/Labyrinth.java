import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*

	Coded by:
	Modified on:

*/

public class Labyrinth
{

    private static final int rows = 20;
    private static final int cols = 20;
    private char[][] data;

    // Constructs an empty grid
    public Labyrinth()
    {
        data = new char[cols][rows];
    }

    // Constructs the grid defined in the file specified
    public Labyrinth(String filename)
    {
        data = readData(filename);
    }

    // Finds a path through the maze and modifies data to show the path
    public int findPath()
    {
        for (int i = 0; i < data.length; i++)
            for (int j = 0; j < data[i].length; j++)
                if (data[i][j] == 'C')
                    return findPath(i, j, false);

        return -1;
    }

    // Private recursive version of findPath()
    private int findPath(int x, int y, boolean hasCloak)
    {
        if (x < 0 || y < 0 || x >= data.length || y >= data[x].length)
            return -1;
        if (data[x][y] == 'X')
            return 0;
        if (data[x][y] == '#' || data[x][y] == '\u0000')
            return -1;
        if (data[x][y] == '!')
            return -1;
        else
        {
            data[x][y] = '!';

            if (data[x][y] == '@')
                hasCloak = true;

            if (findPath(x - 1, y, hasCloak) != -1 || findPath(x, y - 1, hasCloak) != -1
                    || findPath(x + 1, y, hasCloak) != -1 || findPath(x, y + 1, hasCloak) != -1)
                return 0;
            else
            {
                if (startX == x && startY == y)
                    data[x][y] = 'C';
                else
                    data[x][y] = '.';

                return false;
            }

        }
    }

    // Formats this grid as a String to be printed (one call to this method returns
    // the whole multi-line grid)
    public String toString()
    {
        String output = "";

        for (int i = 0; i < data.length; i++)
        {
            for (int j = 0; j < data[i].length; j++)
            {
                output += data[i][j];
            }
            output += "\n";
        }

        return output;
    }

    public char[][] readData(String filename)
    {
        File dataFile = new File(filename);

        if (dataFile.exists())
        {
            char[][] gameData = new char[rows][cols];

            int count = 0;

            FileReader reader = null;
            try
            {
                reader = new FileReader(dataFile);
                Scanner in = new Scanner(reader);

                while (in.hasNext() && count < rows)
                {
                    String line = in.nextLine();
                    for (int i = 0; i < line.length(); i++)
                        gameData[count][i] = line.charAt(i);

                    count++;
                }

            } catch (IOException ex)
            {
                System.out.println("File cannot be read.");
                return null;
            } catch (NumberFormatException ex)
            {
                System.out.println("File is in the wrong format.");
                return null;
            } finally
            {
                try
                {
                    reader.close();
                } catch (IOException ex)
                {
                    System.out.println("File cannot be closed.");
                    return null;
                }
            }
            return gameData;
        } else
        {
            throw new IllegalArgumentException("Data file " + filename + " does not exist.");
        }
    }

}