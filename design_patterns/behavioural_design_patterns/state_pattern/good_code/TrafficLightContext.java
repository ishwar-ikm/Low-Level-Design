package design_patterns.behavioural_design_patterns.state_pattern.good_code;

public class TrafficLightContext {
  private TrafficLightState currentState;

  public TrafficLightContext(TrafficLightState initialState) {
    this.currentState = initialState;
  }

  public void setCurrentState(TrafficLightState newState) {
    this.currentState = newState;
  }

  public void changeColor() {
    currentState.changeColor(this);
  }
}
