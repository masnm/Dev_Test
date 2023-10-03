/*Author:
 * 
 * Name: 
 * Student ID: 
 * Group: 
 * 
 * */

/*Acceptable Cases
 *addNode:
 *  Input: Any object of Object class, i.e. anything
 *  Output: Nothing ( void )
 *  SideEffect: Change the Count instance variable
 *  addNode method accepts any generic data type or any object and add them
 *  in the link list. Which increases the NodesCount by one. It may also throw
 *  some exception. It does not return anything.
 *
 *getNodesCount:
 *  Input: Nothing
 *  Output: Integer ( count )
 *  getNodesCount method does not take any input and just returns how many
 *  elements are saved in the linked list.
 * 
 *getDataAt:
 *  Input: Integer ( Index )
 *  Output: Integer ( Data at index )
 *  This method returns the data at the index on the linked list
 *
 *removeAt:
 *  Input: Integer ( Index )
 *  Output: Void ( Nothing )
 *  This method removes the data at the index on the linked list
 *
 *reverse:
 *  Input: Void ( Nothing )
 *  Output: Void ( Nothing )
 *  This method just reverse the values or data are stored in the
 *  linked list.
 *  
 */

/*
 * using @org.junit.jupiter.api.BeforeAll instead of
 * @BeforeClass cause it `BeforeClass` was not doing it's job
 * and the lln instance was null and not initialized.
 * 
 * ***  using JUint 5 library ***
 */

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TestLinkedListNew {

	// declaring the linkedListNew object
	public static LinkedListNew lln;
	/*				Positive Tests					*/

	// initializing the lln instance before any test
	@org.junit.jupiter.api.BeforeAll
	public static void beforeClassStart () {
		lln = new LinkedListNew ();
	}
	
	// initializing the lln instance before each test
	@org.junit.jupiter.api.BeforeEach
	public void beforeAnyTestStart () {
		lln = new LinkedListNew ();
	}

	//First Happy Path Test on addNode (1 mark)

	@Test
	public void happyAddNodeException () {
		// an flag to detect if an exception was thrown or not
		boolean exceptionThrown = false;
		// trying to add an element or object in lln using addNode
		try {
			lln.addNode ( 25 );
		} catch ( Exception ex ) {
			exceptionThrown = true;
		}
		
		// making sure / testing if any exception thrown or not
		Assert.assertFalse ( exceptionThrown );
	}

	@Test
	public void happyAddNodeCount () {
		// cashing the count before inserting
		int oldCount = lln.getNodesCount();
		
		// trying to add an element or object in lln using addNode
		try {
			lln.addNode ( 25 );
		} catch ( Exception ex ) {
			// Immediately failing the test if any exception was thrown
			// because for this simple input it should work just fine
			Assert.assertFalse (true);
		}
		
		// getting the new count after inserting
		int newCount = lln.getNodesCount();
		
		// making sure / testing if count has increased or not
		Assert.assertEquals ( newCount - oldCount, 1 );
	}
	
	//First Happy Path Test on reverse (1 mark)
	@Test
	public void happyReverse () {
		// [ 1, 2, 3 ] --> [ 3, 2, 1 ]
		// creating an arraylist
		ArrayList<Integer> al = new ArrayList<>();
		// now adding 1, 2, 3 in this order in the array list
		al.add ( 1 );
		al.add ( 2 );
		al.add ( 3 );
		
		// now adding from the arraylist to the lln object all it's
		// elements in the same order as arraylist
		for ( Integer item : al ) {
			try {
				lln.addNode ( item );
			} catch (Exception ex) {
				// Immediately failing the test if any exception was thrown
				// because for this simple input it should work just fine
				Assert.assertFalse ( true );
			}
		}
		
		// reversing the array list it works because system java system
		// library's are all tested properly
		Collections.reverse ( al );
		
		// now reversing the linkedlistNew object using it's method
		lln.reverse();
		
		// as both list's are reversed so both should hold the same items
		// in the same index
		for ( int i = 0; i < al.size(); i++ ) {
			Assert.assertEquals ( (int)al.get(i), lln.getDataAt(i) );
		}
	}
	
	
	//First Happy Path Test on getDataAt (1 mark)
	@Test
	public void happyGetDataAt () {
		// adding three elements int this way
		// index 0 -> value 3
		// index 1 -> value 7
		// index 2 -> value 10
		for ( int x : new int[]{3, 7, 10} ) {
			try {
				lln.addNode ( x );
			} catch (Exception e) {
				// Immediately failing the test if any exception was thrown
				// because for this simple input it should work just fine
				Assert.assertFalse ( true );
			}
		}
		
		// now trying to accessing the data in the data using the provided
		// method which is getDataAt and checking if the right data was
		// returned
		// setting the index value to 0 so that it can be used to get
		// the first item from the liked list.
		int index = 0;
		for ( int x : new int[] {3, 7, 10} ) {
			// x now for each iteration holds same values as above loop
			// and in each loop we are getting an item from the lln instance
			// using getDataAt method
			Assert.assertEquals ( x, lln.getDataAt(index) );
			// updating the index value for the next iteration so that
			// it can be used to get the next item
			index++;
		}
	}
	
	/*				Negative Test					*/
	
	//First Negative Test on addNode(2 mark)
	@Test
	public void negativeAddNodeException () {
		// an flag to detect if an exception was thrown or not
		boolean exceptionThrown = false;
		// trying to add an element or object in lln using addNode
		try {
			lln.addNode ( "Some number" );
		} catch ( Exception ex ) {
			exceptionThrown = true;
		}
		
		// making sure / testing if any exception thrown or not
		Assert.assertFalse ( exceptionThrown );
	}

	@Test
	public void negativeAddNodeCount () {
		// cashing the count before inserting
		int oldCount = lln.getNodesCount();
		
		// trying to add an element or object in lln using addNode
		try {
			lln.addNode ( "Some number" );
		} catch ( Exception ex ) {
			// Immediately failing the test if any exception was thrown
			// because for this simple input it should work just fine
			Assert.assertFalse (true);
		}
		
		// getting the new count after inserting
		int newCount = lln.getNodesCount();
		
		// making sure / testing if count has increased or not
		Assert.assertEquals ( newCount - oldCount, 1 );
	}
	
	//First Negative Test on removeAt, with Explanation (2 mark)
	@Test
	public void negativeRemoveAtException () {
		// adding 5 elements in the linked list from 0 to 4
		// in the numeric ascending order so that each index
		// and it's holding value is same
		for ( int x : new int[] { 0, 1, 2, 3, 4 } ) {
			try {
				lln.addNode(x);
			} catch (Exception e) {
				// Immediately failing the test if any exception was thrown
				// because for this simple input it should work just fine
				Assert.assertFalse (true);
			}
		}
		
		// now removing from index outside of existence
		boolean exceptionThrown = false;
		try {
			// removing the immediate right not existing index
			lln.removeAt ( 5 );
		} catch ( Exception ex ) {
			exceptionThrown = true;
		}
		
		// testing if the exception is thrown or not
		// expecting an exception should be thrown
		Assert.assertTrue ( exceptionThrown );
	}
	
	//Second Negative Test on removeAt, with Explanation (2 mark)
	@Test
	public void negativeRemoveAtCount () {
		// adding 5 elements in the linked list from 0 to 4
		// in the numeric ascending order so that each index
		// and it's holding value is same
		for ( int x : new int[] { 0, 1, 2, 3, 4 } ) {
			try {
				lln.addNode(x);
			} catch (Exception e) {
				// Immediately failing the test if any exception was thrown
				// because for this simple input it should work just fine
				Assert.assertFalse (true);
			}
		}
		// cashig the count before removing the element ( which should
		// not be do anything because it's out of range index value )
		int oldCount = lln.getNodesCount();
		try {
			// removing the immediate right not existing index
			lln.removeAt ( 5 );
		} catch ( Exception ex ) {
		}
		
		// now getting the new count from the lln object
		int newCount = lln.getNodesCount();
		
		// expecting the newCount and oldCount should be same because
		// to removing we provided and out of bound index so no change
		// should have made
		Assert.assertEquals ( oldCount, newCount );
	}
	
	@Test
	public void negativeRemoveAtVerify () {
		// In this test we will try to find out if out of index
		// has make any changes on the linkedLinsNew
		
		// initialing the linked list with each index holds
		// the value is equal to the index
		// [index,value] = [0,0] -> [1,1] -> [2,2] -> ...
		for ( int x : new int[] { 0, 1, 2, 3 } ) {
			try {
				lln.addNode(x);
			} catch (Exception e) {
				// Immediately failing the test if any exception was thrown
				// because for this simple input it should work just fine
				Assert.assertFalse (true);
			}
		}
		// now as the linked list holds only 4 items so the index range is
		// from 0 .. 3. Now we will try to remove at index 4 which is out
		// of bound index for our linked list. Which should not do any chane
		// in the linked list
		lln.removeAt ( 4 );
		
		// now checking if there was no change in the linked list
		// as all the index has the value equal to the index so we can use
		// only one iteration variable to access and check
		for ( int x : new int[] { 0, 1, 2, 3 } ) {
			// now making sure each index has the value equal to the index
			Assert.assertEquals ( x, lln.getDataAt(x) );
		}
	}
	
	//First Negative Test on reverse, with Explanation (2 mark)
	@Test
	public void negativeReverseTest () {
		// testing the reverse methods with the linked list holding items
		// from only one item to 100 items
		for ( int itemCount = 1; itemCount <= 100; itemCount++ ) {
			// recreating the linkedListNew object each time
			lln = new LinkedListNew ();
			
			// inserting itemCount amount of item in the list
			for ( int value = 0; value < itemCount; value++ ) {
				try {
					lln.addNode ( value );
				} catch (Exception e) {
					// Immediately failing the test if any exception was thrown
					// because for this simple input it should work just fine
					Assert.assertFalse (true);
				}
			}
			
			// now reversing the list
			lln.reverse ();
			
			// now making sure the reverse worked
			// as the linked list has reversed we now expect the numbers in reverse
			// order of which order we inserted them
			for ( int index = 0, value = itemCount - 1; index < itemCount; index++, value-- ) {
				// now making sure the values are in expected place
				Assert.assertEquals( value, lln.getDataAt ( index ) );
			}
		}
	}
	
	
	/*				Exception Test					*/
	//Exception Test with addNode (2 marks)
	@Test
	public void exceptionTestOnAddNodeIntegerMax () {
		// now we will try to insert extreme possible value to see if
		// any exception was thrown
		
		// declaring a variable to check if any exception was thrown no not
		boolean exceptionFound = false;
		
		// Trying to insert Extreme maximum value an integer can hold
		try {
			lln.addNode( Integer.MAX_VALUE );
		} catch ( Exception ex ) {
			exceptionFound = true;
		}
		
		// Checking if exception is thrown or not. if not thrown then fail
		// this test
		Assert.assertTrue ( exceptionFound );
	}

	@Test
	public void exceptionTestOnAddNodeIntegerMin () {
		// now we will try to insert extreme possible value to see if
		// any exception was thrown
		
		// declaring a variable to check if any exception was thrown no not
		boolean exceptionFound = false;
		
		// Trying to insert Extreme minimum value an integer can hold
		try {
			lln.addNode( Integer.MIN_VALUE );
		} catch ( Exception ex ) {
			exceptionFound = true;
		}
		
		// Checking if exception is thrown or not. if not thrown then fail
		// this test
		Assert.assertTrue ( exceptionFound );
	}

	@Test
	public void exceptionTestOnAddNodeLongMax () {
		// now we will try to insert extreme possible value to see if
		// any exception was thrown
		
		// declaring a variable to check if any exception was thrown no not
		boolean exceptionFound = false;
		
		// Trying to insert Extreme maximum value an integer can hold
		try {
			lln.addNode( Long.MAX_VALUE );
		} catch ( Exception ex ) {
			exceptionFound = true;
		}
		
		// Checking if exception is thrown or not. if not thrown then fail
		// this test
		Assert.assertTrue ( exceptionFound );
	}

	@Test
	public void exceptionTestOnAddNodeDoubleMin () {
		// now we will try to insert extreme possible value to see if
		// any exception was thrown
		
		// declaring a variable to check if any exception was thrown no not
		boolean exceptionFound = false;
		
		// Trying to insert Extreme maximum value an integer can hold
		try {
			lln.addNode( Double.MIN_VALUE );
		} catch ( Exception ex ) {
			exceptionFound = true;
		}
		
		// Checking if exception is thrown or not. if not thrown then fail
		// this test
		Assert.assertTrue ( exceptionFound );
	}
	
	//validate the message (2 mark)
	@Test
	public void validateExceptionMessageAddNode () {
		// cashing the expected message and declaring another for storing
		// the message we got from the exception
		String expectedMessage = "The data entered does not fitst in the range of integers";
		String foundMessage = "";
		
		// inserting and extreme value we know will throw and exception
		try {
			lln.addNode(Integer.MAX_VALUE);
		} catch (Exception ex) {
			foundMessage = ex.getMessage();
		}
		
		// making sure the found message is same as expected message
		Assert.assertEquals ( expectedMessage, foundMessage );
	}

	//Exception Test on getDataAt,(2 mark)
	@Test
	public void exceptionTestGetDataAtLeft () {
		// inserting some values in the linked list so that we can index
		for ( int x : new int[] { 0, 1, 2, 3 } ) {
			try {
				lln.addNode(x);
			} catch (Exception e) {
				// Immediately failing the test if any exception was thrown
				// because for this simple input it should work just fine
				Assert.assertFalse (true);
			}
		}
		
		// declaring a variable to detect if exception thrown
		boolean exceptionThrown = false;

		// now trying to index on the left of range of indexes
		try {
			// -1 index does not exist
			lln.getDataAt ( -1 );
		} catch ( Exception ex ) {
			exceptionThrown = true;
		}
		
		// making sure the exception was thrown
		Assert.assertTrue ( exceptionThrown );
	}

	@Test
	public void exceptionTestGetDataAtRight () {
		// inserting some values in the linked list so that we can index
		for ( int x : new int[] { 0, 1, 2, 3 } ) {
			try {
				lln.addNode(x);
			} catch (Exception e) {
				// Immediately failing the test if any exception was thrown
				// because for this simple input it should work just fine
				Assert.assertFalse (true);
			}
		}
		
		// declaring a variable to detect if exception thrown
		boolean exceptionThrown = false;

		// now trying to index on the left of range of indexes
		try {
			// 4 index does not exist because 4 items indexes from 0 to 3
			lln.getDataAt ( 4 );
		} catch ( Exception ex ) {
			exceptionThrown = true;
		}
		
		// making sure the exception was thrown
		Assert.assertTrue ( exceptionThrown );
	}
}

//Required annotation for efficient test. (3 Mark)
