// Objective: Find the LCM (Least Common Multiple) of two numbers
import java.util.Scanner;

public class Ex31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter two numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int max = Math.max(a, b);

        int lcm = max;
        while (true) {
            if (lcm % a == 0 && lcm % b == 0) {
                break;
            }
            lcm++;
        }

        System.out.println("LCM is: " + lcm);
        sc.close();
    }
}

