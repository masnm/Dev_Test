package game;

public class RandomRoll implements RandomRollInterface {

	@Override
	public int getRandomNumber ( int maxAllowed ) {
		return (int)(Math.random() * ( maxAllowed + 1 ) );
	}
}
