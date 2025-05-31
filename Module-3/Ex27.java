// Lambda Expressions Example
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex27 {
    public static void main(String[] args) {
        // Create a list of strings
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Alice");
        names.add("Bob");
        names.add("Carol");
        names.add("David");
        
        System.out.println("Original list: " + names);
        
        // Sort using lambda expression
        Collections.sort(names, (s1, s2) -> s1.compareToIgnoreCase(s2));
        System.out.println("Sorted list (case-insensitive): " + names);
        
        // Sort by length using lambda
        Collections.sort(names, (s1, s2) -> s1.length() - s2.length());
        System.out.println("Sorted by length: " + names);
        
        // Filter names starting with 'A' using lambda
        System.out.println("\nNames starting with 'A':");
        names.forEach(name -> {
            if (name.startsWith("A")) {
                System.out.println(name);
            }
        });
        
        // Transform each name to uppercase using lambda
        System.out.println("\nNames in uppercase:");
        names.forEach(name -> System.out.println(name.toUpperCase()));
    }
}
