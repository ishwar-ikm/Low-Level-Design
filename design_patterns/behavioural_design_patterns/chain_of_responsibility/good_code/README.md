# Chain of Responsibility Pattern (Behavioral)

- **Summary:** The Chain of Responsibility pattern defines a way of passing requests along a chain of handlers. Each handler decides either to process the request or to pass it along the chain to the next handler.

## Problem & Motivation

**Problem:** In real-world applications, requests often need to be processed by different handlers based on their content or parameters. For example, in a leave approval system, a team lead might approve up to 5 days of leave, a manager can approve up to 10 days, and a director can approve up to 14 days. Without a proper pattern, you would end up with hard-coded if-else conditions in a single class, making it difficult to add new approvers or modify approval rules.

**Motivation:** Use the Chain of Responsibility pattern when:
- Multiple objects may handle a request, and the handler is not known in advance
- You want to issue a request to one of several objects without specifying the receiver explicitly
- You need to submit requests to handlers in a specific order and let them decide whether to handle or forward
- You want to avoid coupling between the sender and receivers
- You frequently need to add new handlers or modify the order of handlers

## When to Use

- Leave/approval request systems (Team Lead → Manager → Director)
- Event handling systems (UI framework event bubbling)
- Logging frameworks (debug → info → warning → error → critical)
- HTTP request pipelines (middleware chains in web frameworks)
- Customer support ticket routing (tier 1 support → tier 2 → escalation team)
- ATM withdrawal limits (different daily limits based on account type)

## Trade-offs / Drawbacks

- **Unpredictable handling:** There's no guarantee that a request will be handled; it might be passed through the entire chain without being processed
- **Debugging complexity:** It can be difficult to trace which handler in the chain actually processed the request
- **Performance overhead:** Requests might traverse a long chain before being handled
- **Loop potential:** Improper chain setup could lead to infinite loops or circular chains
- **Chain configuration:** Setting up the correct order and sequence of handlers is critical and easy to get wrong

## What This Folder Demonstrates

### Bad Code Example

The [`bad_code/LeaveRequest.java`](../bad_code/LeaveRequest.java) demonstrates common mistakes:

1. **All Logic in One Place:** All approval conditions are hard-coded in a single class
2. **Hard to Extend:** Adding a new approver level (e.g., HR Manager) requires modifying the existing code
3. **Tight Coupling:** The main class is coupled to all approval logic
4. **Violates Open/Closed Principle:** Changes require modifying the existing class instead of extending it
5. **Not Scalable:** Complex nested if-else conditions become unmaintainable with more approvers

```java
// Bad: All approval logic hard-coded
if (requestedLeaveDays <= 2) {
    System.out.println("Leave approved by Team Lead");
} else if (requestedLeaveDays <= 5) {
    System.out.println("Leave approved by Manager");
} else if (requestedLeaveDays <= 10) {
    System.out.println("Leave approved by Director");
} else {
    System.out.println("Leave request denied");
}
// How do you add a new approver here? You modify existing code!
```

### Good Code Example

The good code implementation follows proper Chain of Responsibility pattern principles:

#### 1. **Handler Interface** ([`Approver.java`](Approver.java))
Defines a contract for all handlers in the chain:

```java
public abstract class Approver {
    protected Approver nextApprover;

    public void nextApprover(Approver approver) {
        this.nextApprover = approver;
    }

    public abstract void processLeaveRequest(int leaveDays);
}
```

#### 2. **Concrete Handlers** 
Each handler knows its responsibility and can pass to the next handler:

- [`TeamLead.java`](concrete_approver/TeamLead.java) - Approves leaves ≤ 5 days
- [`Manager.java`](concrete_approver/Manager.java) - Approves leaves ≤ 10 days
- [`Director.java`](concrete_approver/Director.java) - Approves leaves ≤ 14 days

