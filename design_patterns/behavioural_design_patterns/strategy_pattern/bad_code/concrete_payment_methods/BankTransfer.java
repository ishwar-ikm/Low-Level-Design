package design_patterns.behavioural_design_patterns.strategy_pattern.bad_code.concrete_payment_methods;

import design_patterns.behavioural_design_patterns.strategy_pattern.bad_code.PaymentMethod;

public class BankTransfer implements PaymentMethod {
  @Override
  public void processPayment(double amount) {
    // Process bank transfer payment
    System.out.println("Processing bank transfer payment of $" + amount);
  }

}
