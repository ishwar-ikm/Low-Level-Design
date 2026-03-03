# State Pattern

The **State Pattern** is a behavioural design pattern that allows an object to change
its behaviour when its internal state changes. This pattern is especially useful when
an object must exhibit different behaviors depending on its current state, and the logic
for those behaviors is encapsulated in separate state classes.

## 🧠 Concept

- The pattern defines a **context** class that maintains a reference to a state object
  representing the current state.
- **State** is an interface or abstract class that declares methods common to all possible
  states.
- **Concrete state classes** implement the state interface and provide behaviour for each
  specific state.
- Instead of a large conditional block (e.g. `switch` or `if-else`) inside the context,
  the context delegates requests to the current state object, which may update the context's
  state reference to transition to another state.

This makes the code easier to extend and maintain. Adding a new state requires creating a
new concrete state class without modifying the existing context or other states.

## 📁 Project Structure

```
state_pattern/
├── README.md               # This document
├── bad_code/               # Example with tight coupling / conditional logic
│   ├── Main.java
│   └── TrafficLight.java
└── good_code/              # Proper State pattern implementation
    ├── Main.java
    ├── TrafficLightContext.java  # Context class
    ├── TrafficLightState.java    # State interface
    └── concete_state_classes/    # Concrete states
        ├── GreenLightState.java
        ├── RedLightState.java
        └── YellowLightState.java
```

## 🔧 Implementation Details

### 🔹 Context (`TrafficLightContext`)
Holds a reference to the current state and exposes a method (e.g. `changeLight()`)
that delegates behaviour to the active state. States can call back to the context to
change the current state when a transition occurs.

### 🔹 State Interface (`TrafficLightState`)
Defines behaviour that all concrete states must provide. For a traffic light example,
this might include a method like `changeLight(TrafficLightContext context)`.

### 🔹 Concrete States
Each class implements `TrafficLightState` and encapsulates the behaviour of a single
state (red, yellow, green). They may also decide which state comes next by invoking
`context.setState(new NextState())`.

### ⛔ Bad Example
Located in `bad_code/`, it usually contains a `TrafficLight` class with an internal
`int` or `enum` state and a `switch` statement to decide what to do. This leads to
code that is hard to maintain and extend with new states.

### ✅ Good Example
Found under `good_code/` demonstrates the proper pattern usage: the traffic light
behaviour is distributed across three concrete state classes, and `TrafficLightContext`
simply forwards requests.

### 🔄 Extending with a New State
- **Bad code**: introducing a fourth state means adding a new enum value or integer
  constant and then finding and modifying every `switch`/`if` block in `TrafficLight.java`.
  Each such change risks breaking existing logic and makes the class grow with more
  conditional branches. You may also need to update other clients that inspect the state
  value, so the change ripples through the codebase.
- **Good code**: to add a new state you simply implement another class that conforms to
  `TrafficLightState` (e.g. `BlinkingState`) and update the transition logic in one of the
  existing state classes or the context. No existing classes need modification, and the new
  behaviour is completely encapsulated. This illustrates the Open/Closed principle in action.


## ✨ Benefits

- **Open/Closed Principle**: Add new states without modifying existing ones.
- **Cleaner Code**: Remove complex conditional logic from the context.
- **Flexibility**: States can be changed at runtime.
- **Encapsulation**: State-specific logic is localized.

## 📝 When to Use

- When an object must change behaviour based on internal state.
- When operations have large `switch`/`if-else` statements depending on state.
- When transitions between states are complex and should be centralized.

## 🚦 Real-World Examples
- Traffic light controllers
- Media players (playing, paused, stopped states)
- TCP connection states (established, listening, closed)
- Document workflow (draft, review, approved, rejected)
