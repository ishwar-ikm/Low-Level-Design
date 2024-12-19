package Design_Patterns.Structural_Design_Pattern.Proxy_Design_Pattern;

public class EmployeeDaoProxy implements EmployeeDao{
  EmployeeDao employeeDaoObj;

  public EmployeeDaoProxy() {
    this.employeeDaoObj = new EmployeeDaoImpl();
  }

  @Override
  public void create(String client, EmployeeDo obj) throws Exception {
    if(client.equals("ADMIN")) {
      employeeDaoObj.create(client, obj);
      return;
    }
    throw new Exception("Not Authorized");
  }

  @Override
  public void delete(String client, int employeeId) throws Exception {
    if (client.equals("ADMIN")) {
      employeeDaoObj.delete(client, employeeId);
    }
    throw new Exception("Not Authorized");
  }

  @Override
  public EmployeeDo get(String client, int employeeId) throws Exception {
    if(client.equals("ADMIN") || client.equals("USER")) {
      return employeeDaoObj.get(client, employeeId);
    }
    throw new Exception("Not Authorized");
  }
}
