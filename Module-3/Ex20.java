//LCM

import java.util.Scanner;

public class Ex20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        int max = (a > b) ? a : b;

        while (true) {
            if (max % a == 0 && max % b == 0) {
                System.out.println("LCM is: " + max);
                break;
            }
            max++;
        }

        sc.close();
    }
}
