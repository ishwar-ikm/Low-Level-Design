package Design_Patterns.Behavioral_Design_Pattern.Chain_Of_Responsibility;

public class ErrorLogProcessor extends Logprocessor {
  public ErrorLogProcessor(Logprocessor nextLogProcessor) {
    super(nextLogProcessor);
  }

  public void log(int logLevel, String message) {
    if (logLevel == Logprocessor.ERROR) {
      System.out.println("ERROR: " + message);
    } else {
      super.log(logLevel, message);
    }
  }
}
