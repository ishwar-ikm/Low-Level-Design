package design_patterns.creational_design_patterns.builder_pattern.bad_code;

public class Car {
  public String make;
  public String model;
  public int year;
  public String color;
  public int price;

  public Car(String make, String model, int year, String color, int price) {
    this.make = make;
    this.model = model;
    this.year = year;
    this.color = color;
    this.price = price;
  }
  
  public Car(String make, String model, int year) {
    this.make = make;
    this.model = model;
    this.year = year;
  }

  public Car(String make, String model) {
    this.make = make;
    this.model = model;
  }

  // This will lead to a lot of constructors and confusion for the users of the Car class.
  // For 5 parameters, we have 5! = 120 constructors. This is not scalable and maintainable.
  // If we add more parameters, the number of constructors will increase factorially, making it impossible to manage.

  @Override
  public String toString() {
    return "Car [make=" + make + ", model=" + model + ", year=" + year + ", color=" + color + ", price=" + price
        + "]";
  }
}
