import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TesrsForShoppingCart {

	// this instance must be static because it will be created by the
	// juint @beforeclass which must be static
	private static ShoppingCart sc;
	private static Integer ItemCount = 1, Quantity = 1;
	private static Double Price = 10.0;
	
	@BeforeClass
	public static void beforeClass () {
		sc = new ShoppingCart();
	}
	
	@Before
	public void before () {
		sc = new ShoppingCart ();
		ItemCount = 1;
		Quantity = 0;
		Price = 10.0;
	}
	
	// this method removes all the white-space, new line and tabs from the
	// given string and then returns a cleaned up string.
	public String cleanup ( String s ) {
		// removing white space
		s = s.replaceAll ( " ", "" );
		// removing new lines
		s = s.replaceAll ( "\n", "" );
		// removing tabs
		s = s.replaceAll( "\t", "" );
		return s;
	}
	
	@Test
	public void addToCartTenItems () {

		// trying to insert ten items and testing item insertion after each item.
		for ( int cnt = 1; cnt <= 10; ++cnt ) {
			tryToAddAnItem ();
		}
	}
	
	@Test
	public void addToCartFiveItems () {

		// trying to insert ten items and testing item insertion after each item.
		for ( int cnt = 1; cnt <= 5; ++cnt ) {
			tryToAddAnItem ();
		}
	}
	
	@Test
	public void addToCartTwoItems () {

		// trying to insert ten items and testing item insertion after each item.
		for ( int cnt = 1; cnt <= 2; ++cnt ) {
			tryToAddAnItem ();
		}
	}
	
	@Test
	public void addToCartOneItems () {

		// trying to insert ten items and testing item insertion after each item.
		for ( int cnt = 1; cnt <= 1; ++cnt ) {
			tryToAddAnItem ();
		}
	}
	
	@Test
	public void tryToAddAnItem () {
		// Generating the items fields
		String itemName = "Next Item " + ItemCount++;
		double itemPrice = Price += 10.0;
		int itemCount = Quantity += 1;
		
		// adding the new item to the cart object
		sc.addToCart ( itemName, itemPrice, itemCount );
		// getting all the items from the cart in a formated string
		String all_items = sc.toString();
		// removing all the white-space, new-line and tabs on the string
		all_items = cleanup ( all_items );
		
		// creating an item locally with the same info added in the cart
		Item it = new Item ( itemName, itemPrice, itemCount );
		// extracting the item string and cleaning it up same as above
		String this_item = cleanup ( it.toString () );
		
		// if the new item was added in the cart successfully then the cart
		// objects string should have the item objects string in it. otherwise
		// this test fails immediately
		Assert.assertTrue( all_items.contains( this_item ) );
	}
	
	
	public void addThisItem ( String itemName, double itemPrice, int itemCount ) {
		// adding the new item to the cart object
		sc.addToCart ( itemName, itemPrice, itemCount );
		// getting all the items from the cart in a formated string
		String all_items = sc.toString();
		// removing all the white-space, new-line and tabs on the string
		all_items = cleanup ( all_items );
		
		// creating an item locally with the same info added in the cart
		Item it = new Item ( itemName, itemPrice, itemCount );
		// extracting the item string and cleaning it up same as above
		String this_item = cleanup ( it.toString () );
		
		// if the new item was added in the cart successfully then the cart
		// objects string should have the item objects string in it. otherwise
		// this test fails immediately
		Assert.assertTrue( all_items.contains( this_item ) );
	}
	
	@Test
	public void NullNameTestOne () {
		// setting the name of the item to null
		addThisItem ( null, 10.0, 1 );
	}
	
	@Test
	public void NullNameTestTwo () {
		// setting the name of the item to null
		addThisItem ( null, 10.0, 2 );
	}
	
	
	@Test
	public void NameTestThree () {
		// setting the name of the item to null
		addThisItem ( "Banana", 10.0, 2 );
	}
	
	@Test
	public void NegativePriceTest () {
		// testing for negative value
		String found = "nothig";
		try {
			sc.addToCart("Apple", -200.0, 2);
		} catch ( Exception ex ) {
			found = "Exception";
		}
		Assert.assertEquals( "Exception", found );
		// cheching if the item is added
		// if added then test should failed
		Assert.assertFalse(
				cleanup ( sc.toString() ).contains(
						cleanup ( new Item("Apple", -200.0, 2 ).toString() )
						)
				);
	}
	
	@Test
	public void ZeroPriceTest () {
		// testing for zero price
		String found = "nothig";
		try {
			sc.addToCart("Apple", 0.0, 2);
		} catch ( Exception ex ) {
			found = "Exception";
		}
		Assert.assertEquals( "Exception", found );
		// cheching if the item is added
		// if added then test should failed
		Assert.assertFalse(
				cleanup ( sc.toString() ).contains(
						cleanup ( new Item("Apple", 0.0, 2 ).toString() )
						)
				);
	}

	@Test
	public void MinimumPriceTest () {
		String found = "nothig";
		try {
			sc.addToCart("Apple", Double.MIN_VALUE, 2);
		} catch ( Exception ex ) {
			found = "Exception";
		}
		Assert.assertEquals( "Exception", found );
		// cheching if the item is added
		// if added then test should failed
		Assert.assertFalse(
				cleanup ( sc.toString() ).contains(
						cleanup ( new Item("Apple", Double.MIN_VALUE, 2 ).toString() )
						)
				);
	}
	
	@Test
	public void MaximumPriceTest () {
		String found = "nothig";
		try {
			sc.addToCart("Apple", Double.MAX_VALUE, 2);
		} catch ( Exception ex ) {
			found = "Exception";
		}
		Assert.assertEquals( "Exception", found );
		// cheching if the item is added
		// if added then test should failed
		Assert.assertFalse(
				cleanup ( sc.toString() ).contains(
						cleanup ( new Item("Apple", Double.MAX_VALUE, 2 ).toString() )
						)
				);
	}

	@Test
	public void NegativeQuantityTest () {
		String found = "nothig";
		try {
			sc.addToCart("Jackfruit", 15.0, -5);
		} catch ( Exception ex ) {
			found = "Exception";
		}
		Assert.assertEquals( "Exception", found );
		// cheching if the item is added
		// if added then test should failed
		Assert.assertFalse(
				cleanup ( sc.toString() ).contains(
						cleanup ( new Item("Jackfruit", 15.0, -5).toString() )
						)
				);
	}
	
	@Test
	public void ZeroQuantityTest () {
		String found = "nothig";
		try {
			sc.addToCart("Jackfruit", 15.0, 0);
		} catch ( Exception ex ) {
			found = "Exception";
		}
		Assert.assertEquals( "Exception", found );
		// cheching if the item is added
		// if added then test should failed
		Assert.assertFalse(
				cleanup ( sc.toString() ).contains(
						cleanup ( new Item("Jackfruit", 15.0, 0).toString() )
						)
				);
	}
	
	@Test
	public void MinimumQuantityTest () {
		String found = "nothig";
		try {
			sc.addToCart("Jackfruit", 15.0, Integer.MIN_VALUE );
		} catch ( Exception ex ) {
			found = "Exception";
		}
		Assert.assertEquals( "Exception", found );
		// cheching if the item is added
		// if added then test should failed
		Assert.assertFalse(
				cleanup ( sc.toString() ).contains(
						cleanup ( new Item("Jackfruit", 15.0, Integer.MIN_VALUE ).toString() )
						)
				);
	}
	
	@Test
	public void MaximumQuantityTest () {
		String found = "nothig";
		try {
			sc.addToCart("Jackfruit", 15.0, Integer.MAX_VALUE );
		} catch ( Exception ex ) {
			found = "Exception";
		}
		Assert.assertEquals( "Exception", found );
		// cheching if the item is added
		// if added then test should failed
		Assert.assertFalse(
				cleanup ( sc.toString() ).contains(
						cleanup ( new Item("Jackfruit", 15.0, Integer.MAX_VALUE ).toString() )
						)
				);
	}
	
}