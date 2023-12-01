package UnitTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import game.Game;
import game.RandomRollInterface;

public class GameClassStrikeTest {
	
	// All the objects that we will use to so this testing
	// and for mocking the object
	private Mockery mockery = null;
	private Game game = null;
	private RandomRollInterface roller = null;
	
	@Before
	public void init () {
		mockery = new Mockery ();
		roller = mockery.mock(RandomRollInterface.class);
		game = new Game ( roller );
	}
	
	@Test
	public void gameTest () {
		mockery.checking(new Expectations () {{
			// making the first frame first roll the strike
			oneOf(roller).getRandomNumber(10);
			will(returnValue(10));
			// making the second frame first roll 3 pointer
			oneOf(roller).getRandomNumber(10);
			will(returnValue(3));
			// making the second frame second roll 4 pointer
			oneOf(roller).getRandomNumber(7);
			will(returnValue(4));
		}});
		
		// we are doing an strike in the first frame
		game.performNextRoll ();
		int firstRollValue = game.getPreviousRollResult ();
		assertTrue ( firstRollValue == 10 );
		
		// making sure the game object marks the previous frame as an strike
		// also making sure the previous frame is not an spare
		assertTrue ( game.getFrameInfo ( 1, "Strike" ) );
		assertFalse ( game.getFrameInfo ( 1, "Spare" ) );
		
		// doing an normal frame as the second frame
		game.performNextRoll ();
		int secondRollValue = game.getPreviousRollResult ();
		assertTrue ( secondRollValue == 3 );
		
		game.performNextRoll ();
		int thirdRollValue = game.getPreviousRollResult ();
		assertTrue ( thirdRollValue == 4 );
		
		// making sure the score are calculate properly
		assertTrue ( game.getFrameTotalPoint ( 1 ) == 17 );
		assertTrue ( game.getFrameTotalPoint ( 2 ) == 24 );
		
		// making sure mocked object done it's job properly
		mockery.assertIsSatisfied();
	}

}
