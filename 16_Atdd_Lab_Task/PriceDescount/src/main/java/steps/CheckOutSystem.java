package steps;

import java.util.ArrayList;
import java.util.Scanner;

// CheckOutSystem class that holds the method that calculates the price of a product
// based on the amount, price, and discount
public class CheckOutSystem {
	
	// this compute method takes two double value and an string,
	// first one is price of the product as a single piece
	// second one is the quantity of the product that is being bought
	// third one is the string that holds the discount
	// if there is no discount then discount should be empty or ""
	// if there is a discount then it's format should be 'x for y'
	// where x is the quantity and y is the new price
	public double compute ( double price, double quantity, String discount ) {
		
		// calculating the price without any discount is being considered
		double expectedCost = price * quantity;

		// checking if there is a discount or not
		boolean hasDiscount = true;
		if ( discount == null )
			hasDiscount = false;
		if ( discount != null && discount.isEmpty() )
			hasDiscount = false;
		if ( discount != null && discount.isBlank() )
			hasDiscount = false;
		// checking if there is any discount or not
		if ( hasDiscount ) {
			// creating an scanner object that will help us parsing the formated string
			Scanner scanner = new Scanner ( discount );

			// for x amount of this item we have an discount
			double perXItem = scanner.nextDouble();
			// this string is there for readability and useless in calculation
			@SuppressWarnings("unused")
			String dontCare = scanner.next();
			// for x amount of this item the new price is this price
			double perXItemPrice = scanner.nextDouble();
			
			// calculating how much price is reduces for the x amount of this item
			double perXDown = (price * perXItem) - perXItemPrice;
			
			// checking how much the price is reduced based on the provided quantity
			double actualDiscount = (Math.floor(quantity / perXItem)) * perXDown;
			
			// reduce the amount based on this products quantity and discount
			expectedCost -= actualDiscount;
			
			// closing the scanner object as it's done it's job
			scanner.close();
		}
		
		// returning the new cost after the price reduction
		return expectedCost;
	}
}
