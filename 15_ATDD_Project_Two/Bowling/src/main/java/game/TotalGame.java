package game;

class TotalGame {
	Frame[] frames = null;
	int presentFrame;
	int presentRoll;
	boolean gameOver;
	
	public TotalGame () {
		this.presentFrame = 0;
		this.presentRoll = 0;
		this.frames = new Frame[10];
		for ( int i = 0; i < frames.length; ++i ) {
			frames[i] = new Frame ( i + 1 );
		}
		this.gameOver = false;
	}
	
	public void showCurrentScore () {
		for ( Frame frame : frames ) {
			System.out.println ( "Frame : " + frame.getFrameNo() );
			if ( frame.getFrameNo() == 10 ) {
				System.out.printf ( "%4s%s%4s%s%4s\n", frame.getFirstRoll()," | ", frame.getSecondRoll(), " | ", frame.getThirdRoll() );
			} else {
				System.out.printf ( "%4s%s%4s\n", frame.getFirstRoll()," | ", frame.getSecondRoll() );
			}
			System.out.printf ( "Frame Total : %s\n\n", frame.getFinalScore() );
		}
	}
	
	public int getPreviousFrameTotalPoint () {
		if ( presentFrame == 0 )
			throw new IllegalArgumentException ( "No previous frame exist" );
		return getFrameTotalPoint ( presentFrame - 1 );
	}
	
	public boolean getPreviousFrameInfo ( String info ) {
		if ( presentFrame == 0 )
			throw new IllegalArgumentException ( "No previous frame exist" );
		return getFrameInfo ( presentFrame - 1, info );
	}
	
	private int getThisFrameRemainingPin () {
		if ( this.presentRoll == 0 ) return 10;
		else if ( this.presentRoll == 1 )
			return 10 - this.frames[this.presentFrame].getFirstRoll();
		else 
			return 10;
	}
	
	private void updatePresentScores () {
		if ( presentFrame != 0 && presentRoll == 0 ) {
			frames[presentFrame].updateScore(frames[presentFrame - 1].getFinalScore());
		}
		int knocked = -1;
		if ( presentRoll == 0 ) {
			knocked = frames[presentFrame].getFirstRoll ();
		} else if ( presentRoll == 1 ) {
			knocked = frames[presentFrame].getSecondRoll ();
		} else {
			knocked = frames[presentFrame].getThirdRoll ();
		}
		frames[presentFrame].updateScore(knocked);
		if ( presentFrame != 0 && presentRoll == 0 ) {
			if ( frames[presentFrame - 1].getFrameInfo("Strike")
					|| frames[presentFrame - 1].getFrameInfo("Spare") ) {
				frames[presentFrame - 1].updateScore(knocked);
				frames[presentFrame].updateScore(knocked);
			}
		}
		if ( presentFrame > 1 && presentRoll == 0 ) {
			if ( frames[presentFrame - 1].getFrameInfo("Strike")
					&& frames[presentFrame - 2].getFrameInfo("Strike") ) {
				frames[presentFrame - 2].updateScore(knocked);
				frames[presentFrame - 1].updateScore(knocked);
				frames[presentFrame].updateScore(knocked);
			}
		}
		if ( presentFrame != 0 && presentRoll == 1 ) {
			if ( frames[presentFrame - 1].getFrameInfo("Strike") ) {
				frames[presentFrame - 1].updateScore(knocked);
				frames[presentFrame].updateScore(knocked);
			}
		}
	}
	
	public void performNextRoll ( RandomRollInterface roller ) {
		if ( gameOver ) return;

		int knocked = roller.getRandomNumber ( getThisFrameRemainingPin() );
		// updating roll value
		if ( presentRoll == 0 ) {
			frames[presentFrame].setFirstRoll ( knocked );
		} else if ( presentRoll == 1 ) {
			frames[presentFrame].setSecondRoll ( knocked );
		} else {
			frames[presentFrame].setThirdRoll ( knocked );
		}
		// updating strike / spare flag
		if ( presentRoll == 0 && knocked == 10 ) {
			frames[presentFrame].setFrameInfo ( "Strike", true );
		}
		if ( presentRoll == 1 ) {
			int frameTotal = frames[presentFrame].getFirstRoll() + frames[presentFrame].getSecondRoll();
			frames[presentFrame].setFrameInfo("Spare", frameTotal == 10 );
		}
		// updating the score
		updatePresentScores ();
		// going to next frame / roll
		if ( frames[presentFrame].getFrameNo() != 10 ) {
			if ( frames[presentFrame].getFrameInfo("Strike")
					|| frames[presentFrame].getFrameInfo("Spare") ) {
				++presentFrame;
				presentRoll = 0;
			} else {
				++presentRoll;
				if ( presentRoll > 1 ) {
					++presentFrame;
					presentRoll = 0;
				}
			}
		} else {
			if ( presentRoll == 0 ) {
				++presentRoll;
			} else if ( presentRoll == 1 ) {
				if ( frames[presentFrame].getFrameInfo("Strike")
						|| frames[presentFrame].getFrameInfo("Spare") ) {
					++presentRoll;
				} else {
					gameOver = true;
				}
			} else if ( presentRoll == 2 ) {
				gameOver = true;
			}
		}
		// check end condition
	}
	
	public int getPreviousRollResult () {
		if ( gameOver ) {
			if ( frames[9].getFrameInfo("Strike") || frames[9].getFrameInfo("Spare") ) {
				return frames[9].getThirdRoll ();
			} else {
				return frames[9].getSecondRoll ();
			}
		}
		if ( presentRoll == 1 ) {
			return frames[presentFrame].getFirstRoll();
		}
		if ( presentRoll == 2 ) {
			return frames[presentFrame].getSecondRoll();
		}
		if ( presentRoll == 0 ) {
			if ( presentFrame == 0 ) {
				throw new IllegalArgumentException ( "Can't find the previous roll result!" );
			}
			if ( frames[presentFrame - 1].getFrameInfo("Strike") )
				return frames[presentFrame - 1].getFirstRoll();
			else
				return frames[presentFrame - 1].getSecondRoll();
		}
		// will never happen
		return -1000000;
	}
	
	public boolean getFrameInfo ( int index, String info ) {
		return frames[index].getFrameInfo(info);
	}
	
	public int getFrameTotalPoint ( int index ) {
		return frames[index].getFinalScore();
	}
}