package design_patterns.behavioural_design_patterns.observer_pattern.good_code.concrete_subscriber;

import design_patterns.behavioural_design_patterns.observer_pattern.good_code.interfaces.Subscriber;

public class YouTubeSubsriber implements Subscriber {
  private String name;

  public YouTubeSubsriber(String name) {
    this.name = name;
  }

  @Override
  public void update(String video) {
    System.out.println("Notifying " + name + " about new video: " + video);
  }
}
