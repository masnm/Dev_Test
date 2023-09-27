// **********************************************************************
//   ShoppingCart.java
//
//   Represents a shopping cart as an array of items
// **********************************************************************
import java.text.NumberFormat;

public class ShoppingCart
{
    private Item[] cart;
    private int itemCount;      // total number of items in the cart
    private double totalPrice;  // total price of items in the cart
    private int capacity;       // current cart capacity

    // -----------------------------------------------------------
    //  Creates an empty shopping cart with a capacity of 5 items.
    // -----------------------------------------------------------
    public ShoppingCart()
    {
      capacity = 5;
      cart = new Item[capacity];
      itemCount = 0;
      totalPrice = 0.0;
    }

    // -------------------------------------------------------
    //  Adds an item to the shopping cart.
    // -------------------------------------------------------
    public void addToCart(String itemName, double price, int quantity)
    { 
    	totalPrice += (price * quantity);
        Item temp = new Item(itemName, totalPrice, quantity);
        
        itemCount += quantity;
        try
        {
	        cart[itemCount] = temp;
	        
	        if(itemCount==capacity)
	        {
	            increaseSize();
	        }
        }
	    catch (ArrayIndexOutOfBoundsException e) {
	        System.out.println("Array is out of Bounds"+e);
	     } catch (ArithmeticException e) {
	        System.out.println ("Can't divide by Zero"+e);
	     }

    }

    // -------------------------------------------------------
    //  Returns the contents of the cart together with
    //  summary information.
    // -------------------------------------------------------
    public String toString()
    {
      NumberFormat fmt = NumberFormat.getCurrencyInstance();

      String contents = "\nShopping Cart\n";
      contents += "\nItem\t\tUnit Price\tQuantity\tTotal\n";

      for (int i = 0; i < capacity; i++)
    	  if(cart[i] != null)
    		  contents += cart[i].toString() + "\n";

      contents += "\nTotal Price: " + fmt.format(totalPrice);
      contents += "\n";

      return contents;
    }

    // ---------------------------------------------------------
    //  Increases the capacity of the shopping cart by 3
    // ---------------------------------------------------------
    private void increaseSize()
    {
        Item[] temp = new Item[capacity+3];
        for(int i=0; i < capacity; i++)
        {
            temp[i] = cart[i];
        }
        cart = temp; 
        temp = null;
        capacity = cart.length;
    }
}