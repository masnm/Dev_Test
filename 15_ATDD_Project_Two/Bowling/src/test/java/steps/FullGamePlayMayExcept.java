package steps;

import static org.junit.jupiter.api.Assertions.assertFalse;

import game.Game;
import game.RandomRoll;
import game.RandomRollInterface;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FullGamePlayMayExcept {
	
	private RandomRollInterface roller = null;
	private Game game = null;
	private boolean badHappend = false;

	@Given("i just started the game")
	public void i_just_started_the_game() {
		roller = new RandomRoll ();
		game = new Game ( roller );
		badHappend = false;
	}

	@When("i do roll untill the game is over")
	public void i_do_roll_untill_the_game_is_over() {
		try {
			while ( !game.isGameOver() ) {
				game.performNextRoll();
			}
		} catch ( Exception ex ) {
			badHappend = true;
		}
	}

	@Then("i make sure nothing goes bad")
	public void i_make_sure_nothing_goes_bad() {
		assertFalse ( badHappend );
	}

}
