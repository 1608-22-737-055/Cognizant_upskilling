// Palindrome Checker Example
import java.util.Scanner;

public class Ex16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        // Remove non-alphanumeric characters and convert to lowercase
        String cleanStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        // Check if it's a palindrome
        boolean isPalindrome = true;
        int left = 0;
        int right = cleanStr.length() - 1;
        
        while (left < right) {
            if (cleanStr.charAt(left) != cleanStr.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }
        
        // Display result
        if (isPalindrome) {
            System.out.println("\"" + str + "\" is a palindrome.");
        } else {
            System.out.println("\"" + str + "\" is not a palindrome.");
        }
        
        sc.close();
    }
}
