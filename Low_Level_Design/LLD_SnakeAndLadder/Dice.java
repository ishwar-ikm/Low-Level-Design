package Low_Level_Design.LLD_SnakeAndLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
  int diceCount;
  int min = 1;
  int max = 6;

  public Dice(int diceCount) {
    this.diceCount = diceCount;
  }

  /**
   * Rolls the dice and returns the total sum of the rolled values.
   *
   * @return The total sum of the rolled values.
   */
  public int rollDice() {
    int total = 0;
    int diceUsed = 0;

    while(diceUsed < diceCount) {
      total += ThreadLocalRandom.current().nextInt(min,max+1);
      diceUsed++;
    }

    return total;
  }
}
