package game;

import java.util.Scanner;

public class Main {
	
	private Scanner scanner = null;
	private Game game = null;
	private RandomRollInterface roller = null;
	
	public Main () {
		scanner = new Scanner ( System.in );
		roller = new RandomRoll ();
		this.game = new Game ( roller );
	}

	public static void main(String[] args) {
		Main main = new Main ();
		
		while ( !main.game.isGameOver() ) {
			System.out.print ( "Press any key to next Roll : " );
			main.scanner.next();
			main.game.performNextRoll();
			main.game.showCurrentScore ();
		}
		
		System.out.println ( "Total Game Score is : " + main.game.getFrameTotalPoint(10) );
	}

}
