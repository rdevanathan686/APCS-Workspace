
public class RecursionPractice
{
    
    private static int iterations;

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

    // 1 index based
    public static int fibonacciRecursion(int n)
    {
        iterations++;
        
        if (n == 1)
            return 0;
        else if (n == 2)
            return 1;
        else
            return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
    }

    public static int fibonacciLoop(int n)
    {
        int prev = 0;
        int current = 1;

        for (int i = 2; i <= n; i++)
        {
            int temp = current;
            current += prev;
            prev = temp;
        }

        return prev;
    }
    
    public static void printHanoiSolution(int numberOfDisks)
    {
        printHanoiSolution(1, 3, numberOfDisks);
    }
    
    private static void printHanoiSolution(int pegFrom, int pegTo, int numDisks)
    {
        if (numDisks == 1 || (pegFrom > 0 || pegFrom < 4) || (pegTo > 0 || pegTo < 4))
            System.out.println("Move the top disk from peg " + pegFrom + " to peg " + pegTo);
        else
            printHanoiSolution(pegFrom, pegFrom + 1, numDisks - 1);
    }

    public static void main(String[] args)
    {
        int n = 10;

        int test = triangleNumber(n);
        System.out.println("The " + n + "th triangular number is " + test);

        int test2 = squareNumber(n);
        System.out.println("The " + n + "th square number is " + test2);

        int k = pow(n);
        int test3 = logBase2(k);
        System.out.println("2^" + test3 + " is " + k);


        int test5 = pentagonalNumber(4);
        System.out.println("The " + n + "th pentagonal number is " + test5);

        System.out.println(n + "th fibonacci number: " + fibonacciLoop(n));
        System.out.println(n + "th fibonacci number: " + fibonacciRecursion(n) + " and it took " + iterations + " iterations.");
        
        printHanoiSolution(5);

    }

}