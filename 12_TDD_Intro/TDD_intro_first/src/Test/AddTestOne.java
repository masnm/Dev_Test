package Test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import Source.Calculator;

public class AddTestOne {
	
	Calculator calc;
	
	@BeforeEach
	public void init () {
		calc = new Calculator ();
	}
	
	@ParameterizedTest
	@CsvSource( {"3,5,8", "2,3,5", "-4,-2,-6"} )
	public void addTestfirst ( int firstOperand, int secondOperand, int expectedOutput) {
		
		int actualOutput = calc.add ( firstOperand, secondOperand );
		
		assertEquals ( expectedOutput, actualOutput );
	}
	
	
	@ParameterizedTest
	@CsvSource( {"3,5,-2", "2,3,-1", "-4,-5,1"} )
	public void subTestFirst ( int firstOperand, int secondOperand, int expectedValue ) {
		int actualValue = calc.substract ( firstOperand, secondOperand );
		assertEquals ( expectedValue, actualValue );
	}

}
