package UnitTest;

import static org.junit.Assert.assertTrue;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import game.RandomRollInterface;

public class RandomRollMock {
	
	// defining the class objects we are going to use
	Mockery mockery = null;
	RandomRollInterface randomRoll = null;
	
	@Before
	public void init () {
		// creating the mocking object
		mockery = new Mockery ();
	}
	
	@Test
	public void getMaxAlloweValueTest () {
		// mocking the random roll object form it's interface
		randomRoll = mockery.mock ( RandomRollInterface.class );
		
		// setting the rules for the mocked object
		mockery.checking( new Expectations () {{
			// looping over all the possible values we need to consider
			for ( int i = 0; i <= 10; ++i ) {
				// setting rule that the input is the output
				oneOf(randomRoll).getRandomNumber(i);
				will(returnValue(i));
			}
		}});
		
		// looping over all the possible allowed values we will ever use in our
		// real application
		for ( int maxAllowedValue = 0; maxAllowedValue <= 10; ++maxAllowedValue ) {
			// as we mocked the object now we expect that the return value will be
			// exactly same as the input we provide i.e. maxAlloweValue
			int generatedValue = randomRoll.getRandomNumber ( maxAllowedValue );

			// making sure that the input and output is exactly the same
			assertTrue ( generatedValue == maxAllowedValue );
		}
		
		// making sure mocked object done it's job properly
		mockery.assertIsSatisfied();
	}
}
