public class StatisticsRunner
{
    public static void main (String[] args)
    {
        Statistics numberTester = new Statistics(1000);
        numberTester.readData("numbers.txt");
        
        System.out.println("For the following data: ");
        numberTester.printData();
        
        System.out.println("The average is " + numberTester.getAverage());
        System.out.println("The standard deviation is " + numberTester.getStdDev());

        System.out.print("The mode(s) is ");
        numberTester.printData(numberTester.calcMode());
    }
}
