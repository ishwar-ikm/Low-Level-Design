package Design_Patterns.Structural_Design_Pattern.Decorator_Design_Pattern;

import Design_Patterns.Structural_Design_Pattern.Decorator_Design_Pattern.Decorator.ExtraCheese;
import Design_Patterns.Structural_Design_Pattern.Decorator_Design_Pattern.Decorator.Mushroom;
import Design_Patterns.Structural_Design_Pattern.Decorator_Design_Pattern.Pizza.BasePizza;
import Design_Patterns.Structural_Design_Pattern.Decorator_Design_Pattern.Pizza.Farmhouse;
import Design_Patterns.Structural_Design_Pattern.Decorator_Design_Pattern.Pizza.Margherita;

public class PizzaShop {
  public static void main(String[] args) {
    BasePizza cheesePizza = new ExtraCheese(new Margherita());
    System.out.println("Cost of margherita pizza with extra cheese is " + cheesePizza.cost());

    BasePizza veggiePizza = new Mushroom(new ExtraCheese(new Farmhouse()));
    System.out.println("Cost of veggie pizza with extra mushroon and cheese is " + veggiePizza.cost());
  }
}
