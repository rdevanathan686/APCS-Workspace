import java.util.Arrays;

public class Statistics
{
    private int[] data;
    private double average;
    private int[] mode;
    private double stdDiv;
    private int realLength;

    
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
        for(int num = 0; num < realLength; num++)
            System.out.println(data[num]);
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
        
        for (int num = 0; num < realLength; num++)
            localAvg += data[num];

        average = localAvg / (double)(realLength);
        
    }
    
    public int[] calcMode()
    {
//        int maxOccurence = 0;
//        int[] localMode = new int[0];
//        int[] localModeOcc = new int[0];
//
//        for (int i = 0; i < realLength; i++)
//        {
//            int element = data[i];
//            int elementOcc = 0;
//
//            for (int j : data)
//                if (element == j)
//                    elementOcc++;
//
//            boolean exists = false;
//
//            for (int k : localMode)
//            {
//                if (k == element)
//                {
//                    exists = true;
//                    break;
//                }
//            }
//
//            if (!exists)
//            {
//                int[] copyLocalMode = Arrays.copyOf(localMode, localMode.length + 1);
//                copyLocalMode[localMode.length] = element;
//                
//                int[] copyLocalModeOcc = Arrays.copyOf(localModeOcc, localModeOcc.length + 1);
//                copyLocalModeOcc[localMode.length] = elementOcc;
//                
//                localMode = copyLocalMode;
//                localModeOcc = copyLocalModeOcc;
//
//            }
//
//        }
//        
//        
//        int[] index = null;
//        
//        for (int a = 0; a < localModeOcc.length; a++)
//        {
//            if (maxOccurence < localModeOcc[a])
//            {
//                maxOccurence = localModeOcc[a];
//                index = new int[1];
//                index[0] = a;
//            }
//            
//            else if (maxOccurence == localModeOcc[a])
//            {
//                int[] copyIndex = Arrays.copyOf(index, index.length + 1);
//                copyIndex[copyIndex.length - 1] = a;
//                
//                index = copyIndex;
//            }
//                
//                
//        }
//        
//        int[] result = new int[index.length];
//        
//        for (int b = 0; b < index.length; b++)
//        {
//            result[b] = localMode[index[b]];
//        }
//        
//        return result;

        int element = data[0];
        int[] count = new int[element];
        
        for(int i = 0; i < realLength; i++)
        {
            element = data[i];
            
            if (count.length <= element)
            {
                int[] copyCount =  Arrays.copyOf(count, element + 1);
                copyCount[element]++;
                
                count = copyCount;
            }
            else
                count[element]++;
        }
       
        int[] copyCount = Arrays.copyOf(count, count.length);
        Arrays.sort(copyCount);
        
        int max = copyCount[copyCount.length - 1];
        
        int[] result = new int[0];
        
        for(int i = 0; i < count.length; i++)
        {
            if (count[i] == max)
            {
                int[] copyResult =  Arrays.copyOf(result, result.length + 1);
                copyResult[copyResult.length - 1] = i;
                
                result = copyResult;
            }

        }
        
        return result;
<<<<<<< HEAD

=======
<<<<<<< HEAD

=======
>>>>>>> f3a3597a9c278e41cfb98e8da1bd2f4142ecbf55
>>>>>>> b1aa8c54b8db7a79b90c614949eafd2ddb365040


    }
    
    public void calcStdDev()
    {
        calcAvg();
        
        int localStdDiv = 0;
        
        for(int num = 0; num < realLength; num++)
            localStdDiv += ((average - data[num]) * (average - data[num]));
        
        stdDiv = Math.sqrt(localStdDiv / (double)(realLength - 1));
        
    }
    
    // Precondition: data is non-null int array, size is the number of legitimate
    // elements in data
    // Postcondition: Moves all non-zero integers to the front of the array data,
    // leaving the
    // order of integers otherwise unchanged. Returns the new number of legitimate
    // data
    // elements.
    public void compact()
    {
        int newRealLength = 0;
        
        for(int i = 0; i < realLength; i++)
        {
            int element = data[i];
            
            if (element == 0)
            {

                for(int j = i; j < realLength; j++)
                {
                    if (data[j] != 0)
                    {
                        swap(i, j);
                        
                    }

                        
                    
                }
                
            }

        }
        
        int i = 0;
        while (data[i] != 0)
        {
            newRealLength++;
            i++;
        }
        
        for(int k = 0; k < newRealLength/4; k++)
        {
            swap(k, newRealLength - k - 1);
        }
        
        realLength = newRealLength;
        
        
    }

    
    private void swap(int a, int b)
    {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
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
