// Base Class
class Vehicle {
    protected String brand;
    protected String model;
    protected double price;

    public Vehicle(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    // Method to be overridden
    public void startEngine() {
        System.out.println("Vehicle engine starting...");
    }

    public void displayInfo() {
        System.out.println("Brand: " + brand + " | Model: " + model + " | Price: $" + price);
    }
}

// Subclass 1: Car
class Car extends Vehicle {
    private int doors;

    public Car(String brand, String model, double price, int doors) {
        super(brand, model, price);
        this.doors = doors;
    }

    // Method Overriding (Polymorphism)
    @Override
    public void startEngine() {
        System.out.println("🚗 " + brand + " " + model + " car engine roars with push-button start!");
    }
}

// Subclass 2: Bike
class Bike extends Vehicle {
    private boolean hasSelfStart;

    public Bike(String brand, String model, double price, boolean hasSelfStart) {
        super(brand, model, price);
        this.hasSelfStart = hasSelfStart;
    }

    // Method Overriding (Polymorphism)
    @Override
    public void startEngine() {
        if (hasSelfStart) {
            System.out.println("🏍️ " + brand + " " + model + " bike starts smoothly with self-start button.");
        } else {
            System.out.println("🏍️ " + brand + " " + model + " bike starts with kick start!");
        }
    }
}

// Test Class
public class VehicleTest {
    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("    VEHICLE INHERITANCE & POLYMORPHISM");
        System.out.println("====================================\n");

        // Polymorphic Object Instantiation
        Vehicle myCar = new Car("Tesla", "Model 3", 45000.0, 4);
        Vehicle myBike = new Bike("Yamaha", "MT-15", 3500.0, true);

        myCar.displayInfo();
        myCar.startEngine();

        System.out.println();

        myBike.displayInfo();
        myBike.startEngine();
    }
}