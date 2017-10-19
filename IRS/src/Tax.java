
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
        
        if (salaryAmount > 297250)
            result = 88306 + 0.391 * (salaryAmount - 297250);
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
