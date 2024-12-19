package Design_Patterns.Structural_Design_Pattern.Proxy_Design_Pattern;

public class ProxyDesignPattern {
  public static void main(String[] args) {
    try {
      EmployeeDao employeeDaoObj = new EmployeeDaoProxy();
      employeeDaoObj.create("ADMIN", new EmployeeDo());
      System.out.println("Operation successful");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
