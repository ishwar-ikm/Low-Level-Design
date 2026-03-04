package design_patterns.behavioural_design_patterns.chain_of_responsibility.good_code.concrete_approver;

import design_patterns.behavioural_design_patterns.chain_of_responsibility.good_code.Approver;

public class Director extends Approver {
  @Override
  public void processLeaveRequest(int leaveDays){
    if(leaveDays < 14){
      System.out.println("Approved by director");
    } else if(nextApprover != null) {
      System.out.println("Director can not process this request sending request to next approver");
      nextApprover.processLeaveRequest(leaveDays);
    } else {
      System.out.println("Request denied");
    }
  } 
}
