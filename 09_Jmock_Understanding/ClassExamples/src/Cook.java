
public class Cook implements ICook {

	String order; 
	
	@Override
	public void SetOrder(String order) {
		this.order = order;
	}

	@Override
	public String GetOrder() {
		String result = order;
		order = "";
		
		return result;
	}

}
