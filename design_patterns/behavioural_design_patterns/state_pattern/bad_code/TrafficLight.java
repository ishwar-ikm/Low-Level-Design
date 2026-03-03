package design_patterns.behavioural_design_patterns.state_pattern.bad_code;

public class TrafficLight {
  private String color;

  public TrafficLight(String color) {
    this.color = color;
  }

  public void changeColor() {
    if (color.equals("Red")) {
      color = "Green";
      System.out.println("Changing from Red to Green");
    } else if (color.equals("Green")) {
      color = "Yellow";
      System.out.println("Changing from Green to Yellow");
    } else if (color.equals("Yellow")) {
      color = "Red";
      System.out.println("Changing from Yellow to Red");
    } else if (color.equals("Blinking")) {
      color = "Maintenance";
      System.out.println("Changing from Blinking to Maintenance");
    } else if(color.equals("Maintenance")) {
      color = "Red";
      System.out.println("Changing from Maintenance to Red");
    } else {
      System.out.println("Invalid color");
    }

    // If we want to add a new state, we need to modify this method, which violates the Open/Closed Principle
    // Adding new states would require adding more conditions, making the code more complex and error-prone
  }

  public String getColor() {
    return color;
  }
}
