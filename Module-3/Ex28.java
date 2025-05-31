// Stream API Example
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex28 {
    public static void main(String[] args) {
        // Create a list of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Filter even numbers using Stream API
        List<Integer> evenNumbers = numbers.stream() .filter(n -> n % 2 == 0) .collect(Collectors.toList());

        System.out.println("Original numbers: " + numbers);
        System.out.println("Even numbers: " + evenNumbers);

        // Additional Stream operations
        // Sum of even numbers
        int sumOfEven = evenNumbers.stream() .mapToInt(Integer::intValue) .sum();
        System.out.println("Sum of even numbers: " + sumOfEven);

        // Square of numbers
        List<Integer> squares = numbers.stream() .map(n -> n * n) .collect(Collectors.toList());
        System.out.println("Squares: " + squares);

        // Average of all numbers
        double average = numbers.stream() .mapToDouble(Integer::doubleValue) .average().orElse(0.0);
        System.out.println("Average: " + average);

        // Objective: Print the Fibonacci series up to n terms
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();
        int a = 0, b = 1;

        System.out.print("Fibonacci Series: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
        sc.close();
    }
}
