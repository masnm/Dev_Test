
public class ScopeRes {
	
	private static int copyX = 123;

	public static void main ( String[] args ) {
		
		int x = copyX;
		{
			int var = x;
		}
		int copyvar = var;

	}
	
	private int tryingP = getNum();
	
	private int getNum () {
		int p = 12345;
		return p;
	}

}
