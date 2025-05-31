//OperatorPrecedence
public class Ex8 {
    public static void main(String[] args) {
        // Example 1: Basic arithmetic precedence
        int result1 = 10 + 5 * 2;
        System.out.println("10 + 5 * 2 = " + result1 + " (multiplication before addition)");

        // Example 2: Parentheses changing precedence
        int result2 = (10 + 5) * 2;
        System.out.println("(10 + 5) * 2 = " + result2 + " (parentheses evaluated first)");

        // Example 3: Complex expression
        int result3 = 20 - 4 * 2 + 8 / 2;
        System.out.println("20 - 4 * 2 + 8 / 2 = " + result3 + " (multiplication and division before addition and subtraction)");

        // Example 4: Mixed operators
        boolean result4 = 5 > 3 && 10 <= 20;
        System.out.println("5 > 3 && 10 <= 20 = " + result4 + " (comparison before logical AND)");
    }
}
