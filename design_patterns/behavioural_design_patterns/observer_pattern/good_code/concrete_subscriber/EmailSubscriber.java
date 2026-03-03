package design_patterns.behavioural_design_patterns.observer_pattern.good_code.concrete_subscriber;

import design_patterns.behavioural_design_patterns.observer_pattern.good_code.interfaces.Subscriber;

public class EmailSubscriber implements Subscriber {
  private String email;

  public EmailSubscriber(String email) {
    this.email = email;
  }

  @Override
  public void update(String video) {
    System.out.println("Sending email to " + email + " about new video: " + video);
  }
}
