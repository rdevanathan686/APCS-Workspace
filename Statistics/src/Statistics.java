import java.util.Arrays;

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
        String output = "[";
        
        for(int i = 0; i < inputData.length; i++)
        {
            int num = inputData[i];
            
            if (i != inputData.length - 1)
                output += (num + ", ");
            else
                output += (num + "]");
        }

        
        System.out.print(output);
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
        int[] localMode = new int[0];
        int[] localModeOcc = new int[0];

        for (int i = 0; i < data.length; i++)
        {
            int element = data[i];
            int elementOcc = 0;

            for (int j : data)
                if (element == j)
                    elementOcc++;

            boolean exists = false;

            for (int k : localMode)
            {
                if (k == element)
                {
                    exists = true;
                    break;
                }
            }

            if (!exists)
            {
                int[] copyLocalMode = Arrays.copyOf(localMode, localMode.length + 1);
                copyLocalMode[localMode.length] = element;
                
                int[] copyLocalModeOcc = Arrays.copyOf(localModeOcc, localModeOcc.length + 1);
                copyLocalModeOcc[localMode.length] = elementOcc;
                
                localMode = copyLocalMode;
                localModeOcc = copyLocalModeOcc;

            }

        }
        
        
        int[] index = null;
        
        for (int a = 0; a < localModeOcc.length; a++)
        {
            if (maxOccurence < localModeOcc[a])
            {
                maxOccurence = localModeOcc[a];
                index = new int[1];
                index[0] = a;
            }
            
            else if (maxOccurence == localModeOcc[a])
            {
                int[] copyIndex = Arrays.copyOf(index, index.length + 1);
                copyIndex[copyIndex.length - 1] = a;
                
                index = copyIndex;
            }
                
                
        }
        
        int[] result = new int[index.length];
        
        for (int b = 0; b < index.length; b++)
        {
            result[b] = localMode[index[b]];
        }
        
        return result;

    

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
