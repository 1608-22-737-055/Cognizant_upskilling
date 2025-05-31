// Interface Implementation Example

// Define the Playable interface
interface Playable {
    void play();
}

// Guitar class implementing Playable
class Guitar implements Playable {
    @Override
    public void play() {
        System.out.println("Playing guitar strings...");
    }
}

// Piano class implementing Playable
class Piano implements Playable {
    @Override
    public void play() {
        System.out.println("Playing piano keys...");
    }
}

public class Ex19 {
    public static void main(String[] args) {
        // Create instances of both instruments
        Guitar guitar = new Guitar();
        Piano piano = new Piano();
        
        // Test the play method
        System.out.println("Testing Guitar:");
        guitar.play();
        
        System.out.println("\nTesting Piano:");
        piano.play();
        
        // Demonstrate polymorphism with interface
        System.out.println("\nTesting polymorphism:");
        Playable instrument1 = new Guitar();
        Playable instrument2 = new Piano();
        
        instrument1.play();
        instrument2.play();
    }
}
