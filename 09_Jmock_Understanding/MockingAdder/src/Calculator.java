
public class Calculator {
	
	private AdderInterface adder;
	
	Calculator ( AdderInterface adder ) {
		this.adder = adder;
	}
	
	public int range_add ( int low, int high ) {
		int ans = 0;
		for ( int i = low ; i <= high ; i++ ) {
			// ans += i;
			// ans = ans + i;
			ans = adder.add_int ( ans, i );
		}
		return ans;
	}
	
	public float range_add ( float low, float high ) {
		// TODO: fill this up using the above method
		// TODO: this return is temporary
		return 0.0f;
	}

	public static void main(String[] args) {
		Calculator calc = new Calculator ( new AdderImpl () );
	}

}
