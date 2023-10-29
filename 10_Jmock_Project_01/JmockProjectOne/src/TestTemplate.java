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
		Mechanic mechanic = new Mechanic ();
		ICustomer customer = mock.mock ( ICustomer.class );
		IReceptionist receptionist = mock.mock ( IReceptionist.class );
		
		final String serviceName = "Tire Repair";
		final String unknownIssue = "You can go down to the other mechanic shop, they offer this";
		
		mock.checking(new Expectations () {{
			oneOf(receptionist).receiveIssueAndAssignMechanic(serviceName);
			will(returnValue("Modified " + serviceName ));

			oneOf(receptionist).fixedIssueByMechanic(unknownIssue);
			will(returnValue(unknownIssue));
			
			oneOf(customer).askForService(serviceName);
			will(returnValue ( serviceName ) );
			
			oneOf(customer).serviceReceived(unknownIssue);
		}});
		
		String got_from_customer = customer.askForService ( serviceName );
		String got_from_receptionist = null;
		try {
			got_from_receptionist = receptionist.receiveIssueAndAssignMechanic ( got_from_customer );
		} catch ( Exception ex ) {
			fail ( "Found exception where not expected!" );
		}
		try {
			mechanic.receivedIssueFromReception ( got_from_receptionist );
		} catch ( Exception ex ) {
			System.out.println ( "Miss communication happended" );
		}
		String got_from_mechanic = mechanic.fixedIssueAndInformReception();
		String again_got_from_receptionist = receptionist.fixedIssueByMechanic(got_from_mechanic);
		customer.serviceReceived(again_got_from_receptionist);
		
		// all the expectations were satisfied
		mock.assertIsSatisfied();
	}
	
	//Test the mechanic class
	@Test
	void testForException() //Use assertThrows
	{
		Mechanic mechanic = new Mechanic ();
		Exception thrown = assertThrows (
				Exception.class,
				// lambda
				() -> mechanic.receivedIssueFromReception ( "Invalid Service" ),
				"Expecting mechanic to throw, but it didn't"
			);
		final String unknownService = "We do not offer this service";
		assertTrue ( thrown.getMessage().contains ( unknownService ) );
	}
	
	//Test the customer class
	@Test
	void mockExceptionFromInvalidCustomerOrder() throws Exception
	{
		final String invalidIssue = "Invalid Issue";
		final String errorService = "This can't solved Here";
		//...
		ICustomer customer = mock.mock ( ICustomer.class );
		mock.checking( new Expectations () {{
			oneOf(customer).askForService( invalidIssue );
			will(returnValue( invalidIssue ));
			oneOf(customer).serviceReceived(errorService);
		}});
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
				() -> receptionist.receiveIssueAndAssignMechanic(
						customer.askForService(invalidIssue)
					),
				"Expecting receptionist to thow exception, but didn't"
			);
		assertTrue ( thrown.getMessage().contains("Exception From Receptionist" ) );
		
		customer.serviceReceived(
				receptionist.fixedIssueByMechanic(errorService)
			);
		
		//validate communication
		mock.assertIsSatisfied();
	}
}
