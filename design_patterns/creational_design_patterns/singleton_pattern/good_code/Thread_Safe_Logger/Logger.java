package design_patterns.creational_design_patterns.singleton_pattern.good_code.Thread_Safe_Logger;

public class Logger {
  private static volatile Logger instance;

  private Logger() {
    // Private constructor to prevent instantiation
  }

  public static Logger getInstance() {
    if (instance == null) {
      synchronized (Logger.class) {
        if (instance == null) {
          instance = new Logger();
        }
      }
    }
    return instance;
  } 

  public void log(String message) {
    System.out.println("Log: " + message);
  }
}
