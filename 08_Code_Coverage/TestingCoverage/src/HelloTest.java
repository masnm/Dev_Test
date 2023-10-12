import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HelloTest {

	@ParameterizedTest
	@ValueSource(booleans = { true, true, true, true } )
	public void Hello ( boolean acp ) {
		HelloWorld hw = new HelloWorld ();
		String got = hw.getHello( acp );
		Assert.assertEquals ( "Hello World" ,got );
	}
}
