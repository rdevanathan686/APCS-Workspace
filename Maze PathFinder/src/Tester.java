public class Tester
{

    public static void main(String[] args)
    {
        Maze tester = new Maze("test3.txt");
        
        System.out.println("Before:\n" + tester);
        tester.solve();
        System.out.println("After:\n" + tester);
        
    }

}
