// JDBC Insert and Update Operations Example
import java.sql.*;
import java.util.Scanner;

class StudentDAO {
    private Connection conn;
    private final String url = "jdbc:mysql://localhost:3306/students_db";
    private final String user = "root";
    private final String password = "password";

    public StudentDAO() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.conn = DriverManager.getConnection(url, user, password);
    }

    public void insertStudent(String name, int age) throws SQLException {
        String sql = "INSERT INTO students (name, age) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " student(s) inserted successfully!");
        }
    }

    public void updateStudent(int id, String name, int age) throws SQLException {
        String sql = "UPDATE students SET name = ?, age = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setInt(3, id);
            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " student(s) updated successfully!");
        }
    }

    public void close() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
}

public class Ex32 {
    public static void main(String[] args) {
        try {
            StudentDAO dao = new StudentDAO();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nStudent Management System");
                System.out.println("1. Insert new student");
                System.out.println("2. Update student");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter student age: ");
                        int age = scanner.nextInt();
                        dao.insertStudent(name, age);
                        break;

                    case 2:
                        System.out.print("Enter student ID to update: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new age: ");
                        int newAge = scanner.nextInt();
                        dao.updateStudent(id, newName, newAge);
                        break;

                    case 3:
                        dao.close();
                        scanner.close();
                        System.out.println("Goodbye!");
                        return;

                    default:
                        System.out.println("Invalid option!");
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Database error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
