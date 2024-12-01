# Decorator Design Pattern Example - Pizza Customization

This project demonstrates the **Decorator Design Pattern**, a structural design pattern that allows dynamic addition of functionality to objects without altering their structure.

## Overview

The example simulates a pizza shop where customers can customize their pizza by adding toppings like cheese and mushrooms. Each topping dynamically modifies the base pizza's cost.

### Key Components

1. **Abstract Class (`BasePizza`)**  
   Defines the structure of a pizza with a method to calculate its cost.

2. **Concrete Pizza Classes**  
   - `Margherita`: A basic pizza costing 100.  
   - `Farmhouse`: A deluxe pizza costing 200.  
   - `VegDelight`: A veggie pizza costing 120.

3. **Decorator Class (`ToppingsDecorator`)**  
   Abstract class for adding toppings to the base pizza.

4. **Concrete Decorators**  
   - `ExtraCheese`: Adds cheese topping, costing an additional 15.  
   - `Mushroom`: Adds mushroom topping, costing an additional 10.

5. **PizzaShop Class (Main)**  
   Demonstrates the pattern by building customized pizzas and calculating their costs.

### Example Output

```text
Cost of margherita pizza with extra cheese is 115
Cost of veggie pizza with extra mushroom and cheese is 225
```

---

### Flowchart

```
Start
  |
  v
BasePizza (Abstract Class)
  |--- Extended by ---> Margherita (Concrete Class)
  |                     Farmhouse (Concrete Class)
  |                     VegDelight (Concrete Class)
  |
  |--- Decorated by ---> ToppingsDecorator (Abstract Class)
        |
        |--- Extended by ---> ExtraCheese (Concrete Decorator)
        |                    |
        |                    |--- Modifies ---> BasePizza cost + 15
        |
        |--- Extended by ---> Mushroom (Concrete Decorator)
                             |
                             |--- Modifies ---> BasePizza cost + 10
  |
  v
PizzaShop (Main Class)
  |
  |--- Builds customized pizzas using ---> BasePizza and Decorators
  |
  |--- Calculates and prints final cost
  |
  v
End
```

---

This example showcases how the **Decorator Design Pattern** simplifies adding dynamic functionalities to objects without modifying their existing code structure. Let me know if you need further help!