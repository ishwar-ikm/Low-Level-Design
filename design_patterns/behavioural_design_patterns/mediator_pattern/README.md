# Mediator Pattern (Behavioural)

- **Summary:** The Mediator pattern defines an object that encapsulates how a set of objects interact with each other. It promotes loose coupling by keeping objects from referring to each other explicitly and lets you vary their interaction independently.

## Problem & Motivation

**Problem:** In systems with multiple interacting objects, direct communication between them creates a complex web of dependencies. Each object needs to know about others, understand their interfaces, and handle interactions. This leads to:

* Tight coupling between objects
* Difficult to reuse objects in different contexts
* Hard to modify interaction logic without touching multiple classes
* Complex and brittle code

**Example:** In an auction system without a mediator:
- Bidders communicate directly with each other
- Each bidder knows about other bidders and the auction rules
- Adding a new bidder type or changing auction rules requires updating multiple classes
- Bidders are interdependent and cannot be reused elsewhere

**Motivation:** Use the Mediator pattern when:
- Objects communicate in complex but well-defined ways
- Reusing objects is difficult because they reference many other objects
- Behavior distributed between classes should be customizable without subclassing
- You want to centralize control logic and make it easier to modify

## When to Use

- Chat applications (users communicate through a chat room mediator)
- Air traffic control systems (controllers mediate between aircraft)
- GUI dialog boxes (dialog box mediates between form controls)
- Auction or bidding systems (auction house mediates between bidders)
- MVC architectures (controller acts as mediator between model and view)
- Game engines (game manager mediates between game objects)

## Trade-offs / Drawbacks

* **Mediator complexity:** The mediator object itself can become large and complex (the "God Object" anti-pattern)
* **Single point of failure:** If the mediator fails, the entire interaction fails
* **Hidden dependencies:** Interaction logic is centralized, so it's not obvious what objects do by looking at them
* **Performance:** All communication goes through the mediator, creating a potential bottleneck
* **Testing complexity:** You must test the mediator with all interacting objects

## This Folder Demonstrates

### Bad Code

`bad_code/Bidder.java` shows direct communication between bidders:

```java
public class Bidder {
    private String name;
    private List<Bidder> otherBidders;  // knows about other bidders!
    
    public void placeBid(double amount) {
        // directly communicate with others
        for (Bidder bidder : otherBidders) {
            bidder.notifyBidPlaced(this.name, amount);
        }
    }
    
    public void notifyBidPlaced(String bidderName, double amount) {
        System.out.println(name + " received bid notification");
    }
}
```

**Problems:**
- Each bidder must maintain a list of other bidders
- Bidders are tightly coupled to each other
- Auction rules are scattered across bidder implementations
- Cannot reuse bidders in a different auction context
- Scaling (adding many bidders) becomes unwieldy
- Auction logic (highest bid wins, notifications, validation) is not centralized

### Good Code

A `AuctionMediator` interface in `good_code/AuctionMediator.java` defines the contract:

```java
public interface AuctionMediator {
    void placeBid(Bidder bidder, double amount);
    void registerBidder(Bidder bidder);
    void relayBidNotification(String message);
}
```

The concrete mediator `AuctionHouse.java` implements the interaction logic:

```java
public class AuctionHouse implements AuctionMediator {
    private List<Bidder> bidders = new ArrayList<>();
    private double currentHighestBid = 0;
    private String currentHighestBidder = null;
    
    @Override
    public void placeBid(Bidder bidder, double amount) {
        if (amount > currentHighestBid) {
            currentHighestBid = amount;
            currentHighestBidder = bidder.getName();
            relayBidNotification(bidder.getName() + " placed bid of $" + amount);
        } else {
            relayBidNotification("Bid rejected: amount too low");
        }
    }
    
    @Override
    public void relayBidNotification(String message) {
        for (Bidder bidder : bidders) {
            bidder.receive(message);
        }
    }
}
```

