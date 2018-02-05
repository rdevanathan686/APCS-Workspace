import java.util.Scanner;

public class RecursiveStringTools
{

    // Example
    public static int length(String in)
    {
        if (in.equals(""))
            return 0;
        else
            return length(in.substring(1)) + 1;
    }

    // Example
    public static boolean equals(String in1, String in2)
    {
        if (in1.length() != in2.length())
            return false;
        else if (in1.length() == 0 && in2.length() == 0)
            return true;
        else
        {
            boolean eq = in1.charAt(0) == in2.charAt(0);
            String str1 = in1.substring(1);
            String str2 = in2.substring(1);
            return eq && equals(str1, str2);
        }
    }

    // Exercise #1
    public static boolean matches(String in1, String in2)
    {
        if (in1.length() != in2.length())
            return false;
        else if (in1.length() == 0 && in2.length() == 0)
            return true;
        else
        {
            boolean eq = (in1.charAt(0) == in2.charAt(0));
            boolean qMatch = (in1.charAt(0) == '?' || in2.charAt(0) == '?');
            String str1 = in1.substring(1);
            String str2 = in2.substring(1);
            return (eq || qMatch) && matches(str1, str2);
        }
    }

    // Exercise #2
    public static boolean isPalindrome(String in)
    {
        if (in.length() == 0 || in.length() == 1)
            return true;
        else
        {
            boolean eq; 
            
            if (!Character.isDigit(in.charAt(0)))
                eq = (Character.toUpperCase(in.charAt(0)) == Character.toUpperCase(in.charAt(in.length() - 1)));
            else
                eq = (in.charAt(0) == in.charAt(in.length() - 1));
            
            return eq && isPalindrome(in.substring(1, in.length() - 1));
        }
    }

    // Exercise #3
    public static void printPermutations(String in)
    {
        
    }

    public static String piglatinate(String in)
    {
        return "";
    }

    public static void main(String[] args)
    {
        Scanner kboard = new Scanner(System.in);
        System.out.println("Please enter a string:");
        String s = kboard.nextLine();

        String out = RecursiveStringTools.isPalindrome(s) + "";
        System.out.print("\n\nThe result is --> " + out + "\n\n");

    }
}
