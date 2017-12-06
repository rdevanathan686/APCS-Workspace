
public class Tester
{
    public static void main(String[] args)
    {
        ResizableArray arr = new ResizableArray();
        arr.add(10);
        arr.add(40);
        arr.add(40);
        arr.add(10);
        arr.add(10);
        arr.insert(0, 9);
     
        //arr.removeAll(10);
        
        System.out.println(arr);
    }
}
