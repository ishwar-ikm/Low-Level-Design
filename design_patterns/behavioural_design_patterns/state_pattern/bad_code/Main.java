package design_patterns.behavioural_design_patterns.state_pattern.bad_code;

public class Main {
  public static void main(String[] args) {
    TrafficLight trafficLight = new TrafficLight("Red");

    for (int i = 0; i < 5; i++) {
      trafficLight.changeColor();
      System.out.println("Current color: " + trafficLight.getColor());
    }
  }
}
