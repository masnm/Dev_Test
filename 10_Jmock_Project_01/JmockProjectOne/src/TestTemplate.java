import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestTemplate {

	Mockery mock;
	
	@BeforeEach
	public void setup()
	{
		mock = new Mockery();
	}

	@Test
	public void validTestFromReceptionToMechanic() throws Exception
	{
		//validate communication
		// creating an mocked object from mechanic interface to use as mechanic class
		IMechanic mechanic = mock.mock ( IMechanic.class );

		// declaring an string to use as an issue variable
		final String issue_to_fix = "Flat Tire";
		
		mock.checking(new Expectations () {{ 
			oneOf(mechanic).receivedIssueFromReception ( issue_to_fix );
			
			oneOf(mechanic).fixedIssueAndInformReception ();
			will ( returnValue ( issue_to_fix ) );
		}});
		
		// Need to create an object of class Receptionist to test it
		Receptionist receptionist = new Receptionist ();

		// sending the local saved issue to the receptionist and saving the return value
		String issue_from_recep = receptionist.receiveIssueAndAssignMechanic ( issue_to_fix );
		// now sending the accepted issue from receptionist to the mechanic
		mechanic.receivedIssueFromReception ( issue_from_recep );
		
		// now receiving the infromation from mechanic after setting the issue
		String issue_from_mechanic = mechanic.fixedIssueAndInformReception();
		// now sending it back to the receptionist
		assertEquals ( issue_to_fix, receptionist.fixedIssueByMechanic ( issue_from_mechanic ));
		
		// making sure all the expectations are been satisfied
		mock.assertIsSatisfied();
	}
	
	@Test
	void validTestFromCustomerToReceptionToMechanicAndBack() throws Exception
	{
		//validate communication
		// creating an mock object of customer
		ICustomer customer = mock.mock(ICustomer.class);

		// creating an mocked object from mechanic interface to use as mechanic class
		IMechanic mechanic = mock.mock ( IMechanic.class );
		
		// storing a service as an final string variable
		final String serviceName = "Broken Window";
		
		mock.checking(new Expectations () {{
			// expectations for the customer object
			oneOf(customer).askForService(serviceName);
			will(returnValue(serviceName));
			
			oneOf(customer).serviceReceived(serviceName);
			
			// expectations for the mechanic object
			oneOf(mechanic).receivedIssueFromReception(serviceName);
			
			oneOf(mechanic).fixedIssueAndInformReception();
			will(returnValue(serviceName));
		}});

		// Need to create an object of class Receptionist to test it
		Receptionist receptionist = new Receptionist ();
		
		// sending the saved service name to the customer object
		String get_from_customer = customer.askForService(serviceName);
		// the info received from customer ask for service will sending this to recpetion
		String get_from_reception = receptionist.receiveIssueAndAssignMechanic(get_from_customer);
		// the info found from the reception will send to the mechanic
		mechanic.receivedIssueFromReception(get_from_reception);

		// now getting the fixed issue from the mechanic
		String get_from_mechanic = mechanic.fixedIssueAndInformReception();
		// sending the info get from the mechanic to the recpetionist
		String again_get_from_recp = receptionist.fixedIssueByMechanic(get_from_mechanic);
		// sending the info got from the receptionst to the customer
		customer.serviceReceived ( again_get_from_recp );
		
		// making sure all the mocks expectations were satisfied
		mock.assertIsSatisfied();
	}	
	
	//Use a test driver to pretend the customer
	@Test
	void invalidCommunicationFromReceptionToMechanic() throws Exception
	{
		//validate communication
		// we are using the real mechanic object so that we can make the miscommunication
		// happen when communicating between mechanic and the receptionist
		Mechanic mechanic = new Mechanic ();
		// we are using an mocked object for the customer class mainly because it's not
		// our real concern for this test
		ICustomer customer = mock.mock ( ICustomer.class );
		// mocking the receptinist object because the real object will not do the miscommunication
		// that we need to test for this particular test.
		IReceptionist receptionist = mock.mock ( IReceptionist.class );
		
		// some string variable that will be used in this test as input and verify output
		final String serviceName = "Tire Repair";
		final String unknownIssue = "You can go down to the other mechanic shop, they offer this";
		
		// Providing all the expectations that must fulfill to pass the test
		mock.checking(new Expectations () {{
			// there will be one call in the mocked receptionist object on the
			// receiveIssueAndAssignMechanic with the input of serviceName
			// and this method call will return not what we expect, we will modify
			// the expected output so that we can simulate the miscommunication
			oneOf(receptionist).receiveIssueAndAssignMechanic(serviceName);
			will(returnValue("Modified " + serviceName ));

			// this call will do the same as the real object but as the object is
			// mocked so we need this expectations
			oneOf(receptionist).fixedIssueByMechanic(unknownIssue);
			will(returnValue(unknownIssue));
			
			// customer will do as same as the real customer object but as it's our
			// not real concern to test so we are mocking it and doing this expectations
			oneOf(customer).askForService(serviceName);
			will(returnValue ( serviceName ) );
			
			oneOf(customer).serviceReceived(unknownIssue);
		}});
		
		// sending the customer the issue that need to be fixed and holding it's return value
		String got_from_customer = customer.askForService ( serviceName );
		// as there might be an expectations thrown so need to make this inside an try catch
		// block. as we are not expecting any exception so as we found any exception then we
		// should immediately fail the test.
		String got_from_receptionist = null;
		try {
			got_from_receptionist = receptionist.receiveIssueAndAssignMechanic ( got_from_customer );
		} catch ( Exception ex ) {
			fail ( "Found exception where not expected!" );
		}
		// this try catch is needed because there were an miscommunication so this will throw
		// an exception
		try {
			mechanic.receivedIssueFromReception ( got_from_receptionist );
		} catch ( Exception ex ) {
			System.out.println ( "Miss communication happended" );
		}
		// The rest of the communication will happen as normal
		String got_from_mechanic = mechanic.fixedIssueAndInformReception();
		String again_got_from_receptionist = receptionist.fixedIssueByMechanic(got_from_mechanic);
		// verifying the miscommunication handed properly
		customer.serviceReceived(again_got_from_receptionist);
		
		// all the expectations were satisfied
		mock.assertIsSatisfied();
	}
	
	//Test the mechanic class
	@Test
	void testForException() //Use assertThrows
	{
		// creating an real object of the mechanic class
		Mechanic mechanic = new Mechanic ();
		// calling assertThrows method to verify if the mechanic object thrown an
		// exception or not if not exception thrown then test should fail
		Exception thrown = assertThrows (
				Exception.class,
				// lambda executable that will call to make the exception happen
				() -> mechanic.receivedIssueFromReception ( "Invalid Service" ),
				// fail message if there were no exception thrown
				"Expecting mechanic to throw, but it didn't"
			);
		// an string for the expected error message
		final String unknownService = "We do not offer this service";
		// making sure that the exception message matched
		assertTrue ( thrown.getMessage().contains ( unknownService ) );
	}
	
	//Test the customer class
	@Test
	void mockExceptionFromInvalidCustomerOrder() throws Exception
	{
		// creating some string variable to use as input and verification
		final String invalidIssue = "Invalid Issue";
		final String errorService = "This can't solved Here";
		//...
		// mocking the customer object and setting it's expectations
		ICustomer customer = mock.mock ( ICustomer.class );
		mock.checking( new Expectations () {{
			oneOf(customer).askForService( invalidIssue );
			will(returnValue( invalidIssue ));
			oneOf(customer).serviceReceived(errorService);
		}});
		// mocking the receptionist object and setting it's expectations
		// this object is needed to verify the communication between customer and receptionist class
		IReceptionist receptionist = mock.mock(IReceptionist.class);
		mock.checking(new Expectations () {{
			oneOf(receptionist).receiveIssueAndAssignMechanic( invalidIssue );
			will(throwException(new Exception("Exception From Receptionist")));
			
			oneOf(receptionist).fixedIssueByMechanic(errorService);
			will(returnValue(errorService));
		}});
		//then use assertThrows
		Exception thrown = assertThrows (
				Exception.class,
				// lambda executable that will throw the exception
				() -> receptionist.receiveIssueAndAssignMechanic(
						customer.askForService(invalidIssue)
					),
				"Expecting receptionist to thow exception, but didn't"
			);
		// verifying the exception message
		assertTrue ( thrown.getMessage().contains("Exception From Receptionist" ) );
		
		// verifying the communication
		customer.serviceReceived(
				receptionist.fixedIssueByMechanic(errorService)
			);
		
		//validate communication
		mock.assertIsSatisfied();
	}
}
