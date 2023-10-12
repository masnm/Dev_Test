import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestAdvice 
{
	static Advice advice;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		advice = new Advice();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() 
	{
		try
		{
			advice.getAdvice(2, 'a');
		}
		catch( BooBoo b )
		{
			b.ouch();
		}
		fail("Not yet implemented");
	}

	// prepare for jupiter paramiterized test
	@BeforeAll
	public static void initJup () {
		advice = new Advice ();
	}
	
	
	// this method test some positive test cases
	@ParameterizedTest
	@CsvSource ( {
		"2,'a',true",
		"3,'b',false",
		"5,'b',false",
		"6,'x',true"
	} )
	public void positiveTests ( int inpInt, char inpChar, boolean expAns ) {
		boolean found = !expAns;
		try {
			found = advice.getAdvice ( inpInt, inpChar );
		} catch (BooBoo e) {
			fail ( "Exception thrown when not expected " );
		}
		Assert.assertEquals ( expAns, found );
	}
	

	// this method test some edge case test cases
	@ParameterizedTest
	@CsvSource ( {
		"-2147483648,'a',true",
		"2147483647,'b',false",
		"0,'?',true",
		"2,' ',true"
	} )
	public void edgeCaseTests ( int inpInt, char inpChar, boolean expAns ) {
		boolean found = !expAns;
		try {
			found = advice.getAdvice ( inpInt, inpChar );
		} catch (BooBoo e) {
			fail ( "Exception thrown at edge case when not expected " );
		}
		Assert.assertEquals ( expAns, found );
	}
	
	// this method test some negative case test
	@ParameterizedTest
	@CsvSource ( {
		"1,'a',false",
		"1,'b',true",
		"0,'z',true",
		"1,'z',false"
	} )
	public void negativeTests ( int inpInt, char inpChar, boolean expAns ) {
		boolean exceptionFound = false;
		try {
			advice.getAdvice ( inpInt, inpChar );
		} catch (BooBoo e) {
			exceptionFound = true;
		}
		Assert.assertEquals ( true, exceptionFound );
	}
	
	// this method test some exception case test
	@ParameterizedTest
	@CsvSource ( {
		"1,'a'",
		"1,'z'",
		"25,'z'"
	} )
	public void exceptionTests ( int inpInt, char inpChar ) {
		boolean exceptionThrown = false;
		try {
			advice.getAdvice ( inpInt, inpChar );
		} catch (BooBoo e) {
			e.ouch ();
			exceptionThrown = true;
		} catch ( Exception ex ) {
			fail ( "Unknown or Unexpected type of exception thrown" );
		}
		if ( exceptionThrown != true ) {
			fail ( "no Exception thrown at exception case when exception expected" );
		}
	}
}
