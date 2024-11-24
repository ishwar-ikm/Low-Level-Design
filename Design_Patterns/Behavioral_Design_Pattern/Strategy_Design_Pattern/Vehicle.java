package Design_Patterns.Behavioral_Design_Pattern.Strategy_Design_Pattern;
import Design_Patterns.Behavioral_Design_Pattern.Strategy_Design_Pattern.Strategy.DriveStrategy;

public class Vehicle {
  DriveStrategy driveStrategy;
  
  Vehicle(DriveStrategy driveStrategy) {
    this.driveStrategy = driveStrategy;
  }
  
  public void drive() {
    driveStrategy.drive();
  }
}
