
public class AssertDemo {

	public static void main(String[] args) {
			
		//asserts only run in DEBUG mode and MUST be
		//turned on via JVM flags (-enableassertions or -ea)
		
		//asserts are used for confirming required conditions/values in
		//our code
		
		//eg. we have an int that must be postitive (>=0) value
		int a = -1;	 
		
		//we can use the assert keyword and a statement 
		//that evaluates to true/false (just like an if)
		// assert a >= 0;
		
		//we can also add a meaningful message to the assert
		a=-1;
		assert a != -1 : "'a==-1' && check the value of 'a'";
	}

}
