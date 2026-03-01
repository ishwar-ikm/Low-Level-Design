package design_patterns.behavioural_design_patterns.strategy_pattern.bad_code.concrete_payment_methods;

import design_patterns.behavioural_design_patterns.strategy_pattern.bad_code.PaymentMethod;

public class Paypal implements PaymentMethod {
  @Override
  public void processPayment(double amount) {
    // Process PayPal payment
    System.out.println("Processing PayPal payment of $" + amount);
  }
}
