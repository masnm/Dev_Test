package UnitTest;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Before;
import org.junit.Test;

import game.Game;
import game.RandomRoll;
import game.RandomRollInterface;

public class GameMayException {
	
	private Game game = null;
	private RandomRollInterface roller = null;
	
	@Before
	public void init () {
		roller = new RandomRoll ();
		game = new Game ( roller );
	}
	
	@Test
	public void exceptionTestIfAny () {
		try {
			// this test test's if any exception is thrown
			// we expect no exception will be thrown

			// while there is more roll to do
			while ( !game.isGameOver() ) {
				// do an roll
				game.performNextRoll();
			}
		} catch ( Exception ex ) {
			fail ( "Exception thrown where not should be" );
		}
	}
	
	@Test
	public void thousandGamePlay () {
		// this test test's if any exception is thrown
		// we expect no exception will be thrown

		// repeating playing a game for thousands time
		for ( int rep = 0; rep < 1000; ++rep ) {
			try {
				// this test test's if any exception is thrown
				// we expect no exception will be thrown

				// while there is more roll to do
				while ( !game.isGameOver() ) {
					// do an roll
					game.performNextRoll();
				}
			} catch ( Exception ex ) {
				fail ( "Exception thrown where not should be" );
			}
		}
	}

}
