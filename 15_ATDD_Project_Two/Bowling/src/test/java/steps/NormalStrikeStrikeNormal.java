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

public class NormalStrikeStrikeNormal {
	
	// defining the Game object
	private Game game = null;
	private Mockery mockery = null;
	private RandomRollInterface roller = null;

	@Given("my first frame first roll gives {string} pointss")
	public void my_first_frame_first_roll_gives_pointss(String string) {
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

	@Given("my frist frame second roll gives {string} pointss")
	public void my_frist_frame_second_roll_gives_pointss(String string) {
		final int called = 10 - game.getPreviousRollResult();
		final int number = Integer.parseInt(string);
		mockery.checking(new Expectations () {{
			oneOf(roller).getRandomNumber(called);
			will(returnValue(number));
		}});
		game.performNextRoll();
	}

	@When("my get second frame first roll {string} pinss")
	public void my_get_second_frame_first_roll_pinss(String string) {
		final int number = Integer.parseInt(string);
		mockery.checking(new Expectations () {{
			oneOf(roller).getRandomNumber(10);
			will(returnValue(number));
		}});
		game.performNextRoll();
	}

	@When("my which makes this frame as an strikee")
	public void my_which_makes_this_frame_as_an_strikee() {
		assertTrue ( game.getPreviousFrameInfo("Strike") );
	}

	@When("my get third frame first roll {string} pinss")
	public void my_get_third_frame_first_roll_pinss(String string) {
		final int number = Integer.parseInt(string);
		mockery.checking(new Expectations () {{
			oneOf(roller).getRandomNumber(10);
			will(returnValue(number));
		}});
		game.performNextRoll();
	}

	@When("my which makes this frame as an strike againn")
	public void my_which_makes_this_frame_as_an_strike_againn() {
		assertTrue ( game.getPreviousFrameInfo("Strike") );
	}

	@When("my fourth frame first roll i got {string} pointss")
	public void my_fourth_frame_first_roll_i_got_pointss(String string) {
		final int number = Integer.parseInt(string);
		mockery.checking(new Expectations () {{
			oneOf(roller).getRandomNumber(10);
			will(returnValue(number));
		}});
		game.performNextRoll();
	}

	@When("my fourth frame second roll i got {string} pointss")
	public void my_fourth_frame_second_roll_i_got_pointss(String string) {
		final int called = 10 - game.getPreviousRollResult();
		final int number = Integer.parseInt(string);
		mockery.checking(new Expectations () {{
			oneOf(roller).getRandomNumber(called);
			will(returnValue(number));
		}});
		game.performNextRoll();
	}

	@Then("my first frame i got total of {string} pointss")
	public void my_first_frame_i_got_total_of_pointss(String string) {
		assertEquals ( Integer.parseInt ( string ),
				game.getFrameTotalPoint(1) );
	}

	@Then("my second frame i got total of {string} pointss")
	public void second_frame_i_got_total_of_pointss(String string) {
		assertEquals ( Integer.parseInt ( string ),
				game.getFrameTotalPoint(2) );
	}

	@Then("my third frame i got total of {string} pointss")
	public void my_third_frame_i_got_total_of_pointss(String string) {
		assertEquals ( Integer.parseInt ( string ),
				game.getFrameTotalPoint(3) );
	}

	@Then("my fourth frame i got total of {string} pointss")
	public void my_fourth_frame_i_got_total_of_pointss(String string) {
		assertEquals ( Integer.parseInt ( string ),
				game.getFrameTotalPoint(4) );
	}

}