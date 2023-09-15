
public class SteppingDemo {
	
	public int some_variable;

	public static void main(String[] args) {
		
		System.out.println("Printing to the output console - main method");
		SteppingDemo step = new SteppingDemo();

		int flag = 0;
		for ( int a = 0; a <= 6; a++) {
			step.StepOverMe(); //F6
			if( flag == 6){ 
				step.StepIntoMe(); //F5
			}
			flag++;
		}
	}


	public void StepOverMe()
	{
		System.out.println("StepOver");
		some_variable += 2;
	}
	
	public void StepIntoMe()
	{
		System.out.println("StepInto");
		StringBuffer str = new StringBuffer();
		str.append('T');
		str.append('h');
		str.append('i');
		str.append('s');
		str.append(' ');
		str.append('i');
		str.append('s');
		str.append(' ');
		str.append('a');
		str.append(' ');
		str.append('s');
		str.append('t');
		str.append('r');
		str.append('i');
		str.append('n');
		str.append('g');
		System.out.println(str.toString());
	}

}

// (flag == 6) &&
// (a == 4) &&



