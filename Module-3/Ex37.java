// Objective: Calculate the result of a number raised to a power
import java.util.Scanner;

public class Ex37 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base and exponent: ");
        double base = sc.nextDouble();
        int exponent = sc.nextInt();
        double result = Math.pow(base, exponent);

        System.out.println("Result: " + result);
        sc.close();
    }
}
