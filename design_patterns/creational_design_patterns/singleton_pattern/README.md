
**Singleton Pattern (Creational)**

- **Summary:** The Singleton pattern ensures a class has only one instance and provides a global point of access to it.

**Problem & Motivation:**
- **Problem:** Some resources should have a single shared instance across an application (for example: a logger, configuration manager, or connection-pool controller). Uncontrolled creation of multiple instances can cause inconsistent state, wasted resources, or expensive setup.
- **Motivation:** Use Singleton when exactly one instance is required and that instance should be globally accessible.

**When to use:**
- Shared system-wide resources (logging, caches, configuration, thread pools).
- When you need a single point of coordination or a single factory/service instance.

**Trade-offs / Drawbacks:**
- Global state: Singletons are effectively global variables and can make testing and reasoning harder.
- Lifetime management: Singletons may live for the entire application lifetime, potentially holding resources longer than needed.
- Concurrency: naive implementations can be unsafe in multi-threaded environments.

**What this folder demonstrates**
- `bad_code/` — examples that do not implement a true singleton (constructors public, multiple instances created). Use this to see common mistakes.
- `good_code/` — a cleaner Java Singleton implementation (private constructor, `getInstance()` access) showing a correct basic approach.
- `good_code/Thread_Safe_Logger/` — a thread-safe lazy-initialization variant demonstrating the patterns used to make singletons safe in multi-threaded contexts.

**Java-specific implementations & notes**
- Eager initialization: create the instance when the class is loaded. Simple and thread-safe, but may instantiate early even when unused.
- Lazy initialization with synchronization: delay creation until first access. Use `synchronized` to make it thread-safe but beware of synchronization cost.
- Double-checked locking (DCL): use `volatile` for the instance field and check instance twice to avoid repeated synchronization. Correct when using `volatile` (post-Java 5 semantics).
- Enum singleton: recommended for most use-cases in Java — provides serialization safety and resists reflection attacks.
- Serialization & Reflection: Singletons can be broken by serialization (unless you implement `readResolve`) or reflection (unless protected). Consider defensive coding or enum-based singletons for robustness.

**Simple usage example**
```
// obtain and use the singleton logger
Logger logger = Logger.getInstance();
logger.log("Application started");
```

**How to run the examples (Java)**
1. Open a terminal in this workspace root.
2. To run the bad example:
	- `cd design_patterns/creational_design_patterns/singleton_pattern/bad_code`
	- `javac *.java`
	- `java Main`
3. To run the good example:
	- `cd ..\good_code`
	- `javac *.java`
	- `java Main`
4. To run the thread-safe example:
	- `cd Thread_Safe_Logger`
	- `javac *.java`
	- `java Main`

Note: adjust `cd` paths if you run commands from a different working directory. Ensure `javac`/`java` are on your `PATH`.

**Quick checklist when implementing Singletons in Java**
- Make the constructor `private`.
- Provide a single `public static` access method such as `getInstance()`.
- For lazy initialization in multi-threaded code, use proper synchronization or DCL with `volatile`.
- Consider using `enum`-based singleton for the simplest robust solution.
- Harden against serialization and reflection if necessary (`readResolve`, defensive checks).

**Further reading**
- Effective Java (Joshua Bloch) — chapter on singleton and enum singletons.

