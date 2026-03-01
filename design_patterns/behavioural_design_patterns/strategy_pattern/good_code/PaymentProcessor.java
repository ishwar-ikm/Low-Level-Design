package design_patterns.behavioural_design_patterns.strategy_pattern.good_code;

public class PaymentProcessor {
  private PaymentMethod paymentMethod;

  public PaymentProcessor(PaymentMethod paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  public void processPayment(double amount) {
    paymentMethod.processPayment(amount);
  }

  public void setPaymentMethod(PaymentMethod paymentMethod) {
    this.paymentMethod = paymentMethod;
  }
}
