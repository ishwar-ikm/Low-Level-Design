package design_patterns.creational_design_patterns.prototype_pattern.good_code;

public class Character implements Cloneable {
  private String name;
  private int health;
  private int attackPower;
  private int level;

  public Character(String name, int health, int attackPower, int level) {
    this.name = name;
    this.health = health;
    this.attackPower = attackPower;
    this.level = level;
  }

  public void showCharacterInfo() {
    System.out.println("Character [Name=" + name + ", Health=" + health
        + ", AttackPower=" + attackPower + ", Level=" + level + "]");
  }

  @Override
  protected Character clone() throws CloneNotSupportedException {
    return (Character) super.clone();
  }

  public String getName() {
    return name;
  }

  public int getHealth() {
    return health;
  }

  public int getAttackPower() {
    return attackPower;
  }

  public int getLevel() {
    return level;
  }
}
