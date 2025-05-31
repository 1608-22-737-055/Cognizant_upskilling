
// TypeCastingExample 


public class Ex7 {
        public static void main(String[] args) {
            double doubleValue = 9.78;
            int intValue = (int) doubleValue; // Explicit casting: double to int
    
            int anotherInt = 100;
            double anotherDouble = anotherInt; // Implicit casting: int to double
    
            System.out.println("Double value: " + doubleValue);
            System.out.println("After casting to int: " + intValue);
            System.out.println("Integer value: " + anotherInt);
            System.out.println("After casting to double: " + anotherDouble);
        }
    
        
}
