
public class Mechanic {
	
	String[] SERVICES = {"Tire Repair","Break Change", "Oil Change"}; //Etc
	String service;
	
	public void receivedIssueFromReception(String service) throws Exception
	{
		boolean except = false;
		for (String s: SERVICES)
		{
			if( s.equals(service) )
			{
				except = true;
			}
		}
		
		if(except == false)
		{
			throw new Exception("We do not offer this service");
		}
		
		this.service = service;
	}
	
	public String fixedIssueAndInformReception()
	{
		if(this.service == null)
			return "You can go down to the other mechanic shop, they offer this";
		
		return "fixed " + service;
			
	}
}
