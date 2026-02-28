package design_patterns.creational_design_patterns.factory_pattern.good_code;

public class Main {
  public static void main(String[] args) {
    Vehicle vehicle;
    
    vehicle = VehicleFactory.createVehicle("car");
    vehicle.start();
    vehicle.stop();

    vehicle = VehicleFactory.createVehicle("truck");
    vehicle.start();
    vehicle.stop();
  }
}
