import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
        boolean[] seen = new boolean[26];
        char[] arr = keyword.toCharArray();
        for (int i = 0; i < arr.length; i++)
        {
            char c = arr[i];
            
            if (seen[c - 'a'])
                arr[i] = null;
            else
                seen[c - 'a'] = true;
        }
        Scanner scan = null;
        FileWriter write = null;
        BufferedWriter bw = null;
        
        try
        {
            FileReader reader = new FileReader(inputFilename);
            BufferedReader br  = new BufferedReader(reader);
            scan = new Scanner(br);
            
            write = new FileWriter(outputFilename);
            bw = new BufferedWriter(write);



            while (scan.hasNextLine())
            {
                String data = scan.nextLine();
                
                // Encrypt the data
                
                
                bw.write(data);
                bw.write(lineSeparator);
            }

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

    }

}
