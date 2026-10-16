class Vehicle {
    Vehicle() { System.out.println("1. Vehicle constructor"); }
}

class Car extends Vehicle {
    Car() {                                   // implicit super() inserted here
        System.out.println("2. Car constructor");
    }
}

class ElectricCar extends Car {
    ElectricCar() {                           // implicit super() inserted here
        System.out.println("3. ElectricCar constructor");
    }
}

public class VehicleChain {
    public static void main(String[] args) {
        new ElectricCar();
    }
}
