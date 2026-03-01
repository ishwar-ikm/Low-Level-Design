package design_patterns.behavioural_design_patterns.strategy_pattern.bad_code.concrete_payment_methods;

import design_patterns.behavioural_design_patterns.strategy_pattern.bad_code.PaymentMethod;

public class CreditCard implements PaymentMethod {
  @Override
  public void processPayment(double amount) {
    // Process credit card payment
    System.out.println("Processing credit card payment of $" + amount);
  }
}
