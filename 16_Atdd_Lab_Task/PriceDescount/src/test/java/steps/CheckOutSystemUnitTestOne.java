package steps;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

// this is the test of our check out system class
public class CheckOutSystemUnitTestOne {
	
	// defining the check out system object that we are going to test
	private CheckOutSystem system = null;
	
	// this method will run always before each test
	// this method is used to initialize the check out system from scratch
	// so that a test can't influence the next test
	@Before
	public void init () {
		// creating the new check out system
		system = new CheckOutSystem ();
	}
	
	// this test has some normal discount
	@Test
	public void test () {
		// defining all the parameters and expected return value for this test
		double unitPrice = 50;
		double quantity = 31;
		String discount = "3 for 130";
		double expectedPrice = 1350;
		
		// doing the actual test and verifying the return value with the expected one
		assertEquals ( expectedPrice, system.compute(unitPrice, quantity, discount), 0.0001 );
	}

	// this test has some normal discount
	@Test
	public void test2 () {
		// defining all the parameters and expected return value for this test
		double unitPrice = 50;
		double quantity = 30;
		String discount = "3 for 130";
		double expectedPrice = 1300;
		
		// doing the actual test and verifying the return value with the expected one
		assertEquals ( expectedPrice, system.compute(unitPrice, quantity, discount), 0.0001 );
	}

	// this test has some normal discount
	@Test
	public void test3 () {
		// defining all the parameters and expected return value for this test
		double unitPrice = 30;
		double quantity = 21;
		String discount = "2 for 45";
		double expectedPrice = 480;
		
		// doing the actual test and verifying the return value with the expected one
		assertEquals ( expectedPrice, system.compute(unitPrice, quantity, discount), 0.0001 );
	}

	// this test has some normal discount
	@Test
	public void test4 () {
		// defining all the parameters and expected return value for this test
		double unitPrice = 30;
		double quantity = 20;
		String discount = "2 for 45";
		double expectedPrice = 450;
		
		// doing the actual test and verifying the return value with the expected one
		assertEquals ( expectedPrice, system.compute(unitPrice, quantity, discount), 0.0001 );
	}

	// the discount is null in this test i.e. no discount
	@Test
	public void test5 () {
		// defining all the parameters and expected return value for this test
		double unitPrice = 30;
		double quantity = 20;
		String discount = null;
		double expectedPrice = 600;
		
		// doing the actual test and verifying the return value with the expected one
		assertEquals ( expectedPrice, system.compute(unitPrice, quantity, discount), 0.0001 );
	}

	// the discount is empty in this test i.e. no discount
	@Test
	public void test6 () {
		// defining all the parameters and expected return value for this test
		double unitPrice = 30;
		double quantity = 20;
		String discount = "";
		double expectedPrice = 600;
		
		// doing the actual test and verifying the return value with the expected one
		assertEquals ( expectedPrice, system.compute(unitPrice, quantity, discount), 0.0001 );
	}

	// the discount is blank in this test i.e. no discount
	@Test
	public void test7 () {
		// defining all the parameters and expected return value for this test
		double unitPrice = 30;
		double quantity = 20;
		String discount = "       ";
		double expectedPrice = 600;
		
		// doing the actual test and verifying the return value with the expected one
		assertEquals ( expectedPrice, system.compute(unitPrice, quantity, discount), 0.0001 );
	}
}
