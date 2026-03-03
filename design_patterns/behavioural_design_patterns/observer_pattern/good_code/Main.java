package design_patterns.behavioural_design_patterns.observer_pattern.good_code;

import design_patterns.behavioural_design_patterns.observer_pattern.good_code.concrete_subscriber.EmailSubscriber;
import design_patterns.behavioural_design_patterns.observer_pattern.good_code.concrete_subscriber.PushnotificationSubscriber;
import design_patterns.behavioural_design_patterns.observer_pattern.good_code.concrete_subscriber.YouTubeSubsriber;
import design_patterns.behavioural_design_patterns.observer_pattern.good_code.interfaces.Subscriber;

public class Main {
  public static void main(String[] args) {
    YouTubeChannelImpl channel = new YouTubeChannelImpl("ikm Channel");

    Subscriber subscriber1 = new YouTubeSubsriber("Alice");
    Subscriber subscriber2 = new YouTubeSubsriber("Bob");

    Subscriber emailSubscriber = new EmailSubscriber("alice@amazon.com");

    Subscriber pushNotificationSubscriber = new PushnotificationSubscriber("Bob's Phone");

    channel.subscribe(subscriber1);
    channel.subscribe(subscriber2);
    channel.subscribe(emailSubscriber);
    channel.subscribe(pushNotificationSubscriber);

    channel.notifySubscribers("New video on Observer Pattern!");

  }
}
