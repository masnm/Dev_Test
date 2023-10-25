import static org.junit.jupiter.api.Assertions.assertEquals;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestClass {
	
	static Mockery mock;
	static Calculator calc;
	
	@BeforeAll
	public static void init () {
		mock = new Mockery ();
	}
	
	@BeforeEach
	public void before_each () {
		calc = new Calculator ();
	}
	
	@Test
	public void testCalculate () {
		
		TextToInterface ttf = mock.mock(TextToInterface.class);
		
		mock.checking(new Expectations () {{

			oneOf(ttf).stringToOperation("add");
			will(returnValue('+'));

			oneOf(ttf).stringToOperation("mul");
			will(returnValue('*'));
			
		}});
		
		char op = ttf.stringToOperation("addany");
		System.out.println ( op );
		
		assertEquals ( 4, calc.calculate( op, 2, 2 ));
		
		op = ttf.stringToOperation("mul");
		assertEquals ( 15, calc.calculate(op, 3, 5));
		
	}
}
