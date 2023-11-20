// These imports are easy to use for reading files.
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;



public class FileReaderTemplate {
	String template;
	
	// This function should read the text file names text.txt
	// After reading it should store the content to template
	public void setTemplate(String path) throws IOException
	{
		StringBuilder sb = new StringBuilder();
		
		//You may have to change the file path OR simply give the absolute path if it's not in this folder
		File file = new File ( path );
		FileReader reader = new FileReader ( file );
		BufferedReader br = new BufferedReader ( reader );
		
		while ( true ) {
			int nextValue = br.read();
			if ( nextValue == -1 ) break;
			sb.append( (char)nextValue );
		}

		template = sb.toString();
		
		br.close();
	}
	
	//This function should update template given the key and value 
	public void updateTemplate(String key, String value)
	{
		template = template.replace ( key, value );
	}
	
	//getter
	public String getUpdatedTemplate()
	{
		return template;
	}
	
}
