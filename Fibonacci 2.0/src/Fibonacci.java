
/**
 * @(#)Fibonacci.java
 *
 *
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Fibonacci
{

    // 20th Fibonacci number is 6765
    public static long computeFibonacci(int x)
    {

        if (x < 0)
            throw new IllegalArgumentException("Negative Numbers are not allowed!");

        if (x <= 1)
            return x;

        else
        {
            long answer = computeFibonacci(x - 2) + computeFibonacci(x - 1);
            return answer;
        }

    }

    public static void main(String[] args)
    {
        Scanner kboard = new Scanner(System.in);
        
        int x = 0;
        boolean valid = false;
        
        while (!valid)
        {
            try
            {
                System.out.print("Which fibonacci number would you like to find? --> ");
                x = kboard.nextInt();
                valid = true;
            }
            catch (InputMismatchException exception)
            {
                System.out.println("Please only input positive integers.");
                kboard.nextLine();
            }

        }
        

        long answer = 0;
        
        try
        {
            answer = computeFibonacci(x);
        }
        catch (StackOverflowError error)
        {
            System.out.println("The inputted number was too big! Please try agian.");
            return;
        }
        
        
        System.out.println("The " + x + " fibonacci number is " + answer + ".");
        kboard.close();
    }

}