
public class RecursionPractice
{
<<<<<<< HEAD
    private static int iteration = 0;
=======
    
    private static int iterations;
>>>>>>> b4856f5a46307e64a317d1bdf1ccaf43d67a8349

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

    public static int identity(int num)
    {
        iteration++;
        if (num < 1)
            return 10;
        else
            return num + identity(num - 2);

    }

    public static void doSomething(int n)
    {
        iteration++;

        if (n > 0)
        {
            doSomething(n - 2);
            System.out.print("-");
            doSomething(n - 1);
            System.out.print("!");
        }
        else
        {
            System.out.print(".");
        }
    }

    public static int jump(int n)
    {
        iteration++;
        if (n < 5)
            return n + 3;
        else
            return jump(jump(n - 5));

    }

    public static int mystery(int n, int k)
    {
        iteration++;
        if (k == 0 || n == k)
            return 1;
        else
            return (mystery(n - 1, k) + mystery(n - 1, k - 1));

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

        doSomething(3);
        System.out.println(": " + iteration);
        iteration = 0;
        System.out.println(jump(10) + ": " + iteration);
        iteration = 0;
        System.out.println(mystery(3, 2) + ": " + iteration);
        
        iteration = 0;
        System.out.println(identity(10) + ": " + iteration);
               
    }

}