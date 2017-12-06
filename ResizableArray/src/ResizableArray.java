import java.util.Arrays;

public class ResizableArray
{
     private int[] data;
     private int size;
     private final int DEFAULT_LENGTH = 50;
     
     public ResizableArray()
     {
         data = new int[DEFAULT_LENGTH];
         size = 0;
     }
     
     public void add(int value)
     {
         if (data.length == size)
             resize();
         
         data[size] = value;
         size++;
     }
     
     private void resize()
     {
         int[] resizedData = Arrays.copyOf(data, DEFAULT_LENGTH + 50);
         data = resizedData;
     }
     
     public void removeAll(int value)
     {
         
         for(int i = 0; i < size; i++)
         { 
             if (data[i] == value)
             {
                 for(int j = i; j < size - 1; j++)
                     data[j] = data[j + 1];
                 
                 size--;
                 i--;   
             }
         }
     }
     
     public int remove(int index)
     {

        if (index >= size || index < 0)
            throw new IllegalArgumentException("Index out of range of the data");

        int result = data[index];

        for (int j = index; j < size - 1; j++)
            data[j] = data[j + 1];

        size--;

        return result;

    }

     public String toString()
     {
         String output = "[";
         
         for(int i = 0; i < size; i++)
         {
             int num = data[i];
             
             if (i != size - 1)
                 output += (num + ", ");
             else
                 output += (num + "]");
         }

         
         return output;

     }
     
     public int size()
     {
         return size;
     }

    public void insert(int index, int value)
    {
        if (index > size || index < 0)
            throw new IllegalArgumentException("Index out of range of the data");
        
        size++;
        
        for (int i = size - 1; i > index; i--)
        {
            data[i] = data[i - 1];
        }
        
        data[index] = value;
    }

    public void set(int index, int value)
    {
        data[index] = value;
    }

    public int get(int index)
    {
        return data[index];
    }
    
    public boolean equals(Object other)
    {
        if (other instanceof ResizableArray)
        {
            ResizableArray other2 = (ResizableArray)(other);
            
            //TODO
            return Arrays.equals(other2.data, this.data);
        }
        
        return false;
        
    }

    public void sort()
    {
        // TODO Auto-generated method stub
        
    }

}
