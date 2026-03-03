package design_patterns.behavioural_design_patterns.mediator_pattern.bad_code;

public class Bidder {
  private String name;
  private int bidAmount;

  public Bidder(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void placeBid(int amount, Bidder[] bidders) {
    this.bidAmount = amount;
    System.out.println(name + " placed a bid of $" + amount);
    
    for (Bidder bidder : bidders) {
      if (bidder != this) {
        bidder.notifyBidPlaced(this, amount);
      }
    }
  }

  public void notifyBidPlaced(Bidder bidder, int amount) {
    System.out.println(name + " received notification: " + bidder.getName() + " placed a bid of $" + amount);
  }
}
