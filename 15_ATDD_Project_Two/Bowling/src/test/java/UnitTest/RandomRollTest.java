package UnitTest;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import game.RandomRoll;
import game.RandomRollInterface;

public class RandomRollTest {
	
	// object of the testing class declaration
	public RandomRollInterface roll = null;
	
	@Before
	public void init () {
		roll = new RandomRoll ();
	}

	// checking if the generator generates a random number in between the given range or not
	@Test
	public void randomNmberGeneratorTest () {
		
		// maxAllowedValue is the maximum value that the random generator should generate
		// looping this over from 0 to 10 because in our case that't all the values we
		// will ever going to use
		for ( int maxAllowedValue = 0; maxAllowedValue <= 10; ++maxAllowedValue ) {
			// generating the random number and providing the range upper bound
			// if only one value is provided then lower limit set to by default zero
			int generatedValue = roll.getRandomNumber ( maxAllowedValue );

			// making sure the generated number is in the range
			assertTrue ( generatedValue <= maxAllowedValue );
			assertTrue ( generatedValue >= 0 );
		}
	}

}
