public class DebugMe1 {

	public static void main(String[] args) {

		ScoreCalculator calculator = new ScoreCalculator();

		while (calculator.inputScore()) {
		}

		System.out.println("Your total score is " + calculator.getScore());
		
		calculator.reset();
		
		System.out.println("\nTesting with values 1-10"); //1,2,3,4,5,6,7,8,9 (45 total)
		
		int expected = 0;
		for(int i=0; i<10; ++i) {
			expected += i;
			calculator.inputScore(i);
		}
		
		assert calculator.getScore() == expected : "Score does not equal expected value";
		System.out.println("Your total score is " + calculator.getScore());
	}

}
