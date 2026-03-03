# Observer Pattern (Behavioral)

- **Summary:** The Observer pattern defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified automatically.

## Problem & Motivation

**Problem:** In applications, multiple components often need to react to state changes in another object. For example, when a YouTube channel uploads a new video, multiple subscribers (via YouTube notifications, email, SMS, push notifications, etc.) need to be notified. Without a proper pattern, the channel would need to know about all notification methods and directly call them, creating tight coupling and making it difficult to add new notification types.

**Motivation:** Use the Observer pattern when:
- A change in one object requires changing others, but you don't know how many objects need to change
- An object should notify other objects without making assumptions about who those objects are
- You want to create a loosely coupled system where subjects and observers can evolve independently

## When to Use

- Event handling systems (GUI frameworks, event buses)
- Real-time data feeds (stock market updates, weather notifications)
- Pub-Sub messaging systems
- MVC architectures (model change notifications to views)
- Reactive programming patterns

## Trade-offs / Drawbacks

- **Memory leaks:** Observers that are not properly unsubscribed can accumulate and consume memory
- **Unpredictable order:** Observer notification order is not guaranteed, which can lead to unexpected behavior
- **Performance overhead:** Notifying many observers can be slow if not optimized
- **Debugging complexity:** Hard to track which observers are listening and why

## What This Folder Demonstrates

### Bad Code Example

The [`bad_code/YouTubeChannel.java`](bad_code/YouTubeChannel.java) demonstrates common mistakes:

1. **Tight Coupling:** The `YouTubeChannel` directly manages notifications instead of delegating to observers
2. **Hard-coded Notification Types:** Notification methods (like `sendEmailNotification()`) are hard-coded in the channel
3. **Violates Open/Closed Principle:** Adding new notification types (e.g., SMS, Slack) requires modifying the `YouTubeChannel` class
4. **Lack of Abstraction:** Subscribers are just strings; there's no abstraction for different subscriber types
5. **Poor Scalability:** The notification logic is mixed with the subject logic, making the code harder to maintain and test

```java
// Bad: Hard-coded email notification
private void notifySubscribers() {
    for (String subscriber : subscribers) {
        System.out.println("Notifying " + subscriber + " about new video: " + video);
    }
    sendEmailNotification(); // What if we want SMS next?
}
```

### Good Code Example

The good code implementation follows proper Observer pattern principles:

#### 1. **Subscriber Interface** ([`interfaces/Subscriber.java`](good_code/interfaces/Subscriber.java))
Defines a contract for all observers:

```java
public interface Subscriber {
    void update(String video);
}
```

#### 2. **YouTubeChannel Interface** ([`interfaces/YouTubeChannel.java`](good_code/interfaces/YouTubeChannel.java))
Defines the subject's contract:

```java
public interface YouTubeChannel {
    void subscribe(Subscriber subscriber);
    void unsubscribe(Subscriber subscriber);
    void notifySubscribers(String video);
}
```

#### 3. **Concrete Subject** ([`YouTubeChannelImpl.java`](good_code/YouTubeChannelImpl.java))
Manages observers without knowing their implementation details:

```java
public class YouTubeChannelImpl implements YouTubeChannel {
    private List<Subscriber> subscribers;
    
    @Override
    public void notifySubscribers(String video) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(video);  // Delegates to observer
        }
    }
}
```

#### 4. **Concrete Observers** 
Multiple observer implementations without modifying the subject:

- [`YouTubeSubsriber.java`](good_code/concrete_subscriber/YouTubeSubsriber.java) - In-app notifications
- [`EmailSubscriber.java`](good_code/concrete_subscriber/EmailSubscriber.java) - Email notifications
- [`PushnotificationSubscriber.java`](good_code/concrete_subscriber/PushnotificationSubscriber.java) - Push notifications

## Key Differences: Bad vs Good Practice

| Aspect | Bad Practice | Good Practice |
|--------|--------------|---------------|
| **Coupling** | Subject tightly coupled to notification types | Loose coupling via interfaces |
| **Extensibility** | Must modify subject to add new notification types | Add new observer implementation |
| **Separation of Concerns** | Notification logic mixed in subject | Notification logic in observers |
| **Reusability** | Notification logic not reusable | Observers can be reused across subjects |
| **Testing** | Hard to test notification behavior | Easy to mock observers |
| **Maintainability** | Changes to one notification affect others | Changes isolated to specific observer |

## Java-Specific Implementation Notes

- **Observer Pattern vs Reactive Streams:** Java 9+ provides `java.util.Flow` API for reactive streams, a more modern approach to the Observer pattern
- **Thread Safety:** If observers are added/removed or notified from different threads, synchronize the subscriber list
- **Memory Management:** Always unsubscribe observers when they're no longer needed to prevent memory leaks
- **WeakReference:** For optional observers, consider using `WeakReference` to avoid memory leaks

## Simple Usage Example

```java
// Create a YouTube channel
YouTubeChannelImpl channel = new YouTubeChannelImpl("Tech Channel");

// Create different types of subscribers
Subscriber youtubeSubscriber = new YouTubeSubsriber("Alice");
Subscriber emailSubscriber = new EmailSubscriber("alice@example.com");
Subscriber pushSubscriber = new PushnotificationSubscriber("Alice's Phone");

// Subscribe to the channel
channel.subscribe(youtubeSubscriber);
channel.subscribe(emailSubscriber);
channel.subscribe(pushSubscriber);

// Upload a video - all subscribers are notified automatically
channel.uploadVideo("Observer Pattern Explained");

// Output:
// Notifying Alice about new video: Observer Pattern Explained
// Sending email to alice@example.com about new video: Observer Pattern Explained
// Sending push notification to Alice's Phone about new video: Observer Pattern Explained
```

## How to Run the Examples (Java)

1. Open a terminal in this workspace root.

2. To run the bad example:
   ```bash
   cd design_patterns/behavioural_design_patterns/observer_pattern/bad_code
   javac *.java
   java design_patterns.behavioural_design_patterns.observer_pattern.bad_code.YouTubeChannel
   ```

3. To run the good example:
   ```bash
   cd ../good_code
   javac -d . *.java concrete_subscriber/*.java interfaces/*.java
   java design_patterns.behavioural_design_patterns.observer_pattern.good_code.Main
   ```

Note: Adjust `cd` paths if you run commands from a different working directory.

## Real-World Examples

- **GUI Frameworks:** Button listeners, event handlers in Swing/JavaFX
- **Spring Framework:** ApplicationEvent and ApplicationListener
- **EventBus Libraries:** Google Guava EventBus, Otto
- **Reactive Libraries:** RxJava, Project Reactor (modern implementations)
