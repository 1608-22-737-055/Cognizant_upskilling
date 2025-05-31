// Car Class Example
class Car {
    private String make;
    private String model;
    private int year;
    
    // Constructor
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }
    
    // Display method
    public void displayDetails() {
        System.out.println("Car Details:");
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }
}

public class Ex17 {
    public static void main(String[] args) {
        // Create car objects
        Car car1 = new Car("Toyota", "Camry", 2022);
        Car car2 = new Car("Honda", "Civic", 2023);
        Car car3 = new Car("Tesla", "Model 3", 2024);
        
        // Display car details
        System.out.println("First Car:");
        car1.displayDetails();
        
        System.out.println("\nSecond Car:");
        car2.displayDetails();
        
        System.out.println("\nThird Car:");
        car3.displayDetails();
    }
}
