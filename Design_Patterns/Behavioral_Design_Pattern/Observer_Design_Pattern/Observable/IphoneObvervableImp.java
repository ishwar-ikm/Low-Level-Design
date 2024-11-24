package Design_Patterns.Behavioral_Design_Pattern.Observer_Design_Pattern.Observable;

import java.util.ArrayList;

import Design_Patterns.Behavioral_Design_Pattern.Observer_Design_Pattern.Observer.NotificationAlertObserver;

public class IphoneObvervableImp implements StockObservable {
  public int stocks = 0;
  ArrayList<NotificationAlertObserver> observers = new ArrayList<NotificationAlertObserver>(); 

  @Override
  public void add(NotificationAlertObserver observer) {
    observers.add(observer);
  }

  @Override
  public void remove(NotificationAlertObserver observer) {
    observers.remove(observer);
  }

  @Override
  public void notifySubscribers() {
    for (NotificationAlertObserver observer : observers) {
      observer.update();
    }
  }

  @Override
  public void setStocks(int newStocks) {
    this.stocks += newStocks;
    if(stocks - newStocks == 0){
      notifySubscribers();
    }
  }

  @Override
  public int getStockCount() {
    return stocks;
  }
}
