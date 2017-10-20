package taxcalculator;

/*
 *  - Tax implies that it models a tax, however having all static methods makes it closer to a tax calculator
 *  - Tax bracket values and rates are all hard coded, making it difficult to expand later
 *  - IO parsing is messy, 'nextDouble()' and 'nextInt()' are cleaner than 
 *      'Double.parseDouble(inputStream.next())' or 'Integer.parseInt(inputStream.next())'
 *      and checking if the int == 2 will break functionality, 1 should be single, 2 is married,
 *      as it is 0, -1, 5, 842 will all be single
 * 
 *  Off topic, all three methods follow the formula:
 *      result = 0
 *      
 *      if (...)
 *          result = 1
 *      else if (...)
 *          result = 2
 *      ...
 *      
 *      return result
 *  
 *  The form:
 *      if (...)
 *          return 1
 *      else if (...)
 *          return 2
 *      ...
 *  
 *  is much cleaner and easier to read
 *  
 *  
 *  
 *  Tests:
 *      Married, 300000 --> 89381.25 (should be 89342.15)
 *      Single, 170000  --> 48164.75 (should be 48164.75)
 *      Married, 30000  --> 4500     (should be 4500)
 *      Single, 45000   --> 8993.75 (should be 8993.75)
 *     
 *  a. 2
 *  b. 3
 *  c. 6
 *  d. 5
 */

public class Tax
{
    public static double calculateTax(boolean isMarried, double salaryAmount)
    {
        double result = 0.0;
        
        if (isMarried)
            result = marriedTaxFiling(salaryAmount);
        else
            result = singleTaxFiling(salaryAmount);
        
        return result;
    }

    private static double singleTaxFiling(double salaryAmount)
    {
        double result = 0.0;
        
        if (salaryAmount > 297250)
            result = 93374 + 0.391 * (salaryAmount - 297250);
        else if (salaryAmount > 136750)
            result = 36361 + 0.355 * (salaryAmount - 136750);
        else if (salaryAmount > 65550)
            result = 14645 + 0.305 * (salaryAmount - 65550);
        else if (salaryAmount > 27050)
            result = 4057.50 + 0.275 * (salaryAmount - 27050);
        else if (salaryAmount > 0)
            result = 0.15 * (salaryAmount);
        
        return result;
    }

    private static double marriedTaxFiling(double salaryAmount)
    {
        double result = 0.0;
        
        if (salaryAmount > 297350)
            result = 88306 + 0.391 * (salaryAmount - 297350);
        else if (salaryAmount > 166500)
            result = 41855 + 0.355 * (salaryAmount - 166500);
        else if (salaryAmount > 109250)
            result = 24393.75 + 0.305 * (salaryAmount - 109250);
        else if (salaryAmount > 45200)
            result = 6780 + 0.275 * (salaryAmount - 45200);
        else if (salaryAmount > 0)
            result = 0.15 * (salaryAmount);
        
        return result;
    }
        
}
