
public class Tester
{

    public static void main(String[] args)
    {
        Crypt c = new Crypt();
        String fileName = "Romeo.txt";
        c.encrypt(fileName, "Encrypted" + fileName, "TIGER");
    }

}
