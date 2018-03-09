
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
            throw new IllegalArgumentException("Negative Numbers are not allowed");
        
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
        System.out.print("Which fibonacci number would you like to find? --> ");
        
        int x = 0;

        try 
        {
            x = kboard.nextInt();
        }
        catch (InputMismatchException exception)
        {
            System.out.println("Only input integers ");
        }
        
        
        long answer = computeFibonacci(x);
        System.out.println("The " + x + " fibonacci number is " + answer + ".");
    }

}