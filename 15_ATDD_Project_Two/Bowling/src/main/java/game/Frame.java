package game;

public class Frame {
	private boolean strike, spare;
	private int frameNo;
	private int firstRoll, secondRoll, thirdRoll;
	private int finalScore;

	public Frame ( int frameNo ) {
		this.strike = spare = false;
		this.frameNo = frameNo;
		this.firstRoll = 0;
		this.secondRoll = 0;
		this.thirdRoll = 0;
		this.finalScore = 0;
	}
	
	public int getFinalScore () {
		return this.finalScore;
	}
	
	public void updateScore ( int score ) {
		this.finalScore += score;
	}
	
	public int getFirstRoll () {
		return firstRoll;
	}
	
	public void setFirstRoll ( int firstRoll ) {
		this.firstRoll = firstRoll;
	}
	
	public int getSecondRoll() {
		return secondRoll;
	}

	public void setSecondRoll(int secondRoll) {
		this.secondRoll = secondRoll;
	}

	public int getThirdRoll() {
		return thirdRoll;
	}

	public void setThirdRoll(int thirdRoll) {
		this.thirdRoll = thirdRoll;
	}

	public int getFrameNo () {
		return this.frameNo;
	}
	
	public void setFrameInfo ( String info, boolean flag ) {
		if ( info.equals("Strike") )
			this.strike = flag;
		else if ( info.equals("Spare") )
			this.spare = flag;
		else
			throw new IllegalArgumentException ( "Unknown info flag" );
	}
	
	public boolean getFrameInfo ( String info ) {
		if ( info.equals("Strike") )
			return this.strike;
		else if ( info.equals("Spare") )
			return this.spare;
		else
			throw new IllegalArgumentException ( "Unknown info flag" );
	}
}
