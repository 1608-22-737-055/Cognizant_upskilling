// Animal Inheritance Example

// Base class Animal
class Animal {
    public void makeSound() {
        System.out.println("Some sound");
    }
}

// Derived class Dog
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Bark!");
    }
    
    // Additional method specific to Dog
    public void wagTail() {
        System.out.println("Dog is wagging its tail");
    }
}

public class Ex18 {
    public static void main(String[] args) {
        // Create instances of both classes
        System.out.println("Testing Animal class:");
        Animal animal = new Animal();
        animal.makeSound();
        
        System.out.println("\nTesting Dog class:");
        Dog dog = new Dog();
        dog.makeSound();  // Overridden method
        dog.wagTail();    // Dog-specific method
        
        System.out.println("\nTesting polymorphism:");
        Animal polymorphicDog = new Dog();
        polymorphicDog.makeSound();  // Calls Dog's makeSound
    }
}
