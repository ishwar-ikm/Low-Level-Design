package design_patterns.creational_design_patterns.singleton_pattern.good_code;

public class Application {
  public static void main(String[] args) {
    Logger logger = Logger.getInstance();

    logger.log("This is the singleton logger instance from application logs.");
  }
}
