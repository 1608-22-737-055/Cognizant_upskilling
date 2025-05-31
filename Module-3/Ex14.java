// Array Sum and Average Example
import java.util.Scanner;

public class Ex14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] array = new int[n];
        
        // Read elements into array
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            array[i] = sc.nextInt();
        }
        
        // Calculate sum and average
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        double average = (double) sum / n;
        
        // Display results
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        
        sc.close();
    }
}
