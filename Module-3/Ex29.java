// Immutable Class Example (Alternative to Records)
import java.util.ArrayList;
import java.util.List;

// Define an immutable Person class
class Person {
    private final String name;
    private final int age;
    
    public Person(String name, int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
        this.age = age;
    }
    
    public String getName() { return name; }
    public int getAge() { return age; }
    
    @Override
    public String toString() {
        return "Person[name=" + name + ", age=" + age + "]";
    }
}

public class Ex29 {
    public static void main(String[] args) {
        try {
            // Create a list of persons
            List<Person> people = new ArrayList<>();
            people.add(new Person("John", 25));
            people.add(new Person("Alice", 30));
            people.add(new Person("Bob", 20));
            people.add(new Person("Carol", 35));
            
            // Display all people
            System.out.println("All People:");
            people.forEach(System.out::println);
            
            // Filter and display people over 25 using streams
            System.out.println("\nPeople over 25:");
            people.stream()
                  .filter(p -> p.getAge() > 25)
                  .forEach(System.out::println);
            
            // Find average age
            double avgAge = people.stream()
                                .mapToInt(Person::getAge)
                                .average()
                                .orElse(0.0);
            System.out.println("\nAverage age: " + avgAge);
            
            // Demonstrate validation
            System.out.println("\nTrying to create invalid person...");
            new Person("", -1); // This will throw an exception
            
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }
}
