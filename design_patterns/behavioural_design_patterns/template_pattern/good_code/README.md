# Template Method Pattern

The **Template Method** is a behavioural design pattern that defines the skeleton
of an algorithm in a base class and lets subclasses override specific steps without
changing the overall structure. The pattern is useful when multiple classes share the
same workflow but differ in certain details.

## 🔧 How It Works

- A **template method** in an abstract base class outlines the sequence of steps for
  an algorithm.
- Some steps are implemented in the base class (common functionality), while others
  are declared as abstract methods.
- **Concrete subclasses** implement or override the abstract (and optionally hook)
  methods to provide state-specific behaviour.
- The base class may also provide "hooks"—optional methods that subclasses can
  override to inject additional behaviour.

## 📁 Project Structure

```
template_pattern/
├── bad_code/                     # procedural example with duplicated logic
│   ├── Main.java
│   └── concrete_beverages/
│       ├── Coffee.java
│       └── Tea.java
└── good_code/                    # proper Template Method implementation
    ├── Beverage.java             # abstract base with template method
    ├── Main.java                 # driver program
    ├── README.md                 # this document
    └── concrete_beverages/       # subclasses implementing steps
        ├── Coffee.java
        └── Tea.java
```

## 🧩 Example Explanation

### 🍺 Base Class (`Beverage`)
Defines the template method `prepareRecipe()` that calls a series of steps such as
`boilWater()`, `brew()`, `pourInCup()`, and `addCondiments()`. Concrete classes
implement `brew()` and `addCondiments()` according to the drink being prepared.

### ☕ Concrete Subclasses
`Coffee` and `Tea` classes extend `Beverage` and provide their own versions of the
recipe steps. They call `prepareRecipe()` inherited from `Beverage` without altering
its structure.

### 🚫 Bad Code Comparison
The `bad_code` directory shows a procedural approach where `Main.java` duplicates
logic for tea and coffee and mixes all steps with conditionals. Adding a new beverage
requires editing that central method.

## ✅ Benefits

- **Code reuse**: Shared algorithm steps are implemented only once in the base class.
- **Flexibility**: Subclasses can override just the parts they need to change.
- **Maintenance**: Algorithm structure is centralized, making changes easier.
- **Open/Closed Principle**: Add new variants by creating new subclasses without
  modifying existing code.

## 📌 When to Use

- When you have several related classes sharing the same algorithm structure.
- When subclasses should only override specific steps, not the entire algorithm.
- When you want to control the algorithm flow while allowing customization.

## 🎯 Real-World Examples

- Rendering operations (setup, draw, teardown).
- Data processing pipelines (validate, transform, save).
- Game loops with common stages and game-specific behaviour.

---

Explore `good_code` to see how the template method keeps the recipe logic clean and
extensible.