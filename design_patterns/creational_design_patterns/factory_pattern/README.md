# Factory Pattern

The Factory Pattern is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.

## Advantages of the Factory Pattern

- **Adheres to the Open/Closed Principle**: New types of objects can be added without modifying existing code.
- **Encapsulation**: The object creation logic is centralized in the factory, making the code easier to maintain.
- **Flexibility**: The client code is decoupled from the specific classes it uses, allowing for easier changes and extensions.

## Bad Code Example

In this example, we have a `Vehicle` class with subclasses `Car`, `Truck`, and `Bike`. The `main` method creates a `Vehicle` object based on user input, which is an example of the Factory Method pattern. However, this implementation is not ideal because:

1. It violates the Open/Closed Principle, as any new type of vehicle would require modifying the `main` method.
2. The object creation logic is scattered, making the code harder to maintain.

```java
package design_patterns.creational_design_patterns.factory_pattern.bad_code;

import design_patterns.creational_design_patterns.factory_pattern.bad_code.VehicleImpl.Bike;
import design_patterns.creational_design_patterns.factory_pattern.bad_code.VehicleImpl.Car;
import design_patterns.creational_design_patterns.factory_pattern.bad_code.VehicleImpl.Truck;

public class Main {
    public static void main(String[] args) {
        String vehcleType = "Car"; // This could come from user input or configuration

        Vehicle vehicle;
        if (vehcleType.equals("Car")) {
            vehicle = new Car();
        } else if (vehcleType.equals("Truck")) {
            vehicle = new Truck();
        } else if (vehcleType.equals("Bike")) {
            vehicle = new Bike();
        } else {
            throw new IllegalArgumentException("Invalid vehicle type: " + vehcleType);
        }

        vehicle.start();
        vehicle.stop();
    }
}
```

## Good Code Example

In this example, we have a `Vehicle` class with subclasses `Car`, `Truck`, and `Bike`. The `VehicleFactory` class provides a static method `createVehicle` that creates a `Vehicle` object based on the type parameter. This implementation follows the Factory Pattern and adheres to the Open/Closed Principle because:

1. New types of vehicles can be added without modifying the `VehicleFactory` class.
2. The object creation logic is centralized in the factory, making the code cleaner and more maintainable.

```java
package design_patterns.creational_design_patterns.factory_pattern.good_code;

import design_patterns.creational_design_patterns.factory_pattern.good_code.VehicleImpl.Bike;
import design_patterns.creational_design_patterns.factory_pattern.good_code.VehicleImpl.Car;
import design_patterns.creational_design_patterns.factory_pattern.good_code.VehicleImpl.Truck;

public class VehicleFactory {
    public static Vehicle createVehicle(String type) {
        switch (type.toLowerCase()) {
            case "car":
                return new Car();
            case "truck":
                return new Truck();
            case "bike":
                return new Bike();
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle;
        vehicle = VehicleFactory.createVehicle("car");
        vehicle.start();
        vehicle.stop();

        vehicle = VehicleFactory.createVehicle("truck");
        vehicle.start();
        vehicle.stop();
    }
}
```

