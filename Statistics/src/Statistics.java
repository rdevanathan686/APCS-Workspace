public class Statistics
{
    private int[] data;
    private double average;
    private int[] mode;
    private double stdDiv;
    
    
    public Statistics(int maxLength)
    {
        data = new int[maxLength];
        mode = new int[maxLength];
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
    
    public void printData(int[] inputData)
    {
        for(int num : inputData)
            System.out.println(num);
    }
    
    public void calcAvg()
    {
        long localAvg = 0;
        
        for (int num : data)
            localAvg += num;

        average = localAvg / (double)(data.length);
        
    }
    
    public int[] calcMode()
    {
        int maxOccurence = 0;
        int numModes = 0;
        int[] localMode = new int[numModes + 1];

        
        for(int i : data)
        {
           int iOcc = 0;
           
           for(int j : data)
               if (i == j)
                   iOcc++;
                         
           if (maxOccurence <= iOcc)
           {
               boolean exists = false;
               
               for (int k = 0; k < localMode.length; k++)
               {
                   if (localMode[k] == i)
                   {
                       exists = true;
                       break;
                   }
               }
               
               if (!exists)
               {
                   numModes++;
                   maxOccurence = iOcc;
                   
                   int[] copyLocalMode = new int[localMode.length + 1];
                   
                   for (int l = 0; l < localMode.length; l++)
                   {
                       copyLocalMode[l] = localMode[l];
                   }
                   
                   copyLocalMode[numModes] = i;
                   
                   localMode = copyLocalMode;

               }

           }

        }
        
        return localMode;
    }
    
    public void calcStdDev()
    {
        calcAvg();
        
        int localStdDiv = 0;
        
        for(int num : data)
            localStdDiv += ((average - num) * (average - num));
        
        stdDiv = Math.sqrt(localStdDiv / (double)(data.length - 1));
        
    }
    
    public int[] getData()
    {
        return data;
    }

    public double getAverage()
    {
        calcAvg();
        return (double) Math.round(average * 100) / 100;
    }

    public int[] getMode()
    {
        calcMode();
        return mode;
    }

    public double getStdDev()
    {
        calcStdDev();
        return (double) Math.round(stdDiv * 100) / 100;
    }


}
