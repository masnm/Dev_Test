import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class OptimizedAdviceTest {
	
	private static Advice advice;

	// prepare for jupiter paramiterized test
	@BeforeAll
	public static void initJup () {
		advice = new Advice ();
	}
	
	// this method test some positive test cases
	@ParameterizedTest
	@CsvSource ( {
		"123,'a',false",
		"-123,'u',false",
		"-37,'p',false",
		"37,'x',false",
		"-25,'r',false",
		"25,'b',false",
		"-6,'y',true",
		"26,'i',true",
		"12,'k',true",
		"86,'c',true",
		"-26,'x',true"
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
		"-2147483648,'c',true",
		"-2147483648,'d',true",
		"-2147483648,'e',true",
		"-2147483648,'f',true",
		"-2147483648,'g',true",
		"-2147483648,'h',true",
		"-2147483648,'i',true",
		"-2147483648,'j',true",
		"-2147483648,'k',true",
		"-2147483648,'k',true",
		"-2147483648,'l',true",
		"2147483647,'y',false",
		"2147483647,'x',false",
		"2147483647,'p',false",
		"2147483647,'l',false",
		"2147483647,'k',false",
		"2147483647,'h',false",
		"2147483647,'e',false",
		"2147483647,'w',false",
		"0,'n',true",
		"0,'m',true",
		"0,'o',true",
		"0,'p',true",
		"0,'q',true",
		"0,'r',true",
		"2,'n',true",
		"2,'m',true",
		"2,'o',true",
		"2,'p',true",
		"2,'q',true",
		"2,'r',true",
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
		"1,'c',true",
		"1,'d',true",
		"1,'e',true",
		"1,'f',true",
		"1,'g',true",
		"1,'h',true",
		"0,'z',true",
		"1,'z',true",
		"2,'z',true",
		"3,'z',true",
		"4,'z',true",
		"5,'z',true",
		"6,'z',true",
		"7,'z',true",
		"1,'z',false",
		"1,'y',false",
		"1,'x',false",
		"1,'w',false",
		"1,'v',false",
		"1,'u',false"
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
		"1,'e'",
		"1,'f'",
		"1,'g'",
		"1,'h'",
		"0,'z'",
		"1,'z'",
		"2,'z'",
		"3,'z'",
		"4,'z'",
		"5,'z'",
		"6,'z'",
		"7,'z'",
		"1,'z'",
		"1,'y'",
		"1,'x'",
		"1,'w'",
		"1,'v'",
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
