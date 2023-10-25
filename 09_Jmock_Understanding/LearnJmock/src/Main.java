
public class Main {
	public static void main ( String [] args ) {
		TextToInterface gen = new Generator ();
		Calculator cal = new Calculator ();
		
		char op = gen.stringToOperation("adciqdfkjsd" );
		
		System.out.println ( cal.calculate(op, 2, 3) );
	}
}
