package Design_Patterns.Creational_Design_Pattern.Factory_Pattern;

public class ShapeFactory {
  public Shape getShape(String input) {
    if (input.equalsIgnoreCase("CIRCLE")) {
      return new Circle();
    } else if (input.equalsIgnoreCase("RECTANGLE")) {
      return new Rectangle();
    }
    return null;
  }
}
