package Design_Patterns.Behavioral_Design_Pattern.Strategy_Design_Pattern;

import Design_Patterns.Behavioral_Design_Pattern.Strategy_Design_Pattern.Strategy.SportsDriveStrategy;

public class SportsVehicle extends Vehicle {
  SportsVehicle() {
    super(new SportsDriveStrategy());
  }
}
