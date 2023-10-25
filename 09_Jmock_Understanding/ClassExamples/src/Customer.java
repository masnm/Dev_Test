
public class Customer implements ICustomer {

	String order;
	
	public Customer(String order) {
		this.order = order;
	}
	
	@Override
	public String PlaceOrder() {
		String result = order;
		
		return result;
	}

	@Override
	public boolean ReceiveOrder(String order) {
		return order.equals(this.order);
	}

}
