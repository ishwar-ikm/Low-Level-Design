# Chain of Responsibility Log Processor

This project demonstrates the **Chain of Responsibility** behavioral design pattern by implementing a **log processing system**. The system processes logs of different severity levels (`INFO`, `DEBUG`, `ERROR`) in a chain-like structure, where each log processor handles its specific level of logs and forwards others down the chain.

## Overview

The system processes logs in a hierarchical manner. Each log level (INFO, DEBUG, ERROR) is handled by a dedicated log processor. If a processor cannot handle a log, it passes it to the next processor in the chain.

### Key Components

1. **Logprocessor (Abstract Class)**  
   - Represents the base log processor.  
   - Holds a reference to the next processor in the chain.  
   - Defines a `log()` method to be implemented by subclasses.

2. **Concrete Processors**  
   - `InfoLogProcessor`: Handles `INFO` level logs.  
   - `DebugLogProcessor`: Handles `DEBUG` level logs.  
   - `ErrorLogProcessor`: Handles `ERROR` level logs.  

3. **Main Class**  
   - Creates the chain of log processors (`Info -> Debug -> Error`) and simulates log processing for different levels.

### Workflow

1. The `Main` class initializes the chain of log processors.  
   - **Order**: `InfoLogProcessor -> DebugLogProcessor -> ErrorLogProcessor`.  
2. Logs are sent to the first processor.  
3. Each processor checks whether it can handle the log based on its severity level.  
   - If it can handle the log, it processes it.  
   - Otherwise, it forwards the log to the next processor in the chain.  
4. The chain continues until the log is processed.

### Example Output

```text
ERROR: exception happens
DEBUG: need to debug this
INFO: just for info
```

In the above example:  
1. `ERROR: exception happens` is handled by the `ErrorLogProcessor`.  
2. `DEBUG: need to debug this` is handled by the `DebugLogProcessor`.  
3. `INFO: just for info` is handled by the `InfoLogProcessor`.

---

### How to Run

1. Compile all `.java` files:
   ```bash
   javac Design_Patterns/Behavioral_Design_Pattern/Chain_Of_Responsibility/*.java
   ```

2. Run the `Main` class:
   ```bash
   java Design_Patterns.Behavioral_Design_Pattern.Chain_Of_Responsibility.Main
   ```

---

### Flowchart

```
Start
  |
  v
Initialize Log Processors:
  InfoLogProcessor -> DebugLogProcessor -> ErrorLogProcessor
  |
  |--- Send log message to InfoLogProcessor
        |
        |--- Can InfoLogProcessor handle it?
               |--- Yes? Process log
               |--- No? Forward to DebugLogProcessor
                      |
                      |--- Can DebugLogProcessor handle it?
                             |--- Yes? Process log
                             |--- No? Forward to ErrorLogProcessor
                                    |
                                    |--- Can ErrorLogProcessor handle it?
                                           |--- Yes? Process log
                                           |--- No? End of chain
  |
End
```

---

### Design Pattern Used: Chain of Responsibility

The **Chain of Responsibility** pattern allows a request (log) to be passed through a chain of handlers (processors). Each handler processes the request if it can, or forwards it to the next handler in the chain. This promotes **loose coupling** and **scalability** in the system.
