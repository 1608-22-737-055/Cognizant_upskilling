// Java Modules Example
// Main module class
public class Ex34 {
    public static void main(String[] args) {
        // Demonstrate module usage
        System.out.println("Main Module: com.greetings");
        
        // Using utility from com.utils module
        StringUtils utils = new StringUtils();
        String message = "Hello from Java Modules!";
        
        System.out.println("Original message: " + message);
        System.out.println("Reversed: " + utils.reverse(message));
        System.out.println("To upper case: " + utils.toUpper(message));
        
        // Using math utilities
        MathUtils mathUtils = new MathUtils();
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Sum: " + mathUtils.sum(numbers));
        System.out.println("Average: " + mathUtils.average(numbers));
    }
}

// Utility classes that would normally be in separate files/modules
class StringUtils {
    public String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    
    public String toUpper(String str) {
        return str.toUpperCase();
    }
}

class MathUtils {
    public int sum(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
    
    public double average(int[] numbers) {
        if (numbers.length == 0) return 0;
        return (double) sum(numbers) / numbers.length;
    }
}
