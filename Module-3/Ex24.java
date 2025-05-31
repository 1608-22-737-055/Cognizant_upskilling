// ArrayList Example
import java.util.ArrayList;
import java.util.Scanner;

public class Ex24 {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add student");
            System.out.println("2. Display all students");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    students.add(name);
                    System.out.println("Student added successfully!");
                    break;
                    
                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students in the list.");
                    } else {
                        System.out.println("\nStudent List:");
                        for (int i = 0; i < students.size(); i++) {
                            System.out.println((i + 1) + ". " + students.get(i));
                        }
                    }
                    break;
                    
                case 3:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
}
