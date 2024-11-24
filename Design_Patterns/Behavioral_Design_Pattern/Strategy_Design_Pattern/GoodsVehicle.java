package Design_Patterns.Behavioral_Design_Pattern.Strategy_Design_Pattern;
import Design_Patterns.Behavioral_Design_Pattern.Strategy_Design_Pattern.Strategy.NormalDriveStrategy;

public class GoodsVehicle extends Vehicle{
  GoodsVehicle() {
    super(new NormalDriveStrategy());
  }
}
