package TestSome;

import org.junit.BeforeClass;
import org.junit.Test;

import SourceClasses.Mathematic;
import org.junit.Assert;
import org.junit.Before;


public class MathematicTest {
	
	private static Mathematic mc;
	
	@BeforeClass
	public static void beforeClass () {
		mc = new Mathematic ();
	}
	
	@Before
	public void before () {
		mc.setX(0);
		mc.setY(0);
		mc.add();
	}
	
	@Test
	public void AddTest () {
		 mc.setX(1);
		 mc.setY(2);
		 mc.add ();
		 int ans = mc.getAns();
		 Assert.assertEquals(5, ans);
	}
	
	@Test
	public void SubTest () {
		mc.setX(123);
		mc.setY(20);
		mc.sub();
		Assert.assertEquals ( 103, mc.getAns() );
	}
	
	@Test
	public void secondAddTest () {
		Assert.assertEquals ( 5, Mathematic.add(2, 2) );
	}
	
}
