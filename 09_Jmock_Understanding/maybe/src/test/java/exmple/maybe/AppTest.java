package exmple.maybe;

import static org.mockito.Mockito.mock;

import org.junit.runner.RunWith;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.Verifications;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    @Injectable
    private Collaborator collaborator;
    
    @Tested
    private Performer performer;
    
    public void testAbc () {
    	final Model model = mock ( Model.class );
    	new Expectations() {{
    	    model.getInfo();result = "bar";
    	    collaborator.collaborate("bar"); result = true;
        }};
        
        performer.perform(model);
        
        new Verifications() {{
    	    collaborator.receive(true);
        }};
    }
}
