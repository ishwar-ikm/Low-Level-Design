package design_patterns.behavioural_design_patterns.chain_of_responsibility.good_code.concrete_approver;

import design_patterns.behavioural_design_patterns.chain_of_responsibility.good_code.Approver;

public class TeamLead extends Approver {
  @Override
  public void processLeaveRequest(int leaveDays){
    if(leaveDays < 5){
      System.out.println("Approved by team lead");
    } else if(nextApprover != null) {
      System.out.println("Team lead can not process this request sending request to next approver");
      nextApprover.processLeaveRequest(leaveDays);
    } else {
      System.out.println("Request denied");
    }
  }
}
