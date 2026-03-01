package design_patterns.creational_design_patterns.singleton_pattern.bad_code;

public class Application {
  public static void main(String[] args) {
    Logger logger = new Logger();

    logger.log("This is the another logger instance from application logs.");
  }
}
