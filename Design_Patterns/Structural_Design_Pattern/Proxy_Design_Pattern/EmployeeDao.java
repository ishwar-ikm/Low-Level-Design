package Design_Patterns.Structural_Design_Pattern.Proxy_Design_Pattern;

public interface EmployeeDao {
  public void create(String client, EmployeeDo obj) throws Exception;
  public void delete(String client, int employeeId) throws Exception;
  public EmployeeDo get(String client, int employeeId) throws Exception;
}
