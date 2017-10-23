import java.util.Scanner;

public class CheckMail
{
    public static void main(String[] args)
    {
        Scanner inputStream = new Scanner(System.in);
        
        System.out.print("Enter the weight of the package: ");
        double weight = Double.parseDouble(inputStream.next());
        
        System.out.print("Enter the first dimension of the package: ");
        double dim1 = Double.parseDouble(inputStream.next());
        
        System.out.print("Enter the second dimension of the package: ");
        double dim2 = Double.parseDouble(inputStream.next());
        
        System.out.print("Enter the third dimension of the package: ");
        double dim3 = Double.parseDouble(inputStream.next());
        
        Package mailPackage = new Package(dim1, dim2, dim3, weight);
        System.out.println(mailPackage.checkStatus());
        
        inputStream.close();
    }
}
