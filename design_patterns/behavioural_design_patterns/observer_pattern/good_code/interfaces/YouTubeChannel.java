package design_patterns.behavioural_design_patterns.observer_pattern.good_code.interfaces;

public interface YouTubeChannel {
  void subscribe(Subscriber subscriber);
  void unsubscribe(Subscriber subscriber);
  void notifySubscribers(String video);
}
