package steps;

import java.util.Scanner;

public class CheckOutSystem {

	public double compute ( double price, double quantity, String discount ) {
		
		double expectedCost = price * quantity;

		if ( !discount.isEmpty() ) {
			Scanner scanner = new Scanner ( discount );

			double perXItem = scanner.nextDouble();
			@SuppressWarnings("unused")
			String dontCare = scanner.next();
			double perXItemPrice = scanner.nextDouble();
			
			double perXDown = (price * perXItem) - perXItemPrice;
			
			double actualDiscount = (Math.floor(quantity / perXItem)) * perXDown;
			
			expectedCost -= actualDiscount;
			
			scanner.close();
		}
		
		return expectedCost;
	}
}
