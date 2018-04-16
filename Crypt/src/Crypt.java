import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * This class encrypts and decrypts text files using one of 3 algorithms: Random
 * monoalphabet, Vigenere, or Playfair
 * 
 * 
 * @author Rishikesh Devanathan
 * @version 1.0
 * 
 */

public class Crypt
{
    public static final String fileSeparator = System.getProperty("file.separator");
    public static final String lineSeparator = System.getProperty("line.separator");

    /**
     * 
     * An integer representing the algorithm chosen. Set to: 1 for random
     * monoalphabet 2 for Vigenere 3 for Playfair
     * 
     */
    public static final int algorithm = 3;
    private int[][] pos;
    private char[][] arr;
    
    public void init(String keyword)
    {
        pos = new int[26][2];
        arr = new char[5][5];
        
        char[] alphabets = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
                'i', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                'u', 'v', 'w', 'x', 'y', 'z' };
        char[] keywordArr = keyword.toCharArray();

        for (int i = 0; i < keywordArr.length; i++)
        {

            char c = keyword.charAt(i);


            if (c == 'j')
                c = 'i';
        
            
            int index = Arrays.binarySearch(alphabets, c);


            if (index >= 0)
                alphabets[index] = '\u0000';
            else
            {
                keywordArr[index] = '\u0000';
                i--;
            }

        }
        
        int counter = 0;
        for (int i = 0; i < 25 + keywordArr.length; i++)
        {
            char c;
            
            if (i < keywordArr.length)
                c = keywordArr[i];
            else
                c = alphabets[i - keywordArr.length];
            
            if (c >= 'a')
            {
                pos[c - 'a'][0] = counter / 5;
                pos[c - 'a'][1] = counter % 5;
                
                arr[counter / 5][counter % 5] = c;
                
                counter++;
            }
            
        }
        
        pos[9][0] = pos[8][0];
        pos[9][1] = pos[8][1];
        
    }

    /**
     * Reads from the file specified, and writes out an encrypted version of the
     * file. If the output file already exists, overwrite it.
     * 
     * @param inputFilename
     *            The path of the file to be encrypted.
     * @param outputFilename
     *            The path of the encrypted file to be saved.
     * @param keyword
     *            The keyword to be used in the encryption algorithm.
     * 
     */
    public void encrypt(String inputFilename, String outputFilename, String keyword)
    {
        Scanner scan = null;
        FileWriter write = null;
        BufferedWriter bw = null;

        try
        {
            FileReader reader = new FileReader(inputFilename);
            BufferedReader br = new BufferedReader(reader);
            scan = new Scanner(br);

            write = new FileWriter(outputFilename);
            bw = new BufferedWriter(write);

            if (pos == null)
                init(keyword);

            int pair = 0;
            char offsetI = 'a', offsetJ = 'a';

            StringBuffer output = new StringBuffer();
            
            StringBuffer punctuationI = new StringBuffer();
            StringBuffer punctuationJ = new StringBuffer();
            
            char a = '\u0000';
            char b = '\u0000';

            while (scan.hasNextLine())
            {

                String data = scan.nextLine();

                for (int i = 0; i < data.length(); i++)
                {
                    char c = data.charAt(i);
                    
                    if (pair < 2 && Character.isLetter(c))
                    {
                        if (pair == 0)
                        {
                            a = c;

                            if (Character.isUpperCase(c))
                                offsetI = 'A';
                        }
                        else if (pair == 1)
                        {
                            b = c;
                            
                            if (Character.isUpperCase(c))
                                offsetJ = 'A';
                        }

                        pair++;

                    }
                    else if (!Character.isLetter(c))
                    {
                        if (pair == 0)
                            punctuationI.append(c);
                        else if (pair == 1)
                            punctuationJ.append(c);

                    }
                    if (pair == 2)
                    {

                        char newA = arr[(pos[a - offsetI][0])][(pos[b - offsetJ][1])];
                        char newB = arr[(pos[b - offsetJ][0])][(pos[a - offsetI][1])];

                        if (pos[a - offsetI][1] == pos[b - offsetJ][1])
                        {
                            newA = b;
                            newB = a;
                        }

                        output.append(punctuationI.toString() + (char) (Character.toLowerCase(newA) - ('a' - offsetI)));
                        output.append(punctuationJ.toString() + (char) (Character.toLowerCase(newB) - ('a' - offsetJ)));

                        pair = 0;
                        offsetI = 'a';
                        offsetJ = 'a';
                        punctuationI = new StringBuffer();
                        punctuationJ = new StringBuffer();

                    }

                }

                if (pair == 0)
                    punctuationI.append(lineSeparator);
                else if (pair == 1)
                    punctuationJ.append(lineSeparator);


            }
            
            if (pair == 1)
            {
                b = 'j';
                
                char newA = arr[(pos[a - offsetI][0])][(pos[b - offsetJ][1])];
                char newB = arr[(pos[b - offsetJ][0])][(pos[a - offsetI][1])];

                if (pos[a - offsetI][1] == pos[b - offsetJ][1])
                {
                    newA = b;
                    newB = a;
                }
                
                output.append((char) (Character.toLowerCase(newA) - ('a' - offsetI)));
                output.append((char) (Character.toLowerCase(newB) - ('a' - offsetJ)));
            }
                

            bw.write(output.toString());

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (scan != null)
                scan.close();
            try
            {
                if (bw != null)
                    bw.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }

    }

    /**
     * Reads from the (previously encrypted) file specified, and writes out a
     * decrypted version of the file. If the output file already exists, overwrite
     * it.
     * 
     * @param inputFilename
     *            The path of the encrypted file.
     * @param outputFilename
     *            The path of the decrypted file to be saved.
     * @param keyword
     *            The keyword to be used in the decryption algorithm.
     * 
     */
    public void decrypt(String inputFilename, String outputFilename, String keyword)
    {
        encrypt(inputFilename, outputFilename, keyword);
    }

}
