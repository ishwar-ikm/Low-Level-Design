package design_patterns.behavioural_design_patterns.mediator_pattern.bad_code;

public class Main {
  public static void main(String[] args) {
    Bidder bidder1 = new Bidder("Alice");
    Bidder bidder2 = new Bidder("Bob");
    Bidder bidder3 = new Bidder("Charlie");

    Bidder[] bidders = {bidder1, bidder2, bidder3};

    bidder1.placeBid(100, bidders);
    bidder2.placeBid(150, bidders);
    bidder3.placeBid(120, bidders);
  }
}
