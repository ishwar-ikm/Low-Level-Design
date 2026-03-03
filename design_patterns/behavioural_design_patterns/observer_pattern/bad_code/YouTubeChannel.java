package design_patterns.behavioural_design_patterns.observer_pattern.bad_code;

import java.util.ArrayList;
import java.util.List;

public class YouTubeChannel {
  List<String> subscribers = new ArrayList<String>();
  String video;

  public void subscribe(String subscriber) {
    subscribers.add(subscriber);
  }

  public void uploadVideo(String video) {
    this.video = video;
    notifySubscribers();
  }

  private void notifySubscribers() {
    for (String subscriber : subscribers) {
      System.out.println("Notifying " + subscriber + " about new video: " + video);
    }

    // If we want to add more notification channels (e.g., email, SMS), we would need to modify this method, which violates the Open/Closed Principle.
    sendEmailNotification();
  }

  private void sendEmailNotification() {
    for (String subscriber : subscribers) {
      System.out.println("Sending email to " + subscriber + " about new video: " + video);
    }
  }
}
