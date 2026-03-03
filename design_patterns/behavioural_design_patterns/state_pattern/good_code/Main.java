package design_patterns.behavioural_design_patterns.state_pattern.good_code;

import design_patterns.behavioural_design_patterns.state_pattern.good_code.concete_state_classes.RedLightState;

public class Main {
  public static void main(String[] args) {
    TrafficLightContext trafficLightContext = new TrafficLightContext(new RedLightState());

    trafficLightContext.changeColor();
    trafficLightContext.changeColor();
    trafficLightContext.changeColor();
    trafficLightContext.changeColor();
    trafficLightContext.changeColor();
    trafficLightContext.changeColor();
    trafficLightContext.changeColor();
  }
}
