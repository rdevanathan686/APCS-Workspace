
public class Tester
{
    public static void main(String[] args)
    {
        ResizableArray arr = new ResizableArray();
        arr.addData(10);
        arr.addData(40);
        arr.addData(40);
        arr.addData(10);
        
        arr.removeAll(10);
        
        System.out.println(arr);
    }
}
