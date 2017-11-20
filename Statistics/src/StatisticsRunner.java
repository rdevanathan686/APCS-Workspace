
public class StatisticsRunner
{
    public static void main (String[] args)
    {
        Statistics numberTester = new Statistics(1000);
        numberTester.readData("numbers_1.txt");
        numberTester.calcStdDiv();
        System.out.println(numberTester.getStdDiv());
        
    }
}
