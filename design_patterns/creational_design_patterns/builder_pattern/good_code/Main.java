package design_patterns.creational_design_patterns.builder_pattern.good_code;

public class Main {
  public static void main(String[] args) {
    Car car = new Car()
      .setEngine("V8")
      .setWheels(4)
      .setSeats(5)
      .setColor("Red")
      .setSunroof(true)
      .setNavigationSystem(true);

    System.out.println("Car: " + car.toString());

    Car car2 = new Car()
      .setEngine("V6")
      .setWheels(4)
      .setSeats(5);

    System.out.println("Car 2: " + car2.toString());
  }
}
