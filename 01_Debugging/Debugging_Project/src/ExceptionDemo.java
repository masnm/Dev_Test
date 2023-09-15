import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Properties;

public class ExceptionDemo {

	public ExceptionDemo() {
		Properties props = new Properties();
		try {
			props.load(new FileInputStream(new File("foo")));
		} catch (Exception e) {
			System.err.println("1");
			System.err.println(e);
			
			System.err.println("\n2");
			System.err.println(e.getMessage());
			
			System.err.println("\n3");
			System.err.println(e.getLocalizedMessage());
			
			System.err.println("\n4");
			System.err.println(e.getCause());
			
			System.err.println("\n5");
			System.err.println(Arrays.toString(e.getStackTrace()));
			
			System.err.println("\n6");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ExceptionDemo();
	}

}
