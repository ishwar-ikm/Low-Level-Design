package Design_Patterns.Behavioral_Design_Pattern.Observer_Design_Pattern.Observer;

import Design_Patterns.Behavioral_Design_Pattern.Observer_Design_Pattern.Observable.StockObservable;

public class SMSObserverImpl implements NotificationAlertObserver{
  StockObservable observable;
  int phoneNumber;

  public SMSObserverImpl(int phoneNumber, StockObservable observable) {
    this.observable = observable;
    this.phoneNumber = phoneNumber;
  }

  @Override
  public void update() {
    System.out.println("SMS sent to " + phoneNumber + " for stock count " + observable.getStockCount());
  }
}
