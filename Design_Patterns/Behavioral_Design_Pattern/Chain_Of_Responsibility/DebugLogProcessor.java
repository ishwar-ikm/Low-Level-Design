package Design_Patterns.Behavioral_Design_Pattern.Chain_Of_Responsibility;

public class DebugLogProcessor extends Logprocessor{
  public DebugLogProcessor(Logprocessor nextLogProcessor) {
    super(nextLogProcessor);
  }

  public void log(int logLevel, String message) {
    if (logLevel == Logprocessor.DEBUG) {
      System.out.println("DEBUG: " + message);
    } else {
      super.log(logLevel, message);
    }
  }
}
