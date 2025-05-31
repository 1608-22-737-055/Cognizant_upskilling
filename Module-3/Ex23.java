// File Reading Example
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex23 {
    public static void main(String[] args) {
        BufferedReader reader = null;
        
        try {
            reader = new BufferedReader(new FileReader("output.txt"));
            
            System.out.println("Contents of output.txt:");
            System.out.println("----------------------");
            
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            
            System.out.println("----------------------");
            
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing the file: " + e.getMessage());
            }
        }
    }
}
