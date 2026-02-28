package design_patterns.creational_design_patterns.factory_pattern.good_code;

import design_patterns.creational_design_patterns.factory_pattern.good_code.VehicleImpl.Bike;
import design_patterns.creational_design_patterns.factory_pattern.good_code.VehicleImpl.Car;
import design_patterns.creational_design_patterns.factory_pattern.good_code.VehicleImpl.Truck;

public class VehicleFactory {
  public static Vehicle createVehicle(String type) {
    switch (type.toLowerCase()) {
      case "car":
        return new Car();
      case "truck":
        return new Truck();
      case "bike":
        return new Bike();
      default:
        throw new IllegalArgumentException("Unknown vehicle type: " + type);
    }
  }
}
