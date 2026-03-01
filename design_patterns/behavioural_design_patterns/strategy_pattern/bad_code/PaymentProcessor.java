package design_patterns.behavioural_design_patterns.strategy_pattern.bad_code;

import design_patterns.behavioural_design_patterns.strategy_pattern.bad_code.concrete_payment_methods.BankTransfer;
import design_patterns.behavioural_design_patterns.strategy_pattern.bad_code.concrete_payment_methods.CreditCard;
import design_patterns.behavioural_design_patterns.strategy_pattern.bad_code.concrete_payment_methods.Paypal;

public class PaymentProcessor {
  public void processPayment(String paymentType, double amount) {
    if (paymentType.equals("CreditCard")) {
      CreditCard creditCard = new CreditCard();
      creditCard.processPayment(amount);
    } else if (paymentType.equals("PayPal")) {
      Paypal paypal = new Paypal();
      paypal.processPayment(amount);
    } else if (paymentType.equals("BankTransfer")) {
      BankTransfer bankTransfer = new BankTransfer();
      bankTransfer.processPayment(amount);
    } else {
      System.out.println("Invalid payment type: " + paymentType);
    }
  }
}
