
public class Arrays {
	
	public static void main ( String args[] ) {
		
		// int [] ages = new int[50]; 
		
		int [] numbers = { 12, 45, 10, 23, 0 };
		
		
		
		// System.out.println ( numbers.length );
		
		// for ( <initialization> ; <condition> ; <update> ) {
		//     inside for loop
		// }
		// after for loop
		
		System.out.println ( "Before sorted " );
		for ( int i = 0 ; i < numbers.length ; i++ ) {
			System.out.print ( i + ": " + numbers[i] + " " );
		}
		System.out.println ();
		
		for ( int rep = 0 ; rep < numbers.length ; rep++ ) {
		
			for ( int i = 0 ; i < numbers.length - 1 ; i++ ) {
				if ( numbers[i] > numbers[i + 1] ) {
					int t = numbers[i];
					numbers[i] = numbers[i + 1];
					numbers[i + 1] = t;
				}
			}
		
		}
		
		
		System.out.println ( "After Ascending Sorted" );
		for ( int i = 0 ; i < numbers.length ; i++ ) {
			System.out.print ( i + ": " + numbers[i] + " " );
		}
		System.out.println ();
		
		for ( int i = numbers.length - 1 ; i > -1 ; i-- ) {
			// System.out.println ( numbers[i] );
		}
		
		
		
	}

}

/*
 *    [ ]  [ ]   [ ]   [ ]   [ ]  [  ]
 *     0    1     2     3     4    ..
 */
