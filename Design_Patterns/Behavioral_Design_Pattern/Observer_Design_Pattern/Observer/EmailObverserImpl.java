package Design_Patterns.Behavioral_Design_Pattern.Observer_Design_Pattern.Observer;

import Design_Patterns.Behavioral_Design_Pattern.Observer_Design_Pattern.Observable.StockObservable;

public class EmailObverserImpl implements NotificationAlertObserver {
  String emailId;
  StockObservable observable;

  public EmailObverserImpl(String emailId, StockObservable observable) {
    this.emailId = emailId;
    this.observable = observable;
  }

  @Override
  public void update() {
    System.out.println("Email sent to " + emailId + " for stock count " + observable.getStockCount());
  }
}
