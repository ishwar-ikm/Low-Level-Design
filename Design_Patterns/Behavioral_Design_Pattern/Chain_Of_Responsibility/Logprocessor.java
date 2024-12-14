package Design_Patterns.Behavioral_Design_Pattern.Chain_Of_Responsibility;

public abstract class Logprocessor {
  public static int INFO = 1;
  public static int DEBUG = 2;
  public static int ERROR = 3;

  Logprocessor nextLoggerProcessor;

  public Logprocessor(Logprocessor loggerProcessor) {
    this.nextLoggerProcessor = loggerProcessor;
  }

  public void log(int logLevel, String message) {

    if (nextLoggerProcessor != null) {
      nextLoggerProcessor.log(logLevel, message);
    }
  }

}
