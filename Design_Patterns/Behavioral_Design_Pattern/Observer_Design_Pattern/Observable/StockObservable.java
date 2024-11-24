package Design_Patterns.Behavioral_Design_Pattern.Observer_Design_Pattern.Observable;

import Design_Patterns.Behavioral_Design_Pattern.Observer_Design_Pattern.Observer.NotificationAlertObserver;

public interface StockObservable {
  public void add(NotificationAlertObserver observer);
  public void remove(NotificationAlertObserver observer);
  public void notifySubscribers();
  public void setStocks(int newStocks);
  public int getStockCount();
}
