# Builder Pattern Example

This project demonstrates the **Builder Design Pattern**, which is a creational design pattern used to construct complex objects step by step. The example here models the creation of a `Car` object with various customizable attributes.

## Files

- **Main.java**: Contains the `main` method to demonstrate the usage of the `Car` class and its builder methods.
- **Car.java**: Defines the `Car` class with builder-style methods for setting its attributes.

## How It Works

1. The `Car` class provides a fluent interface with methods like `setEngine`, `setWheels`, `setSeats`, etc., to configure the car's attributes.
2. Each setter method returns the `Car` object itself, enabling method chaining.
3. The `Main` class demonstrates how to create `Car` objects with different configurations using the builder-style methods.

## Example Output

When you run the `Main` class, you will see the following output:

```
Car: Car{engine='V8', wheels=4, seats=5, color='Red', sunroof=true, navigationSystem=true}
Car 2: Car{engine='V6', wheels=4, seats=5, color='null', sunroof=false, navigationSystem=false}
```

## Advantages of the Builder Pattern

- Simplifies the creation of complex objects.
- Improves code readability and maintainability.
- Allows for the creation of immutable objects if needed.

## How to Run

1. Compile the project:
   ```bash
   javac -d . e:\ikm\LLD\design_patterns\creational_design_patterns\builder_pattern\good_code\*.java
   ```
2. Run the `Main` class:
   ```bash
   java design_patterns.creational_design_patterns.builder_pattern.good_code.Main
   ```

## Key Concepts

- **Fluent Interface**: The `Car` class uses a fluent interface to allow method chaining.
- **Immutability**: Although not implemented here, the builder pattern can be extended to create immutable objects.

This example provides a simple yet effective demonstration of the Builder Pattern in Java.
