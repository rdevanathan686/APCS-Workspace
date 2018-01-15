
public class Tester
{

    public static void main(String[] args)
    {
        Life tester = new Life("life100.txt");

        System.out.println("Before:\n" + tester);

        tester.step(5);
        
        System.out.println("After 5 Generations:\n" + tester);
        
        System.out.println("Number in Row 10 ---> " + tester.aliveInRow(10));
        System.out.println("Number in Column 10 ---> " + tester.aliveInCol(10));
        System.out.println("Number of living organisms ---> " + tester.totalAlive());
        

        
    }

}
