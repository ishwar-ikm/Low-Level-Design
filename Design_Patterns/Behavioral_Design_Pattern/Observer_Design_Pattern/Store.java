package Design_Patterns.Behavioral_Design_Pattern.Observer_Design_Pattern;

import Design_Patterns.Behavioral_Design_Pattern.Observer_Design_Pattern.Observable.IphoneObvervableImp;
import Design_Patterns.Behavioral_Design_Pattern.Observer_Design_Pattern.Observable.StockObservable;
import Design_Patterns.Behavioral_Design_Pattern.Observer_Design_Pattern.Observer.EmailObverserImpl;
import Design_Patterns.Behavioral_Design_Pattern.Observer_Design_Pattern.Observer.NotificationAlertObserver;
import Design_Patterns.Behavioral_Design_Pattern.Observer_Design_Pattern.Observer.SMSObserverImpl;

public class Store {
  public static void main(String[] args) {
    StockObservable iPhoneStockObservable = new IphoneObvervableImp();
    
    NotificationAlertObserver smsObserver = new SMSObserverImpl(123456789, iPhoneStockObservable);
    NotificationAlertObserver emailObserver = new EmailObverserImpl("h6dL7@example.com", iPhoneStockObservable);
    
    iPhoneStockObservable.add(smsObserver);
    iPhoneStockObservable.add(emailObserver);
    
    iPhoneStockObservable.setStocks(10);
  }
}
