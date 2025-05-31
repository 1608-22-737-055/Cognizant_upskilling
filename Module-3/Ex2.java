//Simple Calculator 

import java.util.Scanner;

public class Ex2  {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Choose an operator: +, -, *, or /: ");
        char operator = input.next().charAt(0);

        System.out.print("Enter first number: ");
        double number1 = input.nextDouble();

        System.out.print("Enter second number: ");
        double number2 = input.nextDouble();

        double result;

        switch (operator) {
            case '+':
                result = number1 + number2;
                System.out.println(number1 + " + " + number2 + " = " + result);
                break;

            case '-':
                result = number1 - number2;
                System.out.println(number1 + " - " + number2 + " = " + result);
                break;

            case '*':
                result = number1 * number2;
                System.out.println(number1 + " * " + number2 + " = " + result);
                break;

            case '/':
                if (number2 != 0) {
                    result = number1 / number2;
                    System.out.println(number1 + " / " + number2 + " = " + result);
                } else {
                    System.out.println("Error: Division by zero is undefined.");
                }
                break;

            default:
                System.out.println("Invalid operator!");
                break;
        }

        input.close();
    }
}

