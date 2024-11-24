# Observer Design Pattern Example in Java

This project demonstrates the **Observer Design Pattern**, a behavioral design pattern that allows an object (Observable) to maintain a list of its dependents (Observers) and notify them of any state changes.

## Overview

The example simulates a store's stock system where different types of notifications (e.g., SMS, Email) are sent to subscribers when a product's stock becomes available.

### Key Components

1. **Observable Interface (`StockObservable`)**  
   Defines the methods for adding, removing, and notifying observers.  

2. **Concrete Observable (`IphoneObservableImp`)**  
   Maintains stock details and notifies observers when stock changes.

3. **Observer Interface (`NotificationAlertObserver`)**  
   Defines the method for updating observers.

4. **Concrete Observers**  
   - `SMSObserverImpl`: Sends an SMS alert to a subscriber.  
   - `EmailObserverImpl`: Sends an email alert to a subscriber.

5. **Store Class (Main)**  
   Demonstrates the pattern by simulating stock changes and notifying observers.

### Example Output

```text
SMS sent to 123456789 for stock count 10
Email sent to h6dL7@example.com for stock count 10
```

---

### Flowchart

```
Start
  |
  v
StockObservable (Interface)
  |--- Implemented by ---> IphoneObservableImp (Concrete Observable)
  |                         |
  |                         |--- Maintains list of ---> NotificationAlertObserver (Interface)
  |                               |
  |                               |--- Implemented by ---> SMSObserverImpl (Concrete Observer)
  |                               |                        |
  |                               |                        |--- Receives updates ---> SMS Notification
  |                               |
  |                               |--- Implemented by ---> EmailObserverImpl (Concrete Observer)
  |                                                        |
  |                                                        |--- Receives updates ---> Email Notification
  |
  |--- Tracks and updates ---> Stock Count
  |
  v
Store (Main Class)
  |
  |--- Creates Observers and adds them to ---> IphoneObservableImp
  |
  |--- Sets stock and notifies observers ---> Trigger Notifications
  |
  v
End
```

---

This showcases the interaction between the Observable and its Observers, illustrating how state changes in the Observable automatically notify all registered Observers.