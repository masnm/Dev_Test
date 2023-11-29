package UnitTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import game.Game;
import game.RandomRollInterface;

public class GameClassSpareTest {

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
			// making the first frame first roll 8 pointer
			oneOf(roller).getRandomNumber(10);
			will(returnValue(8));
			// making the first frame second roll 2 pointer
			// which is the spare for this frame
			oneOf(roller).getRandomNumber(2);
			will(returnValue(2));
			// making the second frame first roll 3 pointer
			oneOf(roller).getRandomNumber(10);
			will(returnValue(3));
			// making the second frame second roll 4 pointer
			oneOf(roller).getRandomNumber(7);
			will(returnValue(4));
		}});
		
		// performing the first roll
		game.performNextRoll ();
		int firstRollValue = game.getPreviousRollResult ();
		assertTrue ( firstRollValue == 8 );

		game.performNextRoll ();
		int secondRollValue = game.getPreviousRollResult ();
		assertTrue ( secondRollValue == 2 );
		
		assertFalse ( game.getFrameInfo ( 1, "Strike" ) );
		assertTrue ( game.getFrameInfo ( 1, "Spare" ) );
		
		game.performNextRoll ();
		int thirdRollValue = game.getPreviousRollResult ();
		assertTrue ( thirdRollValue == 3 );
		
		game.performNextRoll ();
		int fourthRollValue = game.getPreviousRollResult ();
		assertTrue ( fourthRollValue == 4 );

		// making sure the score are calcuated properly
		assertTrue ( game.getFrameTotalPoint ( 1 ) == 13 );
		assertTrue ( game.getFrameTotalPoint ( 2 ) == 20 );
		
		// making sure mocked object done it's job properly
		mockery.assertIsSatisfied();
	}

}
