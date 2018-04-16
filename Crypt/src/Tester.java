
public class Tester
{

    public static void main(String[] args)
    {
        Crypt c = new Crypt();
        String fileName = "testfile";
        c.encrypt(fileName, "Encrypted" + fileName, "crypt");
    }

}
