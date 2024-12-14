package Design_Patterns.Behavioral_Design_Pattern.Chain_Of_Responsibility;

public class Main {
  public static void main(String[] args) {
    Logprocessor logObj = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));

    logObj.log(Logprocessor.ERROR, "exception happens");
    logObj.log(Logprocessor.DEBUG, "need to debug this ");
    logObj.log(Logprocessor.INFO, "just for info ");
  }
}
