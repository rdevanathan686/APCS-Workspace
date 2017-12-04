public class ResizableArray
{
     private int[] data;
     private int size;
     private final int MAX = 1000;
     
     public ResizableArray()
     {
         data = new int[MAX];
         size = 0;
     }
     
     public void add(int value)
     {
         data[size] = value;
         size++;
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

    public void insert(int i, int j)
    {
        // TODO Auto-generated method stub
        
    }

    public void set(int i, int val)
    {
        // TODO Auto-generated method stub
        
    }

    public int get(int i)
    {
        // TODO Auto-generated method stub
        return 0;
    }

    public void sort()
    {
        // TODO Auto-generated method stub
        
    }

}
