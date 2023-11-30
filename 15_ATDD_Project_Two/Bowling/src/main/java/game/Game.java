package game;

public class Game {
	
	private TotalGame totalGame;
	private RandomRollInterface roller;
	
	public Game ( RandomRollInterface roller ) {
		this.totalGame = new TotalGame ();
		this.roller = roller;
	}
	
	public void performNextRoll () {
		totalGame.performNextRoll ( roller );
	}
	
	public int getPreviousRollResult () {
		return totalGame.getPreviousRollResult();
	}
	
	public boolean getFrameInfo ( int frameNumber, String infoFlag ) {
		return totalGame.getFrameInfo ( frameNumber - 1, infoFlag );
	}
	
	public boolean getPreviousFrameInfo ( String infoFlag ) {
		return totalGame.getPreviousFrameInfo ( infoFlag );
	}
	
	public int getFrameTotalPoint ( int frameNumber ) {
		return totalGame.getFrameTotalPoint ( frameNumber - 1 );
	}
	
	public int getPreviousFrameTotalPoint () {
		return totalGame.getPreviousFrameTotalPoint ();
	}

}
