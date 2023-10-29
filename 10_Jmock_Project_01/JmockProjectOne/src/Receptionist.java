public class Receptionist implements IReceptionist {
	
	
	String issueReceived;
	
	@Override
	public String receiveIssueAndAssignMechanic(String issueReceived) {
		// TODO Auto-generated method stub
		
		this.issueReceived = issueReceived;
		
		return this.issueReceived;
	}

	@Override
	public String fixedIssueByMechanic(String fixed_issue) {
		// TODO Auto-generated method stub
		return fixed_issue;
	}
	
}
