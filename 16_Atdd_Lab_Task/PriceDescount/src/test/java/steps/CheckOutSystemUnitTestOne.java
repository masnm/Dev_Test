package steps;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CheckOutSystemUnitTestOne {
	
	private CheckOutSystem system = null;
	
	@Before
	public void init () {
		system = new CheckOutSystem ();
	}
	
	@Test
	public void test () {
		double unitPrice = 50;
		double quantity = 31;
		String discount = "3 for 130";
		double expectedPrice = 1350;
		
		assertEquals ( expectedPrice, system.compute(unitPrice, quantity, discount), 0.0001 );
	}
	@Test
	public void test2 () {
		double unitPrice = 50;
		double quantity = 30;
		String discount = "3 for 130";
		double expectedPrice = 1300;
		
		assertEquals ( expectedPrice, system.compute(unitPrice, quantity, discount), 0.0001 );
	}
	@Test
	public void test3 () {
		double unitPrice = 30;
		double quantity = 21;
		String discount = "2 for 45";
		double expectedPrice = 480;
		
		assertEquals ( expectedPrice, system.compute(unitPrice, quantity, discount), 0.0001 );
	}
	@Test
	public void test4 () {
		double unitPrice = 30;
		double quantity = 20;
		String discount = "2 for 45";
		double expectedPrice = 450;
		
		assertEquals ( expectedPrice, system.compute(unitPrice, quantity, discount), 0.0001 );
	}
	@Test
	public void test5 () {
		double unitPrice = 30;
		double quantity = 20;
		String discount = "";
		double expectedPrice = 600;
		
		assertEquals ( expectedPrice, system.compute(unitPrice, quantity, discount), 0.0001 );
	}
}
