package design_patterns.behavioural_design_patterns.template_pattern.bad_code.concrete_beverages;

public class Coffee {
  public void prepareRecipe() {
    boilWater();
    brewCoffeeGrinds();
    pourInCup();
    addSugarAndMilk();
  }

  private void boilWater() {
    System.out.println("Boiling water");
  }

  private void brewCoffeeGrinds() {
    System.out.println("Brewing the coffee grinds");
  }

  private void pourInCup() {
    System.out.println("Pouring into cup");
  }

  private void addSugarAndMilk() {
    System.out.println("Adding Sugar and Milk");
  }
}
