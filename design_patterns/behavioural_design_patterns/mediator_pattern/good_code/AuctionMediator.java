package design_patterns.behavioural_design_patterns.mediator_pattern.good_code;

import design_patterns.behavioural_design_patterns.mediator_pattern.good_code.core_classes.Bidder;

public interface AuctionMediator {
  void placeBid(Bidder bidder, int amount);
  void registerBidder(Bidder bidder);
}
