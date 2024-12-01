# Factory Design Pattern Example in Java

This project demonstrates the **Factory Design Pattern**, a creational design pattern used to create objects without exposing the creation logic to the client. It allows a class to delegate the responsibility of instantiating objects to a factory class.

## Overview

The example simulates a shape creation system where a `ShapeFactory` produces objects of specific types (`Circle` or `Rectangle`) based on input parameters.

### Key Components

1. **`Shape` Interface**  
   Defines a common interface (`draw()`) that all shapes implement.

2. **Concrete Shape Implementations**  
   - `Rectangle`: Implements the `Shape` interface and provides a `draw()` method for rectangles.  
   - `Circle`: Implements the `Shape` interface and provides a `draw()` method for circles.

3. **`ShapeFactory` Class**  
   Contains the `getShape(String input)` method to create objects of `Circle` or `Rectangle` based on the input string.

4. **`MainClass`**  
   Demonstrates the pattern by creating shapes through the factory and invoking their `draw()` methods.

### Example Output

```text
Draw rectangle
Draw Circle
```

---

### Flowchart

```
Start
  |
  v
ShapeFactory (Class)
  |
  |--- Receives input ---> "RECTANGLE" or "CIRCLE"
  |
  |--- Creates and returns ---> Rectangle or Circle object
  |
  v
Concrete Shape Classes
  |--- Rectangle ---> Implements Shape Interface ---> Provides draw()
  |
  |--- Circle ---> Implements Shape Interface ---> Provides draw()
  |
  v
MainClass
  |
  |--- Uses ShapeFactory to create ---> Shape objects
  |
  |--- Calls draw() method on ---> Shape objects
  |
  v
End
```

---

This implementation provides a clear and flexible way to create objects, adhering to the Factory Design Pattern principles. Let me know if you’d like further refinements!