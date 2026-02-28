package design_patterns.creational_design_patterns.builder_pattern.good_code;

public class Car {
  private String engine;
  private int wheels;
  private int seats;
  private String color;
  private boolean sunroof;
  private boolean navigationSystem;

  public String getEngine() {
    return this.engine;
  }

  public int getWheels() {
    return this.wheels;
  }

  public int getSeats() {
    return this.seats;
  }

  public String getColor() {
    return this.color;
  }

  public boolean hasSunroof() {
    return this.sunroof;
  }

  public boolean hasNavigationSystem() {
    return this.navigationSystem;
  }

  public Car setEngine(String engine) {
    this.engine = engine;
    return this;
  }

  public Car setWheels(int wheels) {
    this.wheels = wheels;
    return this;
  }

  public Car setSeats(int seats) {
    this.seats = seats;
    return this;
  }

  public Car setColor(String color) {
    this.color = color;
    return this;
  }

  public Car setSunroof(boolean sunroof) {
    this.sunroof = sunroof;
    return this;
  }

  public Car setNavigationSystem(boolean navigationSystem) {
    this.navigationSystem = navigationSystem;
    return this;
  }

  @Override
  public String toString() {
    return "Car{" +
        "engine='" + engine + '\'' +
        ", wheels=" + wheels +
        ", seats=" + seats +
        ", color='" + color + '\'' +
        ", sunroof=" + sunroof +
        ", navigationSystem=" + navigationSystem +
        '}';
  }
}
