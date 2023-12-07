import java.io.File;
import java.io.IOException;

public class Main {
	
	public static void openFile ( String fileName ) throws IOException {
		File file = new File ( fileName );
		file.createNewFile();
	}
	
	public static int divide ( int a, int b ) {
		int ans = 0;
		try {
			ans = a / b;
		} catch ( Exception ex ) {
			ans = 0;
			ex.printStackTrace();
			System.err.println ( "Divided By zero occured!" );
		}
		return ans;
	}
	
	public static void main(String[] args) {

		/* compile time error
		 * can fix very easily and detect by just compiling the java file
		int x = 20.0;
		System.out.println ( x );
		*/
		
		System.out.println ( "Hello" );
		
		// System.out.println ( divide ( 100, 0 ) );
		System.out.println ( divide ( 100, 1 ) );
		System.out.println ( "Hello Again" );
		
		try {
			assert ( 12 < 9 );
		} catch ( Exception ex ) {
			ex.printStackTrace();
		}

		try {
			openFile ( "AnewFile" );
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println ( "ACBDDEDFG" );
	}

}