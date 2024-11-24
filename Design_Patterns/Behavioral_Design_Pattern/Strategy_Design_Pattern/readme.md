# Strategy Design Pattern Example in Java

These code files demonstrates the **Strategy Design Pattern**, a behavioral design pattern that allows you to define multiple algorithms (strategies) and switch between them dynamically without modifying the client code.

## Overview

The example simulates different types of vehicles, each with its own driving behavior. The driving behavior is encapsulated in separate strategy classes, allowing easy modification or extension without altering the `Vehicle` class.

### Key Components

1. **Strategy Interface (`DriveStrategy`)**:  
   Defines the driving behavior that all strategies must implement.

2. **Concrete Strategies**:  
   - `NormalDriveStrategy`: Represents normal driving.  
   - `SportsDriveStrategy`: Represents sports driving.

3. **Vehicle Class**:  
   A base class that uses a `DriveStrategy` to define its driving behavior.

4. **Specific Vehicles**:  
   - `SportsVehicle`: Uses `SportsDriveStrategy`.  
   - `GoodsVehicle`: Uses `NormalDriveStrategy`.  

5. **Main Class**:  
   Demonstrates how different vehicles use different driving strategies.

### Example Output

```text
Sports Drive
Normal Drive
```

### Flowchart

```
Start
  |
  v
Vehicle Class
  |--- Has a ---> DriveStrategy Interface
  |                   |
  |                   |--- Implemented by ---> NormalDriveStrategy (Concrete Strategy)
  |                   |
  |                   |--- Implemented by ---> SportsDriveStrategy (Concrete Strategy)
  |
  |--- Extended by ---> SportsVehicle (Uses SportsDriveStrategy)
  |
  |--- Extended by ---> GoodsVehicle (Uses NormalDriveStrategy)
  |
  |--- Extended by ---> OffRoadVehicle (Can use SportsDriveStrategy or others)
  |
  v
Main Class
  |
  |--- Creates an instance of ---> SportsVehicle
  |         |
  |         |--- Delegates driving to ---> SportsDriveStrategy
  |
  |--- Creates an instance of ---> GoodsVehicle
            |
            |--- Delegates driving to ---> NormalDriveStrategy
  |
  v
End
```

---

This demonstrates how the Strategy Design Pattern enables flexibility and modularity in defining and using algorithms.