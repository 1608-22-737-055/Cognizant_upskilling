import java.util.Scanner;

// Multiplication Table

public class Ex5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = input.nextInt();

        for (int i = 1; i <= 10; ++i) {
            System.out.println(num + " * " + i + " = " + (num * i));
        }

        input.close();
    }
}
