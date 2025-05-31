// Objective: Count the number of digits in a given number
import java.util.Scanner;

public class Ex26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int count = 0;

        do {
            num /= 10;
            count++;
        } while (num != 0);

        System.out.println("Number of digits: " + count);
        sc.close();
    }
}
