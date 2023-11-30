package steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.jmock.Expectations;
import org.jmock.Mockery;

import game.Game;
import game.RandomRollInterface;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SimpleSecondFrame {

	// defining the Game object
	private Game game = null;
	private Mockery mockery = null;
	private RandomRollInterface roller = null;
	
	@Given("the previous frame has {string} points on the board")
	public void the_previous_frame_has_points_on_the_board(String string) {
		mockery = new Mockery ();
		roller = mockery.mock ( RandomRollInterface.class );
		game = new Game ( roller );
		
		final int exScore = Integer.parseInt ( string );
		final int half = exScore / 2;
		
		mockery.checking(new Expectations () {{
			oneOf(roller).getRandomNumber(10);
			will(returnValue (half));
		}});
		game.performNextRoll();
		mockery.checking(new Expectations () {{
			oneOf(roller).getRandomNumber(10 - half);
			will(returnValue (exScore - half));
		}});
		game.performNextRoll();
	}

	@Given("previous frame is not an strike or an spare")
	public void previous_frame_is_not_an_strike_or_an_spare() {
		assertFalse ( game.getPreviousFrameInfo("Strike") );
		assertFalse ( game.getPreviousFrameInfo("Spare") );
	}

	@When("I got {string} pins knock on the first roll")
	public void i_got_pins_knock_on_the_first_roll(String string) {
		final int number = Integer.parseInt(string);
		mockery.checking(new Expectations () {{
			oneOf(roller).getRandomNumber(10);
			will(returnValue (number));
		}});
		game.performNextRoll();
	}

	@When("I got {string} pins knock on the second roll")
	public void i_got_pins_knock_on_the_second_roll(String string) {
		final int number = Integer.parseInt(string);
		mockery.checking(new Expectations () {{
			oneOf(roller).getRandomNumber(10 - game.getPreviousRollResult());
			will(returnValue (number));
		}});
		game.performNextRoll();
	}

	@Then("I got a total of {string} score in this second frame")
	public void i_got_a_total_of_score_in_this_second_frame(String string) {
		int foundScore = game.getPreviousFrameTotalPoint();
		assertEquals ( foundScore, Integer.parseInt(string) );
		mockery.assertIsSatisfied();
	}

}
