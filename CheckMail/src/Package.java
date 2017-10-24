
public class Package
{
    private double dim1, dim2, dim3, weight;
    
    public Package(double dim1, double dim2, double dim3, double weight)
    {
        this.dim1 = dim1;
        this.dim2 = dim2;
        this.dim3 = dim3;
        this.weight = weight;

    }

    public String checkStatus()
    {
        double girth = 0.0;
                
        if (dim1 >= dim2 && dim1 >= dim3)
        {
            girth = (dim2 + dim3) * 2;
        }
        else if (dim2 >= dim1 && dim2 >= dim3)
        {
            double temp = dim1;
            dim1 = dim2;
            dim2 = temp;
            
            girth = (dim2 + dim3) * 2;
        }
        else if (dim3 >= dim1 && dim3 >= dim2)
        {
            double temp = dim1;
            dim1 = dim2;
            dim2 = temp;
            
            girth = (dim2 + dim3) * 2;
        }
        
        if (girth + dim1 <= 100 && weight <= 70)
        {
            return "Package is acceptable";
        }
        else if (girth + dim1 > 100)
        {
            if (weight > 70)
                return "Package too large and too heavy";
            else 
                return "Package too large";
        }
        else
            return "Package too heavy";
        
        
        
        
    }
}
