package Design_Patterns.Creational_Design_Pattern.Factory_Pattern;

public class MainClass {
  public static void main(String[] args) {
    ShapeFactory obj = new ShapeFactory();

    Shape shapeObj1 = obj.getShape("RECTANGLE");
    Shape shapeObj2 = obj.getShape("CIRCLE");

    shapeObj1.draw();
    shapeObj2.draw();
  }
}
