package design_patterns.behavioural_design_patterns.template_pattern.good_code;

import design_patterns.behavioural_design_patterns.template_pattern.good_code.concrete_beverages.Coffee;
import design_patterns.behavioural_design_patterns.template_pattern.good_code.concrete_beverages.Tea;

public class Main {
  public static void main(String[] args) {
    Coffee coffee = new Coffee();
    coffee.prepareRecipe();

    System.out.println();
    
    Tea tea = new Tea();
    tea.prepareRecipe();
  }
}
