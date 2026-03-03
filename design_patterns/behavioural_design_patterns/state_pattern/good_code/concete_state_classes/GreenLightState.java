package design_patterns.behavioural_design_patterns.state_pattern.good_code.concete_state_classes;

import design_patterns.behavioural_design_patterns.state_pattern.good_code.TrafficLightContext;
import design_patterns.behavioural_design_patterns.state_pattern.good_code.TrafficLightState;

public class GreenLightState implements TrafficLightState {
  @Override
  public void changeColor(TrafficLightContext trafficLightContext) {
    System.out.println("Changing from Green to Yellow");
    trafficLightContext.setCurrentState(new YellowLightState());
  }

  @Override
  public String getColor() {
    return "Green";
  }
}