```java
public class TeamLead extends Approver {
    @Override
    public void processLeaveRequest(int leaveDays) {
        if (leaveDays < 5) {
            System.out.println("Approved by team lead");
        } else if (nextApprover != null) {
            System.out.println("Team lead can not process this request sending request to next approver");
            nextApprover.processLeaveRequest(leaveDays);
        } else {
            System.out.println("Request denied");
        }
    }
}
```

#### 3. **Chain Setup** ([`Main.java`](Main.java))
Constructs and configures the chain:

```java
Approver teamLead = new TeamLead();
Approver manager = new Manager();
Approver director = new Director();

teamLead.nextApprover(manager);
manager.nextApprover(director);

teamLead.processLeaveRequest(12);  // Director will handle this
```

## 🌟 How Easy It Is to Add a New Role

One of the biggest advantages of the Chain of Responsibility pattern is how **trivially simple** it is to add new handlers (approvers). Here's why:

### ✅ Adding a New Approver is Just 3 Steps:

**Step 1: Create a New Approver Class**
```java
public class VicePresident extends Approver {
    @Override
    public void processLeaveRequest(int leaveDays) {
        if (leaveDays < 21) {  // VP can approve up to 21 days
            System.out.println("Approved by vice president");
        } else if (nextApprover != null) {
            System.out.println("VP cannot process this request, sending to next approver");
            nextApprover.processLeaveRequest(leaveDays);
        } else {
            System.out.println("Request denied");
        }
    }
}
```

**Step 2: Insert It Into the Chain**
```java
Approver teamLead = new TeamLead();
Approver manager = new Manager();
Approver director = new Director();
Approver vicePresident = new VicePresident();  // NEW!

teamLead.nextApprover(manager);
manager.nextApprover(director);
director.nextApprover(vicePresident);  // NEW!

teamLead.processLeaveRequest(15);
```

**Step 3: Done!** ✅
- No existing code is modified
- No existing classes are touched
- The pattern is open for extension, closed for modification
- Each handler is independent and testable

### 🎯 Why This Works So Well

| Aspect | Benefit |
|--------|---------|
| **New Handler Class** | Just extend `Approver` and implement `processLeaveRequest()` |
| **Chain Flexibility** | Insert/remove/reorder handlers by changing the main method only |
| **No Coupling** | Each handler only knows about the next handler, not the entire chain |
| **Easy Testing** | Test each approver independently without creating the full chain |
| **Scalability** | Add 100 approvers with zero changes to existing handler code |
| **Maintenance** | Changes are isolated to individual handler classes |

### 🔄 Changing Chain Order is Also Easy

Want to change the order? Just rearrange the linking:

```java
// Old order: TeamLead → Manager → Director
teamLead.nextApprover(manager);
manager.nextApprover(director);

// New order: Manager → TeamLead → Director (if you needed to)
manager.nextApprover(teamLead);
teamLead.nextApprover(director);
```

No code in TeamLead, Manager, or Director classes needs to change!

## Key Differences: Bad vs Good Practice

| Aspect | Bad Practice | Good Practice |
|--------|--------------|---------------|
| **Structure** | Single class with nested if-else | Chain of independent handlers |
| **Adding Handler** | Modify existing code | Create new class extending `Approver` |
| **Coupling** | Tightly coupled | Loosely coupled (handlers don't know about each other) |
| **Responsibility** | One class handles everything | Each handler has single responsibility |
| **Extensibility** | Hard - requires modifications | Easy - just add a new handler |
| **Testability** | Difficult - test entire logic | Easy - test each handler independently |
| **Open/Closed Principle** | Violates (closed for extension) | Follows (open for extension, closed for modification) |
| **Chain Reordering** | Requires code changes | Just relink the chain |

## Key Takeaways

✅ **Flexibility:** Add new handlers without changing existing ones  
✅ **Maintainability:** Each handler is responsible for one decision  
✅ **Testability:** Test handlers in isolation  
✅ **Scalability:** Handle simple to complex chains with ease  
✅ **Clean Code:** No massive if-else blocks  

The Chain of Responsibility pattern makes your code **extensible by design**, not by accident!
