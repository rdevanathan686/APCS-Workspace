import java.util.ArrayList;
import java.util.Scanner;

public class RecursiveStringTools
{
    public static ArrayList<Character> vowels = new ArrayList<Character>();

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
        printPermutations(in, "");
    }

    private static void printPermutations(String in, String prefix)
    {
        if (in.length() == 1)
            System.out.println(prefix + in);
        else
            forLoop(0, in.length(), in, prefix);

    }

    public static void forLoop(int i, int n, String in, String prefix)
    {
        if (i >= n)
            return;
        else
        {
            String prefixNext = prefix + in.charAt(i);
            String next = in.substring(0, i) + in.substring(i + 1);

            printPermutations(next, prefixNext);
            forLoop(i + 1, n, in, prefix);

        }
    }

    public static String piglatinate(String in)
    {
        String[] words = in.split("[[ ]*|[,]*|[\\.]*|[:]*|[/]*|[!]*|[?]*|[+]*]+");

        return forLoop2(0, words, "");

    }

    public static String forLoop2(int i, String[] words, String result)
    {

        if (i >= words.length)
            return result;
        else
        {
            System.out.println(words[i]);
            result += piglatinate(words[i], words[i], 0);

            if (i >= 0)
                result += " ";

            return forLoop2(i + 1, words, result);

        }

    }

    private static String piglatinate(String in, String result, int i)
    {

        if (i > in.length())
            return result + "ay";

        else if (vowels.contains(in.charAt(0)))
        {
            if (i == 0)
                return result + "yay";
            else
            {

                if (Character.isUpperCase(result.charAt(0)))
                    return Character.toUpperCase(result.charAt(i)) + result.substring(i + 1)
                            + Character.toLowerCase(result.charAt(0)) + result.substring(1, i) + "ay";
                else
                    return result.substring(i) + result.substring(0, i) + "ay";

            }

        }

        else
            return piglatinate(in.substring(1), result, i + 1);
    }

    public static void main(String[] args)
    {
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        Scanner kboard = new Scanner(System.in);
        System.out.println("Please enter a string:");
        String s = kboard.nextLine();

        String out = RecursiveStringTools.piglatinate(s);
        System.out.print("\n\nThe result is --> " + out + "\n\n");

        kboard.close();

    }
}
