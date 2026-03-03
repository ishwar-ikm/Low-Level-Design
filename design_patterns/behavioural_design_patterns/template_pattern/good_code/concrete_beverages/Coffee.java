package design_patterns.behavioural_design_patterns.template_pattern.good_code.concrete_beverages;

import design_patterns.behavioural_design_patterns.template_pattern.good_code.Beverage;

public class Coffee extends Beverage {
  @Override
  public void brew() {
    System.out.println("Brewing the coffee grinds");
  }

  @Override
  public void addCondiments() {
    System.out.println("Adding Sugar and Milk");
  }
}
