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

public class NormalSpareNormal {

	// defining the Game object
	private Game game = null;
	private Mockery mockery = null;
	private RandomRollInterface roller = null;

	@Given("first frame first roll gives {string} points")
	public void first_frame_first_roll_gives_points(String string) {
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

	@Given("frist frame second roll gives {string} points")
	public void frist_frame_second_roll_gives_points(String string) {
		final int called = 10 - game.getPreviousRollResult();
		final int number = Integer.parseInt(string);
		mockery.checking(new Expectations () {{
			oneOf(roller).getRandomNumber(called);
			will(returnValue(number));
		}});
		game.performNextRoll();
	}

	@When("i get second frame first roll {string} pins")
	public void i_get_second_frame_first_roll_pins(String string) {
		final int number = Integer.parseInt(string);
		mockery.checking(new Expectations () {{
			oneOf(roller).getRandomNumber(10);
			will(returnValue(number));
		}});
		game.performNextRoll();
	}

	@When("i get second frame second roll {string} pins")
	public void i_get_second_frame_second_roll_pins(String string) {
		final int called = 10 - game.getPreviousRollResult();
		final int number = Integer.parseInt(string);
		mockery.checking(new Expectations () {{
			oneOf(roller).getRandomNumber(called);
			will(returnValue(number));
		}});
		game.performNextRoll();
	}

	@When("which makes this frame as an spare")
	public void which_makes_this_frame_as_an_spare() {
		assertTrue ( game.getPreviousFrameInfo("Spare") );
	}

	@When("third frame first roll i got {string} points")
	public void third_frame_first_roll_i_got_points(String string) {
		final int number = Integer.parseInt(string);
		mockery.checking(new Expectations () {{
			oneOf(roller).getRandomNumber(10);
			will(returnValue(number));
		}});
		game.performNextRoll();
	}

	@When("third frame second roll i got {string} points")
	public void third_frame_second_roll_i_got_points(String string) {
		final int called = 10 - game.getPreviousRollResult();
		final int number = Integer.parseInt(string);
		mockery.checking(new Expectations () {{
			oneOf(roller).getRandomNumber(called);
			will(returnValue(number));
		}});
		game.performNextRoll();
	}

	@Then("first frame i got total of {string} points")
	public void first_frame_i_got_total_of_points(String string) {
		assertEquals ( Integer.parseInt ( string ),
				game.getFrameTotalPoint(1) );
	}

	@Then("second frame i got total of {string} points")
	public void second_frame_i_got_total_of_points(String string) {
		assertEquals ( Integer.parseInt ( string ),
				game.getFrameTotalPoint(2) );
	}

	@Then("third frame i got total of {string} points")
	public void third_frame_i_got_total_of_points(String string) {
		assertEquals ( Integer.parseInt ( string ),
				game.getFrameTotalPoint(3) );
	}

}
