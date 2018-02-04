
public class Hanoi
{
    /*
     * numDisks:    1      2       3       4       5       6       7       8       9       10
     * iteration:   1      3       7       15      31      63      127     255     511     1023
     * 
     * Equation: (2 ^ numDisks) - 1 
     * 
     */
    private static int iteration = 0;

    public static void printHanoiSolution(int numberOfDisks)
    {
        printHanoiSolution(1, 3, numberOfDisks);
    }
    
    private static void printHanoiSolution(int pegFrom, int pegTo, int numDisks)
    {
        iteration++;
        
        if (numDisks == 1)
            System.out.println("Move the top disk from peg " + pegFrom + " to peg " + pegTo);
        else
        {
            int otherPeg = 6 - (pegFrom + pegTo);
            printHanoiSolution(pegFrom, otherPeg, numDisks - 1);
            System.out.println("Move the top disk from peg " + pegFrom + " to peg " + pegTo);
            printHanoiSolution(otherPeg, pegTo, numDisks - 1);
        }
    }

    public static void main(String[] args)
    {
        printHanoiSolution(10);
        System.out.println(iteration);
    }

}