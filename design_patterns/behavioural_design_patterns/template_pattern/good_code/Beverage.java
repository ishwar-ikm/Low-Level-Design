package design_patterns.behavioural_design_patterns.template_pattern.good_code;

public abstract class Beverage {
  public void prepareRecipe() {
    boilWater();
    brew();
    pourInCup();
    addCondiments();
  }

  public abstract void brew();
  public abstract void addCondiments();

  private void boilWater() {
    System.out.println("Boiling water");
  }

  private void pourInCup() {
    System.out.println("Pouring into cup");
  }
}
