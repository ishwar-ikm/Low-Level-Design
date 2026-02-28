package design_patterns.creational_design_patterns.factory_pattern.bad_code;

import design_patterns.creational_design_patterns.factory_pattern.bad_code.VehicleImpl.Bike;
import design_patterns.creational_design_patterns.factory_pattern.bad_code.VehicleImpl.Car;
import design_patterns.creational_design_patterns.factory_pattern.bad_code.VehicleImpl.Truck;

public class Main {
  public static void main(String[] args) {
    String vehcleType = "Car"; // This could come from user input or configuration

    Vehicle vehicle;
    if (vehcleType.equals("Car")) {
      vehicle = new Car();
    } else if (vehcleType.equals("Truck")) {
      vehicle = new Truck();
    } else if (vehcleType.equals("Bike")) {
      vehicle = new Bike();
    } else {
      throw new IllegalArgumentException("Invalid vehicle type: " + vehcleType);
    }

    vehicle.start();
    vehicle.stop();
  }
}
