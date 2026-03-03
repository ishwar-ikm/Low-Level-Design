package design_patterns.behavioural_design_patterns.mediator_pattern.good_code;

import design_patterns.behavioural_design_patterns.mediator_pattern.good_code.core_classes.Bidder;
import design_patterns.behavioural_design_patterns.mediator_pattern.good_code.core_classes.AuctionHouse;

public class Main {
  public static void main(String[] args) {
    AuctionMediator auctionHouse = new AuctionHouse();

    Bidder bidder1 = new Bidder("Alice");
    Bidder bidder2 = new Bidder("Bob");
    Bidder bidder3 = new Bidder("Charlie");

    auctionHouse.registerBidder(bidder1);
    auctionHouse.registerBidder(bidder2);
    auctionHouse.registerBidder(bidder3);

    bidder1.placeBid(100, auctionHouse);
    bidder2.placeBid(150, auctionHouse);
    bidder3.placeBid(120, auctionHouse);
  }
}
