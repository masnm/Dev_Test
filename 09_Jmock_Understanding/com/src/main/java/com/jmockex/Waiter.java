package com.jmockex;

public class Waiter implements IWaiter {

	String order;
	
	@Override
	public void SetOrder(String order) throws Exception{
		this.order = order;
	}

	@Override
	public String GetOrder() throws Exception {
		if(order.isEmpty())	{
			throw new Exception("No Order To Pass Exception");
		}
		
		String result = order;
		order = "";
		
		return result;
	}

}
