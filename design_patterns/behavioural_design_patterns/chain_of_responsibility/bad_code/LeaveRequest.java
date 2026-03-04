public class LeaveRequest {
  public static void main(String[] args) {
    int requestedLeaveDays = 5;
    if (requestedLeaveDays <= 2) {
      System.out.println("Leave approved by Team Lead");
    } else if (requestedLeaveDays <= 5) {
      System.out.println("Leave approved by Manager");
    } else if (requestedLeaveDays <= 10) {
      System.out.println("Leave approved by Director");
    } else {
      System.out.println("Leave request denied");
    }
  }
}