The `Bidder` class in `good_code/core_classes/Bidder.java` is now simple and decoupled:

```java
public class Bidder {
    private String name;
    private AuctionMediator mediator;
    
    public void placeBid(double amount) {
        mediator.placeBid(this, amount);  // delegate to mediator
    }
    
    public void receive(String message) {
        System.out.println(name + ": " + message);
    }
}
```

**Benefits:**
- Bidders only know about the mediator, not about each other
- Auction rules are centralized in `AuctionHouse`
- Easy to add new bidders without modifying existing ones
- Easy to change auction rules by modifying only the mediator
- Bidders can be reused in different auction contexts
- Clear separation of concerns

## Key Differences: Bad vs Good Practice

| Aspect | Bad Practice | Good Practice |
|--------|--------------|---------------|
| **Coupling** | Objects reference each other directly | Objects reference only the mediator |
| **Interaction logic** | Scattered across multiple objects | Centralized in mediator |
| **Extensibility** | Adding new objects requires updating many classes | Add new objects without changing others |
| **Reusability** | Objects tied to specific interactions | Objects reusable in different contexts |
| **Maintainability** | Changes to interaction logic affect multiple classes | Changes isolated to mediator |
| **Testability** | Hard to test in isolation | Easy to test with mock mediator |
| **Complexity** | Complex inter-object relationships | Complex mediator, but objects are simple |

## Usage Example

```java
// Create the mediator
AuctionHouse auctionHouse = new AuctionHouse();

// Create bidders
Bidder alice = new Bidder("Alice", auctionHouse);
Bidder bob = new Bidder("Bob", auctionHouse);
Bidder charlie = new Bidder("Charlie", auctionHouse);

// Register bidders
auctionHouse.registerBidder(alice);
auctionHouse.registerBidder(bob);
auctionHouse.registerBidder(charlie);

// Place bids through mediator
alice.placeBid(100);      // Alice: highest bidder
bob.placeBid(150);        // Bob: new highest bidder
charlie.placeBid(120);    // Charlie: bid rejected (too low)
alice.placeBid(200);      // Alice: new highest bidder

// Output:
// Alice: Bid placed: $100
// Bob: Bob placed bid of $150
// Charlie: Bob placed bid of $150
// Alice: Bob placed bid of $150
// ...etc...
```

## How to Run the Examples

1. Open a terminal in the workspace root.

2. Bad example:

   ```bash
   cd design_patterns/behavioural_design_patterns/mediator_pattern/bad_code
   javac *.java
   java design_patterns.behavioural_design_patterns.mediator_pattern.bad_code.Main
   ```

3. Good example:

   ```bash
   cd ../good_code
   javac -d . *.java core_classes/*.java
   java design_patterns.behavioural_design_patterns.mediator_pattern.good_code.Main
   ```


## Real-World Examples

- **Chat Applications:** ChatRoom mediates messages between User objects
- **GUI Dialogs:** Dialog box mediates between form controls (buttons, fields, etc.)
- **Air Traffic Control:** Controller mediates between aircraft to prevent collisions
- **Game Engines:** Game manager mediates between game objects (physics, collisions, etc.)
- **Spring Framework:** Dispatcher servlet acts as mediator between requests and handlers
- **MVC Architecture:** Controller mediates between Model and View
- **Event-Driven Systems:** Event bus/dispatcher acts as mediator between event producers and consumers

## Mediator vs Observer Pattern

| Aspect | Mediator | Observer |
|--------|----------|----------|
| **Intent** | Encapsulate interaction logic | Notify multiple objects of state change |
| **Coupling** | Objects → Mediator | Subject → Observers (loosely) |
| **One-to-many** | One mediator with many colleagues | One subject with many observers |
| **Used for** | Complex inter-object communication | Broadcasting state changes |
| **Complexity** | Mediator becomes complex | Observers remain simple |
