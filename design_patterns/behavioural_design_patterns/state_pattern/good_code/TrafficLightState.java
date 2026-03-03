package design_patterns.behavioural_design_patterns.state_pattern.good_code;

public interface TrafficLightState {
  void changeColor(TrafficLightContext trafficLightContext);
  String getColor();
}
