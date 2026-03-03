package design_patterns.behavioural_design_patterns.template_pattern.bad_code.concrete_beverages;

public class Tea {
  public void prepareRecipe() {
    boilWater();
    steepTeaBag();
    pourInCup();
    addLemon();
  }

  private void boilWater() {
    System.out.println("Boiling water");
  }

  private void steepTeaBag() {
    System.out.println("Steeping the tea");
  }

  private void pourInCup() {
    System.out.println("Pouring into cup");
  }

  private void addLemon() {
    System.out.println("Adding Lemon");
  }
}
