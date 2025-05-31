// Objective: Check whether a string is a palindrome
import java.util.Scanner;

public class Ex34 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine().toLowerCase().replaceAll("\\s+", "");
        String reversed = new StringBuilder(str).reverse().toString();

        if (str.equals(reversed))
            System.out.println("The string is a palindrome.");
        else
            System.out.println("The string is not a palindrome.");

        sc.close();
    }
}
