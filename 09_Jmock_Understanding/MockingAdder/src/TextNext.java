import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

public class TextNext {
	@Test
	public void testNext () {
		Mockery mockery = new Mockery ();
		final GetNext nxt = mockery.mock(GetNext.class );
		
		mockery.checking( new Expectations () {{
			oneOf(nxt).get_next_int();
			will(returnValue(5));
		}});
		
		System.out.println ( nxt.get_next_int() );
	}
}
