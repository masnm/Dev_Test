import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import org.jmock.Mockery;
import org.jmock.Expectations;

public class TestClass {

	Mockery mock;
	
	@BeforeEach
	void Setup() {
		mock = new Mockery();
	}
	
	@Test
	void TestCase() {
		
		//create the mock object
		final ICalculator calculator = mock.mock(ICalculator.class);
		
		//setup the mocked behavior
		//function calls/return values
		mock.checking(new Expectations(){{
            oneOf(calculator).Add(0, 1);
            will(returnValue(1));
            // oneOf(calculator).Add(12,12);
		}});
		
		//we can now use the mock object just
		//like we had the real thing
		assertEquals(1, calculator.Add(0, 1)); 

		//this will not work as we didn't tell 
		//the mock object what to do in this case
		//assertEquals(1, calculator.Add(1, 1)); 
		
		//assert that all the functions where 
		//called as expected on the mock object
		mock.assertIsSatisfied();
	}
}
