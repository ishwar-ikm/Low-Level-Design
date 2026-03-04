package design_patterns.behavioural_design_patterns.chain_of_responsibility.good_code;

public abstract class Approver {
  protected Approver nextApprover;

  public void nextApprover(Approver approver){
    this.nextApprover = approver;
  }

  public abstract void processLeaveRequest(int leaveDays);
}
