import java.util.Scanner;

public class Main
{
    public static void main (String[] args)
    {
        Scanner inputStream = new Scanner(System.in);
        System.out.print("Enter your filing status: Single(1) or Married(2)?: ");
        boolean isMarried = false;
        
        if (Integer.parseInt(inputStream.next()) == 2)
            isMarried = true;
        
        System.out.print("Enter the amount of taxable income: ");
        double salaryAmount = Double.parseDouble(inputStream.next());
        
        double taxableIncome = Tax.calculateTax(isMarried, salaryAmount);
        
        System.out.println(taxableIncome);
       
    }
}
