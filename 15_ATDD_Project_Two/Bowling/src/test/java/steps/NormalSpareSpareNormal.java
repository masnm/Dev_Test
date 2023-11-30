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

public class NormalSpareSpareNormal {
	// defining the Game object
	private Game game = null;
	private Mockery mockery = null;
	private RandomRollInterface roller = null;

	@Given("first frame first roll gives {string} pointss")
	public void first_frame_first_roll_gives_pointss(String string) {
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

	@Given("frist frame second roll gives {string} pointss")
	public void frist_frame_second_roll_gives_pointss(String string) {
		final int called = 10 - game.getPreviousRollResult();
		final int number = Integer.parseInt(string);
		mockery.checking(new Expectations () {{
			oneOf(roller).getRandomNumber(called);
			will(returnValue(number));
		}});
		game.performNextRoll();
	}

	@When("i get second frame first roll {string} pinss")
	public void i_get_second_frame_first_roll_pinss(String string) {
		final int number = Integer.parseInt(string);
		mockery.checking(new Expectations () {{
			oneOf(roller).getRandomNumber(10);
			will(returnValue(number));
		}});
		game.performNextRoll();
	}

	@When("i get second frame second roll {string} pinss")
	public void i_get_second_frame_second_roll_pinss(String string) {
		final int called = 10 - game.getPreviousRollResult();
		final int number = Integer.parseInt(string);
		mockery.checking(new Expectations () {{
			oneOf(roller).getRandomNumber(called);
			will(returnValue(number));
		}});
		game.performNextRoll();
	}

	@When("which makes this frame as an sparee")
	public void which_makes_this_frame_as_an_sparee() {
		assertTrue ( game.getPreviousFrameInfo("Spare") );
	}

	@When("i get third frame first roll {string} pinss")
	public void i_get_third_frame_first_roll_pinss(String string) {
		final int number = Integer.parseInt(string);
		mockery.checking(new Expectations () {{
			oneOf(roller).getRandomNumber(10);
			will(returnValue(number));
		}});
		game.performNextRoll();
	}

	@When("i get third frame second roll {string} pinss")
	public void i_get_third_frame_second_roll_pinss(String string) {
		final int called = 10 - game.getPreviousRollResult();
		final int number = Integer.parseInt(string);
		mockery.checking(new Expectations () {{
			oneOf(roller).getRandomNumber(called);
			will(returnValue(number));
		}});
		game.performNextRoll();
	}

	@When("which makes this frame as spare againn")
	public void which_makes_this_frame_as_spare_againn() {
		assertTrue ( game.getPreviousFrameInfo("Spare") );
	}

	@When("fourth frame first roll i got {string} pointss")
	public void fourth_frame_first_roll_i_got_pointss(String string) {
		final int number = Integer.parseInt(string);
		mockery.checking(new Expectations () {{
			oneOf(roller).getRandomNumber(10);
			will(returnValue(number));
		}});
		game.performNextRoll();
	}

	@When("fourth frame second roll i got {string} pointss")
	public void fourth_frame_second_roll_i_got_pointss(String string) {
		final int called = 10 - game.getPreviousRollResult();
		final int number = Integer.parseInt(string);
		mockery.checking(new Expectations () {{
			oneOf(roller).getRandomNumber(called);
			will(returnValue(number));
		}});
		game.performNextRoll();
	}

	@Then("first frame i got total of {string} pointss")
	public void first_frame_i_got_total_of_pointss(String string) {
		assertEquals ( Integer.parseInt ( string ),
				game.getFrameTotalPoint(1) );
	}

	@Then("second frame i got total of {string} pointss")
	public void second_frame_i_got_total_of_pointss(String string) {
		assertEquals ( Integer.parseInt ( string ),
				game.getFrameTotalPoint(2) );
	}

	@Then("third frame i got total of {string} pointss")
	public void third_frame_i_got_total_of_pointss(String string) {
		assertEquals ( Integer.parseInt ( string ),
				game.getFrameTotalPoint(3) );
	}

	@Then("fourth frame i got total of {string} pointss")
	public void fourth_frame_i_got_total_of_pointss(String string) {
		assertEquals ( Integer.parseInt ( string ),
				game.getFrameTotalPoint(4) );
	}

}