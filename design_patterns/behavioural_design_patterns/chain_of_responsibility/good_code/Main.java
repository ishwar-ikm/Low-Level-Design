package design_patterns.behavioural_design_patterns.chain_of_responsibility.good_code;

import design_patterns.behavioural_design_patterns.chain_of_responsibility.good_code.concrete_approver.Director;
import design_patterns.behavioural_design_patterns.chain_of_responsibility.good_code.concrete_approver.Manager;
import design_patterns.behavioural_design_patterns.chain_of_responsibility.good_code.concrete_approver.TeamLead;

public class Main {
  public static void main(String[] args) {
    Approver teamLead = new TeamLead();
    Approver manager = new Manager();
    Approver director = new Director();

    teamLead.nextApprover(manager);
    manager.nextApprover(director);

    teamLead.processLeaveRequest(12);
  }
}
