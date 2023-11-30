package steps;

import static org.junit.Assert.assertEquals;

import org.jmock.Expectations;
import org.jmock.Mockery;

import game.Game;
import game.RandomRollInterface;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OneSimpleFrame {
	
	// defining the Game object
	private Game game = null;
	private Mockery mockery = null;
	private RandomRollInterface roller = null;
	
	@Given("I just started the game")
	public void i_just_started_the_game() {
		mockery = new Mockery ();
		roller = mockery.mock ( RandomRollInterface.class );
		game = new Game ( roller );
	}

	@When("I got {string} pins knock on the first try")
	public void i_got_pins_knock_on_the_first_try(String string) {
		final int number = Integer.parseInt(string);
		mockery.checking(new Expectations () {{
			oneOf(roller).getRandomNumber(10);
			will(returnValue(number));
		}});
		game.performNextRoll();
	}

	@When("I got {string} pins knock on the second try")
	public void i_got_pins_knock_on_the_second_try(String string) {
		final int thisCalls = 10 - game.getPreviousRollResult();
		final int number = Integer.parseInt(string);
		mockery.checking(new Expectations () {{
			oneOf(roller).getRandomNumber(thisCalls);
			will(returnValue(number));
		}});
		game.performNextRoll();
	}

	@Then("I got a total of {string} score in this frame")
	public void i_got_a_total_of_score_in_this_frame(String string) {
		int calculatedScore = game.getFrameTotalPoint ( 1 );
		assertEquals ( Integer.parseInt(string), calculatedScore );
		mockery.assertIsSatisfied();
	}


}
