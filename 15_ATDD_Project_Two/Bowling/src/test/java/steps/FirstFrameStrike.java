package steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.jmock.Expectations;
import org.jmock.Mockery;

import game.Game;
import game.RandomRollInterface;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FirstFrameStrike {
	// defining the Game object
	private Game game = null;
	private Mockery mockery = null;
	private RandomRollInterface roller = null;

	@Given("First frame get an strike as a result")
	public void first_frame_get_an_strike_as_a_result() {
		mockery = new Mockery ();
		roller = mockery.mock ( RandomRollInterface.class );
		game = new Game ( roller );
	}

	@When("first frame first roll get {string} points")
	public void first_frame_first_roll_get_points ( String string ) {
		mockery.checking(new Expectations () {{
			oneOf(roller).getRandomNumber(10);
			will(returnValue(10));
		}});
		game.performNextRoll();
	}

	@When("second frame first roll get {string} pointss")
	public void second_frame_first_roll_get_pointss(String string) {
		final int number = Integer.parseInt(string);
		mockery.checking(new Expectations () {{
			oneOf(roller).getRandomNumber(10);
			will(returnValue(number));
		}});
		game.performNextRoll();
	}

	@When("second frame second roll get {string} pointss")
	public void second_frame_second_roll_get_pointss(String string) {
		final int called = 10 - game.getPreviousRollResult();
		final int number = Integer.parseInt(string);
		mockery.checking(new Expectations () {{
			oneOf(roller).getRandomNumber(called);
			will(returnValue(number));
		}});
		game.performNextRoll();
	}

	@Then("first frame get a total of {string} points")
	public void first_frame_get_a_total_of_points(String string) {
		int actualScore = game.getFrameTotalPoint (1);
		assertEquals ( Integer.parseInt(string), actualScore );
	}

	@Then("second frame get a total of {string} points")
	public void second_frame_get_a_total_of_points(String string) {
		int actualScore = game.getFrameTotalPoint (2);
		assertEquals ( Integer.parseInt(string), actualScore );
	}

}
