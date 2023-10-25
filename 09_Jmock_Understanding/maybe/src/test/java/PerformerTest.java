import org.junit.Test;
import org.junit.runner.RunWith;

import exmple.maybe.Collaborator;
import exmple.maybe.Model;
import exmple.maybe.Performer;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Mock;
import mockit.Tested;

public class PerformerTest {

    @Injectable
    private Collaborator collaborator;

    @Tested
    private Performer performer;

    @Test
    public void testThePerformMethod() {
    	model = new Model();
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