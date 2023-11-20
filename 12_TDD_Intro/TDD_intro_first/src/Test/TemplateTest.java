package Test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Source.Template;

/*
msg = "Hi ${userName} -> You have ${count} new messages"
*/

public class TemplateTest {
	
	Template templ;
	
	@BeforeEach
	public void init () {
		templ = new Template ();
	}
	
	@Test
	public void templateTestFirst () {
		
		Map<String,String> mp = new HashMap<>();
		
		mp.put ( "${userName}", "Ayan" );
		mp.put ( "${count}", "25" );
		
		String template = "Hi ${userName}, You have ${count} new messages.";
		
		templ.receiveTemplate ( template );
		templ.replaceMatch ( mp );
		String actualMsg = templ.returnTemplate();
		
		String expectedMsg = "Hi Ayan, You have 25 new messages.";
		
		assertEquals ( expectedMsg, actualMsg );
	}

}

/*
public void abc () {
	
	array { [def] [abc] [] [] [] [] [] [] } -> array [ 1 ]
	ArrayList { [] [] [pqr] [] [] [] [] }  -> arrayList.get ( 2 )  
	hashMap {  [][]  [][]   [][]  [orange][12345]    [][]  }  hashMap [ orange ]
	
}
*/