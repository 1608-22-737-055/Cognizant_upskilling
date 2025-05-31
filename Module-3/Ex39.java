// Reflection API Example
import java.lang.reflect.*;
import java.util.Arrays;

class TestClass {
    private String privateField;
    public int publicField;
    
    public TestClass() {
        this.privateField = "Default";
        this.publicField = 0;
    }
    
    public TestClass(String value) {
        this.privateField = value;
        this.publicField = 1;
    }
    
    private void privateMethod() {
        System.out.println("Private method called");
    }
    
    public void publicMethod(String message) {
        System.out.println("Public method called with: " + message);
    }
}

public class Ex39 {
    public static void main(String[] args) {
        try {
            // Load the class
            Class<?> clazz = Class.forName("TestClass");
            System.out.println("Class name: " + clazz.getName());
            
            // Get constructors
            System.out.println("\nConstructors:");
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            Arrays.stream(constructors).forEach(c -> 
                System.out.println(c.getParameterCount() + " parameter(s)"));
            
            // Get fields
            System.out.println("\nFields:");
            Field[] fields = clazz.getDeclaredFields();
            Arrays.stream(fields).forEach(f -> 
                System.out.println(f.getName() + " (" + f.getType() + ")"));
            
            // Get methods
            System.out.println("\nMethods:");
            Method[] methods = clazz.getDeclaredMethods();
            Arrays.stream(methods).forEach(m -> 
                System.out.println(m.getName() + " (" + m.getReturnType() + ")"));
            
            // Create instance using reflection
            Constructor<?> constructor = clazz.getConstructor(String.class);
            Object instance = constructor.newInstance("Reflection Test");
            
            // Access and modify private field
            Field privateField = clazz.getDeclaredField("privateField");
            privateField.setAccessible(true);
            System.out.println("\nPrivate field value: " + privateField.get(instance));
            privateField.set(instance, "Modified by reflection");
            System.out.println("Modified private field: " + privateField.get(instance));
            
            // Invoke private method
            Method privateMethod = clazz.getDeclaredMethod("privateMethod");
            privateMethod.setAccessible(true);
            System.out.println("\nInvoking private method:");
            privateMethod.invoke(instance);
            
            // Invoke public method
            Method publicMethod = clazz.getMethod("publicMethod", String.class);
            System.out.println("\nInvoking public method:");
            publicMethod.invoke(instance, "Hello from reflection!");
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
