
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
     
     public void addData(int value)
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
                 {
                     data[j] = data[j + 1];
                     size--;
                     
                 }
                 
             }

         }
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
     
     
     //Methods
     /*
      * Sort Methods
      * Accessors
      * Inverse
      * Duplicate 
      * Find - returns the index
      * Get Occurences
      * Print Methods
      * Contains Method
      * Swap Method
      * 
      * get, set for specific elements
      */

}
