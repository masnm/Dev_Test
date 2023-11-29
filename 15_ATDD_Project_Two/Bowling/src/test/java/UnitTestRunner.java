import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import UnitTest.GameClassSpareTest;
import UnitTest.GameClassStrikeTest;
import UnitTest.RandomRollMock;
import UnitTest.RandomRollTest;

@RunWith(Suite.class)
@SuiteClasses({
	RandomRollTest.class,
	RandomRollMock.class,
	GameClassStrikeTest.class,
	GameClassSpareTest.class
})
public class UnitTestRunner {
}