package steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.jmock.Expectations;
import org.jmock.Mockery;

import game.Game;
import game.RandomRollInterface;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FirstFrameSpare {
	
	
	// defining the Game object
	private Game game = null;
	private Mockery mockery = null;
	private RandomRollInterface roller = null;
	

	@Given("first frame first roll got {string} points")
	public void first_frame_first_roll_got_points(String string) {
		mockery = new Mockery ();
		roller = mockery.mock ( RandomRollInterface.class );
		game = new Game ( roller );
		
		final int number = Integer.parseInt(string);
		mockery.checking(new Expectations () {{
			oneOf(roller).getRandomNumber(10);
			will(returnValue(number));
		}});
		game.performNextRoll();
	}

	@Given("first frame second roll got {string} points")
	public void first_frame_second_roll_got_points(String string) {
		final int called = 10 - game.getPreviousRollResult();
		final int number = Integer.parseInt(string);
		mockery.checking(new Expectations () {{
			oneOf(roller).getRandomNumber(called);
			will(returnValue(number));
		}});
		game.performNextRoll();
	}

	@Given("which makes it as spare")
	public void which_makes_it_as_spare() {
		assertTrue ( game.getPreviousFrameInfo("Spare"));
	}

	@When("second frame first roll get {string} points")
	public void second_frame_first_roll_get_points(String string) {
		final int number = Integer.parseInt(string);
		mockery.checking(new Expectations () {{
			oneOf(roller).getRandomNumber(10);
			will(returnValue(number));
		}});
		game.performNextRoll();
	}

	@When("second frame second roll get {string} points")
	public void second_frame_second_roll_get_points(String string) {
		final int called = 10 - game.getPreviousRollResult();
		final int number = Integer.parseInt(string);
		mockery.checking(new Expectations () {{
			oneOf(roller).getRandomNumber(called);
			will(returnValue(number));
		}});
		game.performNextRoll();
	}

	@Then("first frame got a total of {string} points")
	public void first_frame_got_a_total_of_points(String string) {
		int actualScore = game.getFrameTotalPoint (1);
		assertEquals ( Integer.parseInt(string), actualScore );
	}

	@Then("second frame got a total of {string} points")
	public void second_frame_got_a_total_of_points(String string) {
		int actualScore = game.getFrameTotalPoint (2);
		assertEquals ( Integer.parseInt(string), actualScore );
	}

}
