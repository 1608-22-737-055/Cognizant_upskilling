// Basic JDBC Connection Example
import java.sql.*;

public class Ex31 {
    public static void main(String[] args) {
        // JDBC URL, username, and password of MySQL server
        String url = "jdbc:mysql://localhost:3306/students_db";
        String user = "root";
        String password = "password";

        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            System.out.println("Connecting to database...");
            Connection conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Successfully connected to the database!");

                // Create statement
                Statement stmt = conn.createStatement();
                
                // Execute query
                String sql = "SELECT * FROM students";
                ResultSet rs = stmt.executeQuery(sql);

                // Process results
                System.out.println("\nStudent Records:");
                System.out.println("ID\tName\t\tAge");
                System.out.println("------------------------");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    System.out.printf("%d\t%s\t\t%d%n", id, name, age);
                }

                // Close resources
                rs.close();
                stmt.close();
                conn.close();
            }

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed! Check output console");
            e.printStackTrace();
        }
    }
}

