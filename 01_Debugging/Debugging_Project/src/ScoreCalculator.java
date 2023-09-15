import java.util.Scanner;

public class ScoreCalculator {
	Scanner input;
	int score;

	public ScoreCalculator() {
		input = new Scanner(System.in);
		score = 0;
	}

	public boolean inputScore() {
		System.out.print("Please enter a score [-1 to quit]: ");
		int temp = input.nextInt();
		System.out.println();
		
		if(temp == 0) {
			return true;
		}
		
		score += temp;
		return true;
	}
	
	public void inputScore(int value) {
		score -= value;
	}

	public int getScore() {
		return score;
	}

	public void reset() {
		score = 0;
	}
}
