package design_patterns.creational_design_patterns.factory_pattern.bad_code.VehicleImpl;

import design_patterns.creational_design_patterns.factory_pattern.bad_code.Vehicle;

public class Bike implements Vehicle {
  @Override
  public void start() {
    System.out.println("Bike started");
  }

  @Override
  public void stop() {
    System.out.println("Bike stopped");
  }
}
