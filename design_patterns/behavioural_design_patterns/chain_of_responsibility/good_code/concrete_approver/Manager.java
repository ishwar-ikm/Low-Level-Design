package design_patterns.behavioural_design_patterns.chain_of_responsibility.good_code.concrete_approver;

import design_patterns.behavioural_design_patterns.chain_of_responsibility.good_code.Approver;

public class Manager extends Approver {
  @Override
  public void processLeaveRequest(int leaveDays){
    if(leaveDays < 10){
      System.out.println("Approved by manager");
    } else if(nextApprover != null) {
      System.out.println("Manager can not process this request sending request to next approver");
      nextApprover.processLeaveRequest(leaveDays);
    } else {
      System.out.println("Request denied");
    }
  } 
}
