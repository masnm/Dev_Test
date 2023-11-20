import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.Select;

// this is the test class which will be used / run by juint to do the testing
public class KabirBidushiLab8
{
	// Declaring an webdriver object to use the chrome driver
	private static WebDriver webdriver;
	// storing the address of the web-page we are going to test
	private static final String WebSite = "https://demo.guru99.com/test/newtours/";

	// this method will called before any test run to do the initialization of the
	// necessary object to do the testing.
	@BeforeAll
	public static void init()
	{
		// setting the chrome driver location to the jvm system property
		System.setProperty("webdriver.chrome.driver", "./chrome/chromedriver.exe");
		// turning off the logger so the output will not be filled with random garbage
		Logger.getLogger("").setLevel(Level.OFF);
		// initializing the webdriver object with an chrome driver because we want to use
		// chrome web browser for out testing
		webdriver = new ChromeDriver();
		// turning off the log output of the chrome driver
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
	}

	// this method will called after all the test has been run completed to do the cleanup
	@AfterAll
	public static void finalCleanup()
	{
		// closing the chrome browser window / webdriver object
		webdriver.close();
	}
	
	// this method will create all the object again before each test
	// so that no test can influence any other test
	@BeforeEach
	public void recreateEverything () {
		// createting an new chrome driver object
		webdriver = new ChromeDriver ();
	}
	
	// this method will run after each test to do the necessary cleanup
	@AfterEach
	public void eachCleanup () {
		// closing the chrome browser window / webdriver object
		webdriver.close();
	}

	// this method test the flight booking feature of the web-site
	@Test
	public void flightsBookTest()
	{
		// loading the web-page on the web browser
		webdriver.get(WebSite);
		// clicking on the Flights button to book an flight
		clickButtonByXpath("//*[contains(text(), 'Flights')]");
		// selecting the trip type as an Round Trip
		clickButtonByNameAndValue("RoundTrip", "tripType");
		// Selecting the passengers count as 2
		selectDropDownByName("2", "passCount");
		// Selecting the trip start location as London
		selectDropDownByName("London", "fromPort");
		// selecting the trip start month as June
		selectDropDownByName("June", "fromMonth");
		// selecting the trip start date as 11'th
		selectDropDownByName("11", "fromDay");
		// selecting the trip destination as Paris
		selectDropDownByName("Paris", "toPort");
		// selecting the trip end moth as August
		selectDropDownByName("August", "toMonth");
		// selecting the Service class as first class
		clickButtonByNameAndValue("servClass", "First");
		// selecting the airline as Unified Airlines
		selectDropDownByName("Unified Airlines", "airline");
		// clicking the findFlights button to find a flight
		clickButtonByName("findFlights");
		// checking if the expected text is found on the webpage or not
		// if found then everything is ok and test should pass
		// if not then something is not ok an test should fail
		assertTrue(isTextPresent("After flight finder - No Seats Avaialble"));
	}

	// this method tests the registration feature of the web-site
	@Test
	public void loadRegistrationPage()
	{
		// loading the webpage
		webdriver.get(WebSite);
		// clicking the Register button to load the registration page
		clickButtonByXpath("//*[contains(text(), 'REGISTER')]");
		// setting the fist name as Dough
		sendKeyByName("Dough", "firstName");
		// setting the last name as Walker
		sendKeyByName("Walker", "lastName");
		// setting the phone number as 12345
		sendKeyByName("12345", "phone");
		// setting the user-name as 'ditu@yahoo.com'
		sendKeyByName("ditu@yahoo.com", "userName");
		// setting the address one
		sendKeyByName("456 aad drive", "address1");
		// setting the city ass toronto
		sendKeyByName("toronto", "city");
		// setting the state an 'ON'
		sendKeyByName("ON", "state");
		// setting the postal code as 'KK34 GF'
		sendKeyByName("KK34 GF", "postalCode");
		// setting the email / user name as 'sdf@yahoo.com'
		sendKeyByName("sdf@yahoo.com", "email");
		// setting the password as 'aaaddd'
		sendKeyByName("aaaddd", "password");
		// setting the confirm password as 'aaaddd'
		sendKeyByName("aaaddd", "confirmPassword");
		// setting the country as 'Canada'
		selectDropDownByName("CANADA", "country");
		// clicking the submit button to complete the regrestration
		clickButtonByName("submit");
		// checking if the expected text is found on the webpage or not
		// if found then everything is ok and test should pass
		// if not then something is not ok an test should fail
		assertTrue(isTextPresent("Thank you"));
	}

	// this method takes an name ( html attribute ) and an key
	// and it finds the element using the name and send the key to the element
	public void sendKeyByName(String keys, String name)
	{
		// finding the webelement using the name attribure
		WebElement abc = webdriver.findElement(By.name(name));
		// sending the key to the element
		abc.sendKeys(keys);
	}

	// this method takes an name ( html attribute ) and an option which is expected to be
	// visible on the drop-down menu and this method will select the option on the
	// drop-down menu
	public void selectDropDownByName(String option, String name)
	{
		// finding the web elemet using the name attribute
		WebElement abc = webdriver.findElement(By.name(name));
		// converting the object to an select object which is more suitable for
		// working  with drop-down menue's
		Select select = new Select(abc);
		// selecting the option that was provided as an input of this method
		select.selectByVisibleText(option);
	}

	// this method checks if an text is present on the current web-page or not
	public boolean isTextPresent(String text)
	{
		return webdriver.getPageSource().contains(text);
	}

	// this method takes an id as a string and find an WebElement from the current
	// web-page and clink on it.
	public void clickButtonById(String Id)
	{
		// finding the webelement object
		WebElement button = webdriver.findElement(By.id(Id));
		// clicking on the object
		button.click();
	}

	// this method takes an Xpath as a string and find an WebElement from the current
	// web-page and clink on it.
	public void clickButtonByXpath(String Xpath)
	{
		// finding the webelement object
		WebElement button = webdriver.findElement(By.xpath(Xpath));
		// clicking on the object
		button.click();
	}

	// this method takes an name ( html attribute ) as a string and find an WebElement from the current
	// web-page and clink on it.
	public void clickButtonByName(String name)
	{
		// finding the webelement object
		WebElement button = webdriver.findElement(By.name(name));
		// clicking on the object
		button.click();
	}

	// this methods helps us the click an radio button where all the button options has the
	// same name ( html attribute ), so using the name find all the elements and click
	// the one which has the expected value on it.
	public void clickButtonByNameAndValue(String name, String value)
	{
		// finding all the elements where they have same name attribute
		List<WebElement> list = webdriver.findElements(By.name(name));
		// looping over all the element
		for (WebElement element : list)
		{
			// getting the value of the current element
			String actualValue = element.getAttribute("value");
			// comparing the value of current element and expected value
			if (actualValue.equals(value))
			{
				// if they match then click it
				element.click();
			}
		}
	}

}
