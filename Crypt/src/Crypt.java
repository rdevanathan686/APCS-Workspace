import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

/**
 * 
 * This class encrypts and decrypts text files using one of 3 algorithms: Random
 * monoalphabet, Vigenere, or Playfair
 * 
 * 
 * @author
 * @version
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
        // needed to close in finally block
        int[][] pos = new int[26][2];
        Set<Character> dupKey = new LinkedHashSet<Character>();

        for (int i = 0; i < keyword.length(); i++)
        {
            dupKey.add(keyword.charAt(i));
        }

        char[] keyBuff = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
                't', 'u', 'v', 'w', 'x', 'y', 'z' };

        StringBuffer keywordBuff = new StringBuffer(keyword);
        int deltaLen = 0;

        for (int i = 0; i < keyword.length(); i++)
        {

            char c = keyword.charAt(i);

            int k;

            if (c != 'j')
                k = c - 'a';
            else
                k = 8;

            if (keyBuff.charAt(k + deltaLen) == c)
            {
                keyBuff.replace(k + deltaLen, k + 1 + deltaLen, "");

            }
            else
            {
                keywordBuff.replace(i, i + 1, "");
                i--;
            }

        }

        String keyR = keyword + keyBuff.toString();

        System.out.println(keyR);

        Character[] key = dupKey.toArray(new Character[dupKey.size()]);
        char[][] arr = new char[5][5];

        int x = 0;
        char fill = 'a';

        for (int i = 0; x < 25; i++)
        {
            if (i < dupKey.size())
            {
                arr[x / 5][x % 5] = key[i];
                pos[key[i] - 'a'][0] = x / 5;
                pos[key[i] - 'a'][1] = x % 5;

                if (dupKey.contains(fill))
                    fill++;

                x++;
            }
            else
            {
                if (!dupKey.contains(fill))
                {
                    if (fill == 'i' || fill == 'j')
                    {
                        if (!dupKey.contains('j') && !dupKey.contains('i'))
                        {
                            arr[x / 5][x % 5] = fill;
                            pos[fill - 'a'][0] = x / 5;
                            pos[fill - 'a'][1] = x % 5;
                            x++;
                            fill += 2;
                        }
                        else
                        {
                            fill++;
                        }

                        continue;
                    }
                    else
                    {
                        arr[x / 5][x % 5] = fill;
                        pos[fill - 'a'][0] = x / 5;
                        pos[fill - 'a'][1] = x % 5;
                        x++;
                    }

                }

                fill++;

            }

        }

        pos[9][0] = pos[8][0];
        pos[9][1] = pos[8][1];

        //
        //
        // for (int i = 0; i < pos.length; i++)
        // {
        // System.out.println(Arrays.toString(pos[i]));
        // }

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

            int pair = 0;
            int pairIndexI = 0, pairIndexJ = 1;
            char offsetI = 'a', offsetJ = 'a';

            int outputLength = 0;

            StringBuffer output = new StringBuffer();
            StringBuffer original = new StringBuffer();
            StringBuffer punctuationI = new StringBuffer();
            StringBuffer punctuationJ = new StringBuffer();

            while (scan.hasNextLine())
            {

                String data = scan.nextLine();

                original.append(data);

                for (int i = 0; i < data.length(); i++)
                {
                    char c = data.charAt(i);
                    if (pair < 2 && Character.isLetter(data.charAt(i)))
                    {
                        if (pair == 0)
                        {
                            pairIndexI = outputLength + i;

                            if (Character.isUpperCase(data.charAt(i)))
                                offsetI = 'A';
                        }
                        else if (pair == 1)
                        {
                            pairIndexJ = outputLength + i;

                            if (Character.isUpperCase(data.charAt(i)))
                                offsetJ = 'A';
                        }

                        pair++;

                    }
                    else if (!Character.isLetter(data.charAt(i)))
                    {
                        if (pair == 0)
                            punctuationI.append(data.charAt(i));
                        else if (pair == 1)
                            punctuationJ.append(data.charAt(i));

                    }
                    if (pair == 2)
                    {
                        char a = original.charAt(pairIndexI);
                        char b = original.charAt(pairIndexJ);
                        char newA = arr[pos[a - offsetI][0]][pos[b - offsetJ][1]];
                        char newB = arr[pos[b - offsetJ][0]][pos[a - offsetI][1]];

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

                outputLength += data.length();

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
