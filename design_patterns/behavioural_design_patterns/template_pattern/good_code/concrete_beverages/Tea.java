package design_patterns.behavioural_design_patterns.template_pattern.good_code.concrete_beverages;

import design_patterns.behavioural_design_patterns.template_pattern.good_code.Beverage;

public class Tea extends Beverage {
  @Override
  public void brew() {
    System.out.println("Steeping the tea");
  }

  @Override
  public void addCondiments() {
    System.out.println("Adding Lemon");
  }
}
