// Objective: Count the number of words in a sentence
import java.util.Scanner;

public class Ex35 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();
        String[] words = sentence.trim().split("\\s+");

        System.out.println("Word count: " + words.length);
        sc.close();
    }
}
