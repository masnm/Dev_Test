package steps;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestCheckOutSystem {

	private String productName;
	private double itemPrice, Quantity;
	private String specialDiscount;
	private double actualCost;
	private CheckOutSystem system = null;
	
	@Given("I by items {string}")
	public void i_by_items(String string) {
		// saving the product name in instance variable
		productName = string;
	}

	@Given("At a certain price tag {string}")
	public void at_a_certain_price_tag(String string) {
		// saving the price in instance variable
		itemPrice = Double.parseDouble(string);
	}

	@When("I buy quanty {string}")
	public void i_buy_quanty(String string) {
		// saving the quantity in instance variable
		Quantity = Double.parseDouble(string);
	}

	@When("the price is {string}")
	public void the_price_is(String string) {
		// saving the discount price in instance variable
		specialDiscount = string;
	}

	@Then("The cost is {string}")
	public void the_cost_is(String string) {
		// this is the final price that we expect
		// so we will call to check out system to calculate the price and
		// verify the calculated price with the provided price.
		system = new CheckOutSystem ();
		double foundPrice = system.compute(itemPrice, Quantity, specialDiscount);
		assertEquals ( Double.parseDouble(string), foundPrice, 0.00001 );
	}

}
