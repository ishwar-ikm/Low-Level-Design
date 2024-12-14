package Design_Patterns.Behavioral_Design_Pattern.Chain_Of_Responsibility;

public class InfoLogProcessor extends Logprocessor {

  public InfoLogProcessor(Logprocessor nextLogProcessor) {
    super(nextLogProcessor);
  }

  public void log(int logLevel, String message) {
    if (logLevel == Logprocessor.INFO) {
      System.out.println("INFO: " + message);
    } else {
      super.log(logLevel, message);
    }
  }
}
