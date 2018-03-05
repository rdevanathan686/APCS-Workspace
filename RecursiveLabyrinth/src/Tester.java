public class Tester
{

    public static void main(String[] args)
    {
        Labyrinth tester = new Labyrinth("test1.txt");
        
        System.out.println("Before:\n" + tester);
        tester.findPath();
        System.out.println("After:\n" + tester);
        
    }

}
