package design_patterns.behavioural_design_patterns.observer_pattern.good_code.concrete_subscriber;

import design_patterns.behavioural_design_patterns.observer_pattern.good_code.interfaces.Subscriber;

public class PushnotificationSubscriber implements Subscriber {
  private String deviceToken;

  public PushnotificationSubscriber(String deviceToken) {
    this.deviceToken = deviceToken;
  }

  @Override
  public void update(String video) {
    System.out.println("Sending push notification to device " + deviceToken + " about new video: " + video);
  }
  
}
