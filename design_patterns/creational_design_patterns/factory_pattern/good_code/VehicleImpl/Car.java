package design_patterns.creational_design_patterns.factory_pattern.good_code.VehicleImpl;

import design_patterns.creational_design_patterns.factory_pattern.good_code.Vehicle;

public class Car implements Vehicle {
  @Override
  public void start() {
    System.out.println("Car started");
  }

  @Override
  public void stop() {
    System.out.println("Car stopped");
  }
}
