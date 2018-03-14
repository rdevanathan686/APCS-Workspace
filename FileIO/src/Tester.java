import java.util.ArrayList;

import javax.swing.JFileChooser;
public class Tester
{
    

    public static void main(String[] args)
    {
        // open from the working directory
        JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
        // FileNameExtensionFilter filter = new FileNameExtensionFilter(
        // "JPG & GIF Images", "jpg", "gif");
        // chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
            System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
            ArrayList<String> fileData = FileIO.readFile(chooser.getSelectedFile().getAbsolutePath());
            System.out.println(fileData);
            
            FileIO.writeFile("testFile", fileData);
        }

    }

}
