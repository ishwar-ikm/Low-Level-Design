package design_patterns.behavioural_design_patterns.mediator_pattern.good_code.core_classes;

import java.util.ArrayList;
import java.util.List;

import design_patterns.behavioural_design_patterns.mediator_pattern.good_code.AuctionMediator;

public class AuctionHouse implements AuctionMediator {
  List<Bidder> bidders;

  public AuctionHouse() {
    this.bidders = new ArrayList<>();
  }

  @Override
  public void placeBid(Bidder bidder, int amount) {
    System.out.println(bidder.getName() + " placed a bid of $" + amount);
    
    for (Bidder b : bidders) {
      if (b != bidder) {
        b.notifyBidPlaced(bidder, amount);
      }
    }
  }

  @Override
  public void registerBidder(Bidder bidder) {
    bidders.add(bidder);
  }
}
