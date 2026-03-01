package design_patterns.behavioural_design_patterns.strategy_pattern.good_code;

import design_patterns.behavioural_design_patterns.strategy_pattern.good_code.concrete_payment_methods.CreditCard;
import design_patterns.behavioural_design_patterns.strategy_pattern.good_code.concrete_payment_methods.Paypal;

public class Main {
  public static void main(String[] args) {
    PaymentProcessor processor = new PaymentProcessor(new CreditCard());
    processor.processPayment(100.0);

    processor.setPaymentMethod(new Paypal());
    processor.processPayment(200.0);
  }
}
