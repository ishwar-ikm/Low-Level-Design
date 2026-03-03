package design_patterns.behavioural_design_patterns.state_pattern.good_code.concete_state_classes;

import design_patterns.behavioural_design_patterns.state_pattern.good_code.TrafficLightContext;
import design_patterns.behavioural_design_patterns.state_pattern.good_code.TrafficLightState;

public class RedLightState implements TrafficLightState {
  @Override
  public void changeColor(TrafficLightContext trafficLightContext) {
    System.out.println("Changing from Red to Green");
    trafficLightContext.setCurrentState(new GreenLightState());
  }

  @Override
  public String getColor() {
    return "Red";
  }
}
