import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import steps.CheckOutSystemUnitTestOne;

@RunWith(Suite.class)
@SuiteClasses({
	CheckOutSystemUnitTestOne.class
})
public class UnitTestRunner {
}