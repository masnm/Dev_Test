
public class Extra implements GetNext {
	
	@Override
	public int get_next_int () {
		return (int)(Math.random()*10);
	}

	public static void main(String[] args) {
		
		Extra ex = new Extra ();
		System.out.println ( ex.get_next_int() );

	}

}
