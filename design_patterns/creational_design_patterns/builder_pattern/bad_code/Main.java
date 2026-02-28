package design_patterns.creational_design_patterns.builder_pattern.bad_code;

public class Main {
  public static void main(String[] args) {
    Car car1 = new Car("Toyota", "Camry", 2020, "Red", 25000);
    Car car2 = new Car("Honda", "Civic", 2019);

    System.out.println(car1.toString());
    System.out.println(car2.toString());
  }
}
