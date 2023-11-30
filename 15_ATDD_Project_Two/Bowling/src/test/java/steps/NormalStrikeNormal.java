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

public class NormalStrikeNormal {
	
	// defining the Game object
	private Game game = null;
	private Mockery mockery = null;
	private RandomRollInterface roller = null;

	@Given("my first frame first roll gives {string} points")
	public void my_first_frame_first_roll_gives_points(String string) {
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

	@Given("my frist frame second roll gives {string} points")
	public void my_frist_frame_second_roll_gives_points(String string) {
		final int called = 10 - game.getPreviousRollResult();
		final int number = Integer.parseInt(string);
		mockery.checking(new Expectations () {{
			oneOf(roller).getRandomNumber(called);
			will(returnValue(number));
		}});
		game.performNextRoll();
	}

	@When("my get second frame first roll {string} pins")
	public void my_get_second_frame_first_roll_pins(String string) {
		final int number = Integer.parseInt(string);
		mockery.checking(new Expectations () {{
			oneOf(roller).getRandomNumber(10);
			will(returnValue(number));
		}});
		game.performNextRoll();
	}

	@When("my which makes this frame as an strike")
	public void my_which_makes_this_frame_as_an_strike() {
		assertTrue ( game.getPreviousFrameInfo("Strike") );
	}

	@When("my third frame first roll i got {string} points")
	public void my_third_frame_first_roll_i_got_points(String string) {
		final int number = Integer.parseInt(string);
		mockery.checking(new Expectations () {{
			oneOf(roller).getRandomNumber(10);
			will(returnValue(number));
		}});
		game.performNextRoll();
	}

	@When("my third frame second roll i got {string} points")
	public void my_third_frame_second_roll_i_got_points(String string) {
		final int called = 10 - game.getPreviousRollResult();
		final int number = Integer.parseInt(string);
		mockery.checking(new Expectations () {{
			oneOf(roller).getRandomNumber(called);
			will(returnValue(number));
		}});
		game.performNextRoll();
	}

	@Then("my first frame i got total of {string} points")
	public void my_first_frame_i_got_total_of_points(String string) {
		assertEquals ( Integer.parseInt ( string ),
				game.getFrameTotalPoint(1) );
	}

	@Then("my second frame i got total of {string} points")
	public void my_second_frame_i_got_total_of_points(String string) {
		assertEquals ( Integer.parseInt ( string ),
				game.getFrameTotalPoint(2) );
	}

	@Then("my third frame i got total of {string} points")
	public void my_third_frame_i_got_total_of_points(String string) {
		assertEquals ( Integer.parseInt ( string ),
				game.getFrameTotalPoint(3) );
	}

}
