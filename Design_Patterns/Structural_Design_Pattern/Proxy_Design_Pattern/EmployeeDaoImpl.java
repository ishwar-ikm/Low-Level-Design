package Design_Patterns.Structural_Design_Pattern.Proxy_Design_Pattern;

public class EmployeeDaoImpl implements EmployeeDao {

  @Override
  public void create(String client, EmployeeDo obj) throws Exception {
    System.out.println("Create Employee");
  }

  @Override
  public void delete(String client, int employeeId) throws Exception {
    System.out.println("Delete Employee with Id: " + employeeId);
  }

  @Override
  public EmployeeDo get(String client, int employeeId) throws Exception {
    System.out.println("Get Employee with Id: " + employeeId);
    return new EmployeeDo();
  }
}
