// File Writing Example
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileWriter writer = null;
        
        try {
            System.out.println("Enter text to write to file (type 'exit' on a new line to finish):");
            writer = new FileWriter("output.txt");
            
            String line;
            while (!(line = scanner.nextLine()).equalsIgnoreCase("exit")) {
                writer.write(line + "\n");
            }
            
            System.out.println("Data has been written to output.txt successfully!");
            
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file: " + e.getMessage());
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing the file: " + e.getMessage());
            }
            scanner.close();
        }
    }
}
