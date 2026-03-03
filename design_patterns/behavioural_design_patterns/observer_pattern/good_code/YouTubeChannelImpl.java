package design_patterns.behavioural_design_patterns.observer_pattern.good_code;

import java.util.ArrayList;
import java.util.List;

import design_patterns.behavioural_design_patterns.observer_pattern.good_code.interfaces.Subscriber;
import design_patterns.behavioural_design_patterns.observer_pattern.good_code.interfaces.YouTubeChannel;

public class YouTubeChannelImpl implements YouTubeChannel {
  private String name;
  private List<Subscriber> subscribers;

  public YouTubeChannelImpl(String name) {
    this.name = name;
    this.subscribers = new ArrayList<>();
  }

  @Override
  public void subscribe(Subscriber subscriber) {
    subscribers.add(subscriber);
  }

  @Override
  public void unsubscribe(Subscriber subscriber) {
    subscribers.remove(subscriber);
  } 

  @Override
  public void notifySubscribers(String video) {
    for (Subscriber subscriber : subscribers) {
      subscriber.update(video);
    }
  }
  
  public void uploadVideo(String video) {
    System.out.println("Uploading new video: " + video);
    notifySubscribers(video);
  }
}
