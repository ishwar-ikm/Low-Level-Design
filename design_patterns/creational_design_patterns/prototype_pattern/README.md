**Prototype Pattern (Creational)**

- **Summary:** The Prototype pattern creates new objects by copying an existing object (the prototype) rather than creating them from scratch. This avoids the cost of expensive object initialization and provides a flexible way to create object variants.

**Problem & Motivation:**
- **Problem:** Creating new objects can be costly in terms of computation, resources, or complexity - especially if they involve expensive initialization, database queries, or complex state setup. Additionally, you may need multiple similar variations of an object with different configurations.
- **Motivation:** Use Prototype when creating objects is expensive or when you want to hide the concrete classes from the client. Clone an existing prototype to quickly create new instances with minimal overhead.

**When to use:**
- Object creation is computationally expensive or resource-intensive.
- You need to create multiple variants of similar objects.
- You want to defer or avoid the details of complex object construction.
- Runtime decisions determine which object type to clone.

**Trade-offs / Drawbacks:**
- **Shallow vs. Deep copy:** Cloning may create shallow copies, leading to unexpected sharing of mutable field references between original and clone.
- **Complexity:** Implementing proper cloning (especially deep copy) can add complexity.
- **Performance:** For simple objects, cloning may be slower than direct construction.
- **Serialization:** Objects must support cloning (implement `Cloneable` in Java), which adds constraints.

**What this folder demonstrates**
- `bad_code/` — naive approach with repeated constructor calls to create variants. Shows the inefficiency and lack of reusability when objects are complex or expensive to create.
- `good_code/` — proper Prototype implementation using `Cloneable` interface and `clone()` method. Demonstrates how to efficiently create copies and reuse pre-configured prototypes.

**Java-specific implementations & notes**
- **Cloneable interface:** A marker interface indicating that a class supports cloning. Does not define `clone()` — you override the protected `clone()` method from `Object`.
- **Shallow copy:** The default `super.clone()` performs a shallow copy, sufficient for immutable fields or primitive types but problematic for mutable object references.
- **Deep copy:** Manually copy nested mutable objects within the overridden `clone()` method to ensure independence between original and clone.
- **CloneNotSupportedException:** Thrown if cloning is attempted on a class that does not implement `Cloneable`.
- **Registry pattern:** Often paired with Prototype—maintain a registry/map of named prototypes so clients can request a clone by name rather than hardcoding class instantiation.

**Simple usage example**
```java
// Clone an existing prototype
Character warrior = new Character("Warrior", 100, 50, 5);
Character clonedWarrior = (Character) warrior.clone();  // fast copy
clonedWarrior.setName("Warrior Clone");  // customize the clone

// Use a factory with registered prototypes
CharacterFactory factory = new CharacterFactory();
factory.registerPrototype("warrior", warriors);
Character newWarrior = factory.createCharacter("warrior");  // clone from registry
```

**How to run the examples (Java)**
1. Open a terminal in this workspace root.
2. To run the bad example:
   - `cd design_patterns/creational_design_patterns/prototype_pattern/bad_code`
   - `javac -d . *.java`
   - `java design_patterns.creational_design_patterns.prototype_pattern.bad_code.CharacterFactory`
3. To run the good example:
   - `cd ..\good_code`
   - `javac -d . *.java`
   - `java design_patterns.creational_design_patterns.prototype_pattern.good_code.CharacterFactory`

Note: adjust `cd` paths if you run commands from a different working directory. Ensure `javac`/`java` are on your `PATH`.

**Quick checklist when implementing Prototype in Java**
- Implement `Cloneable` interface on classes that should be cloneable.
- Override the `clone()` method and change its access modifier to `public`.
- Use `super.clone()` for shallow copy or implement deep copy logic if needed.
- Handle or throw `CloneNotSupportedException` appropriately.
- Consider implementing a prototype registry for convenient access to pre-configured prototypes.
- Validate that cloned objects are truly independent (test mutation of mutable fields).

**Further reading**
- Design Patterns: Elements of Reusable Object-Oriented Software (Gang of Four) — Prototype chapter.
- Effective Java (Joshua Bloch) — recommendations on cloning and copy constructors.
