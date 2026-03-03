package design_patterns.behavioural_design_patterns.mediator_pattern.good_code.core_classes;

import design_patterns.behavioural_design_patterns.mediator_pattern.good_code.AuctionMediator;

public class Bidder {
  private String name;
  private int bidAmount;

  public Bidder(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void placeBid(int amount, AuctionMediator mediator) {
    this.bidAmount = amount;
    mediator.placeBid(this, amount);
  }

  public void notifyBidPlaced(Bidder bidder, int amount) {
    System.out.println(name + " received notification: " + bidder.getName() + " placed a bid of $" + amount);
  }
}
