// Bytecode Inspection Example
public class Ex37 {
    private int value;
    private static final double PI = 3.14159;
    
    public Ex37(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
    
    public void setValue(int value) {
        this.value = value;
    }
    
    public double calculateArea(double radius) {
        return PI * radius * radius;
    }
    
    public static void main(String[] args) {
        // Create instance and demonstrate methods
        Ex37 example = new Ex37(42);
        System.out.println("Initial value: " + example.getValue());
        example.setValue(100);
        System.out.println("Updated value: " + example.getValue());
        System.out.println("Area of circle with radius 5: " + example.calculateArea(5));
        
        // Instructions for viewing bytecode:
        System.out.println("\nTo view bytecode, compile and run these commands:");
        System.out.println("javac Ex37.java");
        System.out.println("javap -c Ex37.class");
    }
}
