import java.util.Scanner;

public class Tester
{

    public static void main(String[] args)
    {
        Eraser tester = new Eraser("digital.txt");

        Scanner in = new Scanner(System.in);
        
        System.out.println(tester);
        System.out.print("Enter x-coordinate for erasing: ");
        int x = in.nextInt();
        System.out.print("Enter y-coordinate for erasing: ");
        int y = in.nextInt();
        
        tester.erase(x, y);
        System.out.println(tester);
        
    }

}
