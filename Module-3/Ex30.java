// Pattern Matching for switch Example
import java.util.Scanner;

public class Ex30 {
    public static void typeCheck(Object obj) {
        String result = switch (obj) {
            case Integer i -> "Integer value: " + i;
            case String s -> "String value: " + s;
            case Double d -> "Double value: " + d;
            case Boolean b -> "Boolean value: " + b;
            case null -> "Null value";
            default -> "Unknown type: " + obj.getClass().getSimpleName();
        };
        System.out.println(result);
    }

    public static void main(String[] args) {
        // Test with different types
        typeCheck(42);
        typeCheck("Hello");
        typeCheck(3.14);
        typeCheck(true);
        typeCheck(null);
        typeCheck(new Scanner(System.in));
    }
}
