import java.util.Scanner;


public class RecursiveStringTools {
	
	// Example
	public static int length(String in) {
		if (in.equals(""))
		    return 0;
		else
		    return length(in.substring(1)) + 1;
	}
	
	

	// Example
	public static boolean equals(String in1, String in2) {
		if (in1.length() != in2.length())
		    return false;
		else if (in1.charAt(0) != in2.charAt(0))
		    return false;
		else
		    return equals(in1.substring(1), in2.substring(1));
	}
	

	
	// Exercise #1
	public static boolean matches(String in1, String in2) {
		return false;
	}
	
	

	// Exercise #2
	public static boolean isPalindrome(String in) {
		return true;
	}
	
	

	// Exercise #3
	public static void printPermutations(String in) {

	}
	
	
	
	public static String piglatinate(String in) {
		return "";
	}
	
	
	
	public static void main(String[] args) {
		Scanner kboard = new Scanner(System.in);
		System.out.println("Please enter a string:");
		String s = kboard.nextLine();
	
		String out = RecursiveStringTools.equals(s, "Hello") + "";
		System.out.print("\n\nThe result is --> " + out + "\n\n");
		
		
	}
}
