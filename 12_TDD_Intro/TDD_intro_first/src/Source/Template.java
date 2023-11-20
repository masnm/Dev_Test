package Source;

import java.util.Map;

public class Template {
	
	private String templ;
	
	public void receiveTemplate ( String s ) {
		templ = s;
	}
	
	public void replaceMatch ( Map<String,String> mp ) {
		for ( Map.Entry<String,String> entry : mp.entrySet() ) {
			templ = templ.replace(entry.getKey(), entry.getValue());
		}
	}
	
	public String returnTemplate () {
		return templ;
	}
}
