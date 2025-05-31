import java.util.Scanner;

//Leap year checker 

public class Ex4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int year = input.nextInt();

        boolean isLeap = false;

        if (year % 4 == 0) {
            if (year % 100 != 0)
                isLeap = true;
            else if (year % 400 == 0)
                isLeap = true;
        }

        if (isLeap)
            System.out.println(year + " is a leap year.");
        else
            System.out.println(year + " is not a leap year.");

        input.close();
    }
}
