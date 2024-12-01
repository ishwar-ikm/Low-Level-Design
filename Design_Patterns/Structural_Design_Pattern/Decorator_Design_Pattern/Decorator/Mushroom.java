package Design_Patterns.Structural_Design_Pattern.Decorator_Design_Pattern.Decorator;

import Design_Patterns.Structural_Design_Pattern.Decorator_Design_Pattern.Pizza.BasePizza;

public class Mushroom extends ToppingsDecorator {
  BasePizza basePizza;

  public Mushroom(BasePizza pizza){
    this.basePizza = pizza;
  }

  @Override
  public int cost(){
    return this.basePizza.cost() + 10;
  }
}
