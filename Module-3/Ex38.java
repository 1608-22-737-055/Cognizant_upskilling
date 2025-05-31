// Decompilation Example
import java.util.*;

class ComplexCalculator {
    private final String name;
    private int operationCount;
    
    public ComplexCalculator(String name) {
        this.name = name;
        this.operationCount = 0;
    }
    
    public double add(double... numbers) {
        operationCount++;
        return Arrays.stream(numbers).sum();
    }
    
    public double multiply(double... numbers) {
        operationCount++;
        return Arrays.stream(numbers).reduce(1, (a, b) -> a * b);
    }
    
    public double power(double base, double exponent) {
        operationCount++;
        return Math.pow(base, exponent);
    }
    
    public String getCalculatorInfo() {
        return String.format("Calculator: %s, Operations performed: %d", 
            name, operationCount);
    }
}

public class Ex38 {
    public static void main(String[] args) {
        ComplexCalculator calc = new ComplexCalculator("Scientific");
        
        // Perform some calculations
        System.out.println("Sum: " + calc.add(1, 2, 3, 4, 5));
        System.out.println("Product: " + calc.multiply(2, 3, 4));
        System.out.println("Power: " + calc.power(2, 3));
        
        // Show calculator info
        System.out.println(calc.getCalculatorInfo());
        
        // Instructions for decompilation
        System.out.println("\nTo decompile this class:");
        System.out.println("1. Compile: javac Ex38.java");
        System.out.println("2. Use a Java decompiler (JD-GUI, CFR, etc.)");
        System.out.println("3. Or use: javap -c Ex38.class");
    }
}
