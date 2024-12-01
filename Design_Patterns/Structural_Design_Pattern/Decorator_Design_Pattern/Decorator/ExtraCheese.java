package Design_Patterns.Structural_Design_Pattern.Decorator_Design_Pattern.Decorator;

import Design_Patterns.Structural_Design_Pattern.Decorator_Design_Pattern.Pizza.BasePizza;

public class ExtraCheese extends ToppingsDecorator {
  BasePizza basePizza;

  public ExtraCheese(BasePizza pizza){
    this.basePizza = pizza;
  }

  @Override
  public int cost(){
    return this.basePizza.cost() + 15;
  }
}
