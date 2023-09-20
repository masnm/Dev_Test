package TestSome;

import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

public class ATest {
	
	@BeforeClass
	public static void a () {
		// Object Create
		// setting objects properties
		System.out.println ( "BeforeClass" );
	}
	
	@Before
	public void b () {
		// preparing the object for a test
		System.out.println ( "Before" );
	}
	
	@After
	public void c () {
		// resetting object to a default state
		System.out.println ( "After" );
	}
	
	@Test
	public void abc () {
		System.out.println ( "ABC" );
	}
	
	@Test
	public void def () {
		System.out.println ( "DEF" );
		Assert.assertEquals ( 3, 5 );
	}

	@Test
	public void ghi () {
		System.out.println ( "GHI" );
	}
	
	@AfterClass
	public static void z () {
		// cleanup
		System.out.println ( "After Class" );
	}

}
