package design_patterns.behavioural_design_patterns.strategy_pattern.bad_code;

public class Main {
  public static void main(String[] args) {
    double amount = 100.0;

    PaymentProcessor paymentProcessor = new PaymentProcessor();
    paymentProcessor.processPayment("CreditCard", amount);
    paymentProcessor.processPayment("PayPal", amount);
    paymentProcessor.processPayment("BankTransfer", amount);
  }
}
