//CountDigits

import java.util.Scanner;

public class Ex18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int count = 0;

        if (num == 0) count = 1;
        else {
            while (num != 0) {
                count++;
                num /= 10;
            }
        }

        System.out.println("Total digits: " + count);
        sc.close();
    }
}
