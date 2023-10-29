import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CookTests {

	ICook cook;
	Mockery mockContext;
	
	@BeforeEach
	void Setup() {
		cook = new Cook();  // real object being tested
		mockContext = new Mockery();
	}
	
	@Test
	void TestOrderFromWaiter() throws Exception{
		
		//lets mock the waiter
		//we are just testing the cook in isolation
		final IWaiter waiter = mockContext.mock(IWaiter.class);
		
		//set some expectations for the mock
		final String expectedOrder = "Hot Dog";
		
		mockContext.checking(new Expectations() {{
			oneOf(waiter).GetOrder();
			will(returnValue(expectedOrder));
		}});
		
		mockContext.checking(new Expectations() {{
			oneOf(waiter).SetOrder(expectedOrder);
		}});
		
		/*
		String ordered = waiter.GetOrder();
		
		cook.SetOrder(ordered);
		
		String dish = cook.GetOrder();
		
		waiter.SetOrder(dish);
		*/
		
		//lets place the order and make sure we 
		//get the correct item
		cook.SetOrder(waiter.GetOrder());
		waiter.SetOrder(cook.GetOrder());
		
		//verify we have called all the correct methods
		//with correct parameters
		mockContext.assertIsSatisfied();	
	}
}
