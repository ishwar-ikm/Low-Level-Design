package Low_Level_Design.LLD_TicTacToe.Util;

public class Pair<U, V> {
  private final U first;
  private final V second;

  public Pair(U first, V second) {
      this.first = first;
      this.second = second;
  }

  public U getFirst() {
      return first;
  }

  public V getSecond() {
      return second;
  }

  @Override
  public String toString() {
      return "(" + first + ", " + second + ")";
  }
}