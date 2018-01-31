
public class RecursionPractice
{

    public static int triangleNumber(int n)
    {
        if (n == 1)
            return 1;
        else
            return n + triangleNumber(n - 1);
    }

    public static int squareNumber(int n)
    {
        if (n == 1)
            return 1;
        else
            return squareNumber(n - 1) + (2 * n) - 1;
    }

    public static int logBase2(int n)
    {
        if (n == 1)
            return 0;
        else
            return 1 + logBase2(n / 2);
    }

    public static int pow(int n)
    {
        if (n == 0)
            return 1;
        else
            return 2 * pow(n - 1);
    }

    public static int pentagonalNumber(int n)
    {
        if (n == 1)
            return 1;
        else
            return (pentagonalNumber(n - 1) + (3 * n) - 2);
    }

    public static int fibonacciRecursion(int n)
    {
        if (n == 1)
            return 0;
        else if (n == 2)
            return 1;
        else
            return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
    }

    public static int fibonacciLoop(int n)
    {
        int prev = 1;
        int current = 1;

        for (int i = 2; i < n; i++)
        {
            int temp = current;
            current += prev;
            prev = temp;
        }

        return prev;
    }

    public static void main(String[] args)
    {
        int n = 5;

        int test = triangleNumber(n);
        System.out.println("The " + n + "th triangular number is " + test);

        int test2 = squareNumber(n);
        System.out.println("The " + n + "th square number is " + test2);

        int k = 32;
        int test3 = logBase2(k);
        System.out.println("2^" + test3 + " is " + k);

        int test4 = pow(n);
        System.out.println("2^" + n + " is " + test4);

        int test5 = pentagonalNumber(4);
        System.out.println("The " + n + "th pentagonal number is " + test5);

        System.out.println(n + "th fibonacci number: " + fibonacciLoop(n));
        System.out.println(n + "th fibonacci number: " + fibonacciRecursion(n));

    }

}