package Design_Patterns.Behavioral_Design_Pattern.Strategy_Design_Pattern.Strategy;

public class NormalDriveStrategy implements DriveStrategy {
  @Override
  public void drive() {
    System.out.println("Normal Drive");
  }
}
