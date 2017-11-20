
public class Statistics
{
    private int[] data;
    private double average;
    private int mode;
    private double stdDiv;
    
    
    public Statistics(int maxLength)
    {
        data = new int[maxLength];
    }
    
    public void readData(String fileName)
    {
        ArrayReader reader = new ArrayReader(fileName);
        reader.fillArray(data);
    }
    
    public void printData()
    {
        for(int num : data)
            System.out.println(num);

    }
    
    public void calcAvg()
    {
        long localAvg = 0;
        
        for(int num : data)
            localAvg += num;

        average = localAvg / data.length;
        
    }
    
    public void calcMode()
    {
        int maxOccurence = 0;
        int localMode = 0;
        
        for(int i : data)
        {
           int iOcc = 0;
           
           for(int j : data)
           {
               if (i == j)
                   iOcc++;
           }
           
           if (maxOccurence < iOcc)
           {
               maxOccurence = iOcc;
               localMode = i;
           }

        }
        
        mode = localMode;
    }
    
    public void calcStdDiv()
    {
        int localStdDiv = 0;
        
        for(int num : data)
        {
            localStdDiv += (average - num);
        }
        
        localStdDiv = localStdDiv / (data.length - 1);
        
        stdDiv = Math.sqrt(localStdDiv);
    }
    
    public int[] getData()
    {
        return data;
    }

    public void setData(int[] data)
    {
        this.data = data;
    }

    public double getAverage()
    {
        return average;
    }

    public void setAverage(double average)
    {
        this.average = average;
    }

    public int getMode()
    {
        return mode;
    }

    public void setMode(int mode)
    {
        this.mode = mode;
    }

    public double getStdDiv()
    {
        return stdDiv;
    }

    public void setStdDiv(double stdDiv)
    {
        this.stdDiv = stdDiv;
    }

}
