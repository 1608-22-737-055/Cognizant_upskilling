// String Reversal Example
import java.util.Scanner;

public class Ex15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        // Method 1: Using StringBuilder
        String reversed1 = new StringBuilder(str).reverse().toString();
        System.out.println("Reversed string (using StringBuilder): " + reversed1);
        
        // Method 2: Using loop (for demonstration)
        char[] chars = str.toCharArray();
        String reversed2 = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            reversed2 += chars[i];
        }
        System.out.println("Reversed string (using loop): " + reversed2);
        
        sc.close();
    }
}
