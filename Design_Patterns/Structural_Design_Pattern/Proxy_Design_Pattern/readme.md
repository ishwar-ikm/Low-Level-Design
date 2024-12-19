# Proxy Design Pattern

This project demonstrates the **Proxy Design Pattern** through an implementation that provides controlled access to an employee database. The Proxy Design Pattern is part of the Structural Design Patterns category, providing a surrogate or placeholder object to control access to another object.

## Overview of Proxy Design Pattern

The Proxy Design Pattern involves a proxy class that acts as an interface to the real object. Proxies are often used to implement functionalities such as access control, lazy initialization, logging, or caching.

### Use Cases
1. **Access Control**: Grant or restrict access to certain operations based on conditions.
2. **Performance Optimization**: Lazy initialization or caching.
3. **Security**: Protect sensitive operations from unauthorized access.

---

## Implementation Details

### Components

1. **Interface** (`EmployeeDao`)  
   - Defines the operations that can be performed on the employee database, such as `create`, `delete`, and `get`.

2. **Real Object** (`EmployeeDaoImpl`)  
   - Implements the interface and contains the actual logic for database operations.

3. **Proxy Object** (`EmployeeDaoProxy`)  
   - Controls access to the real object based on the client's role (`ADMIN` or `USER`).

4. **Main Class** (`ProxyDesignPattern`)  
   - Demonstrates the usage of the proxy object to perform operations.

---

## Features

1. **Role-Based Access Control**  
   - Only `ADMIN` users can create or delete employees.  
   - Both `ADMIN` and `USER` roles can retrieve employee data.  

2. **Exception Handling**  
   - Unauthorized operations result in exceptions.

---

### How to Run

1. Compile all `.java` files:
   ```bash
   javac Design_Patterns/Structural_Design_Pattern/Proxy_Design_Pattern/**/*.java
   ```

2. Run the `ProxyDesignPattern` class:
   ```bash
   java Design_Patterns.Structural_Design_Pattern.Proxy_Design_Pattern.ProxyDesignPattern
   ```

---

### Example Output

```text
Create Employee
Operation successful
```

If unauthorized:
```text
Not Authorized
```

---

### Flowchart

```
Start
  |
  v
Request operation on EmployeeDaoProxy
  |
  |--- Validate client role
         |--- Unauthorized? --> Throw Exception
  |
  |--- Authorized? --> Forward request to EmployeeDaoImpl
  |
Perform operation (create/delete/get)
  |
End
```

---

## Advantages of the Proxy Design Pattern

1. **Encapsulation**: Adds a layer of abstraction between the client and the real object.
2. **Access Control**: Ensures secure and role-based interaction.
3. **Scalability**: Easy to extend for additional access control or logging features.
