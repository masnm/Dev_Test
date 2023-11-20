import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class TestFunctions {
	Sigmoid sigmoid;
	ThreeDEuclideanDistance distance;
	FileReaderTemplate templateEngine;
	
	@BeforeEach
	void setup()
	{
		sigmoid = new Sigmoid ();
		distance = new ThreeDEuclideanDistance ();
		templateEngine = new FileReaderTemplate ();
	}
	
	@ParameterizedTest
	//Column 3 is the horizontal shift, Column 4 is the steepness
	@CsvSource({"0.2,0.93,2,3","0.4,0.67,0.5,0.5","0.5,0.82,1,1","0.5,0.82,0.5,2"})
	void testValidSigmoidValues(String input, String actualValue, String horizontalShift, String steepness)
	{
		
		double expected = sigmoid.compute (
				Double.parseDouble(input),
				Double.parseDouble(horizontalShift),
				Double.parseDouble(steepness)
			);
		
		String expectedString = Double.toString(expected);
		
		assertEquals(expectedString,actualValue);
	}
	
	@Test
	void testValidDistance1()
	{
		double x = 1;
		double y = 1;
		double z = 1;
		double xt = 1;
		double yt = 1;
		double zt = 1;
		
		String actual = "0.0";

		double [] coordinates1 = { x, y, z };
		double [] coordinates2 = { xt, yt, zt };
		
		double d = distance.computeDistance(coordinates1, coordinates2);
	
		assertEquals(Double.toString(d),actual);
	}
	
	@Test
	void testValidDistance2()
	{
		double x = 1;
		double y = 1;
		double z = 1;
		double xt = 3;
		double yt = 3;
		double zt = 4;
		
		String actual = "4.123105625617661";
		
		double [] coordinates1 = { x, y, z };
		double [] coordinates2 = { xt, yt, zt };
		
		double d = distance.computeDistance(coordinates1, coordinates2);
	
		assertEquals(Double.toString(d),actual);
	}
	
	@Test
	void InValidDistanceArg()
	{
		double x = 1;
		double y = 1;
		double z = 1;
		double xt = 3;
		double yt = 3;
	
		
		double [] coordinates1 = { x, y, z };
		double [] coordinates2 = { xt, yt };
		
	
		Throwable exception = 
				assertThrows(IllegalArgumentException.class,
						()->{distance.computeDistance(coordinates1, coordinates2);});
				
		assertEquals(exception.getMessage(), "Hey, both coordinate position must be the same dimension");
	}
	
	
	@Test
	void testValidTemplate() throws Exception
	{
		String actualSentence = "Hello, my name is Peter.";

		String filePath = "text.txt";
		templateEngine.setTemplate ( filePath );

		//use ${Greetings} and ${name} as keys
		//use Hello and Peter as values for the keys respectively
		templateEngine.updateTemplate ( "${Greetings}", "Hello" );
		templateEngine.updateTemplate ( "${name}", "Peter" );

		
		assertEquals(templateEngine.getUpdatedTemplate(), actualSentence);
	}

}
