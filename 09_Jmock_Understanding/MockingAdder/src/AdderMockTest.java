import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AdderMockTest {

	public static Calculator calc;

	Mockery mockery;

	@Before
	public void initCalc() {
		mockery = new Mockery();
	}

	@Test
	public void testCalc() {
		// fake
		final AdderInterface fake_obj = mockery.mock(AdderInterface.class);

		mockery.checking(new Expectations() {{

			oneOf(fake_obj).add_int(0, 0);
			will(returnValue(10));

			oneOf(fake_obj).add_int(10, 1);
			will(returnValue(20));

			oneOf(fake_obj).add_int(20, 2);
			will(returnValue(30));

			oneOf(fake_obj).add_int(30, 3);
			will(returnValue(40));
		}});
		
		calc = new Calculator(fake_obj);
		Assert.assertEquals(10, calc.range_add(0, 3));
	}
	
	@Test
	public void testCalcFloat () {
		// TODO: fill this up
	}

}
