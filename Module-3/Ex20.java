// Try-Catch Example
import java.util.Scanner;

public class Ex20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter the first number: ");
            int num1 = scanner.nextInt();
            
            System.out.print("Enter the second number: ");
            int num2 = scanner.nextInt();
            
            // Attempt division
            int result = divide(num1, num2);
            System.out.println("Result of division: " + result);
            
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero!");
            System.out.println("Exception message: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred!");
            System.out.println("Exception message: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Program completed.");
        }
    }
    
    public static int divide(int a, int b) {
        return a / b; // This may throw ArithmeticException
    }
}
