import java.time.Duration;
import java.util.Locale;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuceDemoTest {
	
	private static WebDriver driver;
	private static final String WebSite = "https://www.saucedemo.com/";
	
	private static final String usrStan = "standard_user";
	private static final String usrLock = "locked_out_user";
	private static final String usrProb = "problem_user";
	private static final String usrGlit = "performance_glitch_user";
	
	private static final String password = "secret_sauce";
	
	@BeforeClass
	public static void beforeClass () {
		String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
		String location = "";
		if ( OS.equals( "linux" ) ) {
			location = "/usr/bin/chromedriver";
		} else if ( OS.equals( "windows 11") || OS.equals( "windos 10" ) ) {
			location = "./chromeDriver/chromedriver.exe";
		} else {
			System.out.println ( "Unknown OS. Test Can't run." );
		}
		System.setProperty ( "webdriver.chrome.driver", location );
	}
	
	@Before
	public void before () {
		driver = new ChromeDriver ();
		driver.get(WebSite);
	}
	
	@After
	public void after () {
		driver.quit();
	}
	
	private void setKeyById ( String id, String key ) {
		// finding the input box with id
		WebElement element = driver.findElement( By.id( id ) );
		// sending a key to the element
		element.sendKeys ( key );
	}
	
	private void clickButtonById ( String id ) {
		// finding the button using id
		WebElement Button = driver.findElement ( By.id( id ) );
		// clicking the button
		Button.click ();
	}
	
	private void waitByIdToLoad ( String id ) {
		// creating the wait object with webdriver duration of 2 seconds
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		// waiting for the element to load
		wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
	}
	
	@Test
 	public void loginStandard () {
		// finding and setting the user name
		setKeyById ( "user-name", usrStan );
		
		// finding and setting the password
		setKeyById ( "password", password );
		
		// finding and clicking the login button
		clickButtonById ( "login-button" );
		
		// getting the url of the page after tried to login
		String url = driver.getCurrentUrl();
		
		// if login successful then we should see the url in the inventory
		Assert.assertEquals( "https://www.saucedemo.com/inventory.html", url );
	}
	
	@Test
	public void loginLocked () {
		// finding and setting the user name
		setKeyById ( "user-name", usrLock );
		
		// finding and setting the password
		setKeyById ( "password", password );
		
		
		// finding and clicking the login button
		clickButtonById ( "login-button" );
		
		// getting the url of the page after tried to login
		String url = driver.getCurrentUrl();
		
		// if login successful then we should see the url in the inventory
		Assert.assertNotEquals( "https://www.saucedemo.com/inventory.html", url );
	}
	
	@Test
	public void loginProblem () {
		// finding and setting the user name
		setKeyById ( "user-name", usrProb );
		
		// finding and setting the password
		setKeyById ( "password", password );
		
		
		// finding and clicking the login button
		clickButtonById ( "login-button" );
		
		// getting the url of the page after tried to login
		String url = driver.getCurrentUrl();
		
		// if login successful then we should see the url in the inventory
		Assert.assertEquals( "https://www.saucedemo.com/inventory.html", url );
	}
	
	@Test
	public void loginGlitch () {
		// finding and setting the user name
		setKeyById ( "user-name", usrGlit );
		
		// finding and setting the password
		setKeyById ( "password", password );
		
		
		// finding and clicking the login button
		clickButtonById ( "login-button" );
		
		// getting the url of the page after tried to login
		String url = driver.getCurrentUrl();
		
		// if login successful then we should see the url in the inventory
		Assert.assertEquals( "https://www.saucedemo.com/inventory.html", url );
	}

	@Test
	public void logoutStandard () {
		// to test login firstly we must login first
		loginStandard ();
		
		// clicking the menu button to open the menu option
		clickButtonById ( "react-burger-menu-btn" );
		
		// waiting for the logout button to be visible
		waitByIdToLoad ( "logout_sidebar_link" );
		
		// clicking the logout button
		clickButtonById ( "logout_sidebar_link" );
		
		// getting the current to verify the logout
		String url = driver.getCurrentUrl();
		
		// checking if the logout was successful and link is changed
		Assert.assertEquals ( "https://www.saucedemo.com/", url );
	}
	
	@Test
	public void logoutLocked () {
		// to test login firstly we must login first
		loginLocked ();
		
		// clicking the menu button to open the menu option
		clickButtonById ( "react-burger-menu-btn" );
		
		// waiting for the logout button to be visible
		waitByIdToLoad ( "logout_sidebar_link" );
		
		// clicking the logout button
		clickButtonById ( "logout_sidebar_link" );
		
		// getting the current to verify the logout
		String url = driver.getCurrentUrl();
		
		// checking if the logout was successful and link is changed
		Assert.assertEquals ( "https://www.saucedemo.com/", url );
	}
	
	@Test
	public void logoutProblem () {
		// to test login firstly we must login first
		loginProblem ();
		
		// clicking the menu button to open the menu option
		clickButtonById ( "react-burger-menu-btn" );
		
		// waiting for the logout button to be visible
		waitByIdToLoad ( "logout_sidebar_link" );
		
		// clicking the logout button
		clickButtonById ( "logout_sidebar_link" );
		
		// getting the current to verify the logout
		String url = driver.getCurrentUrl();
		
		// checking if the logout was successful and link is changed
		Assert.assertEquals ( "https://www.saucedemo.com/", url );
	}

	@Test
	public void logoutGlitch () {
		// to test login firstly we must login first
		loginGlitch ();
		
		// clicking the menu button to open the menu option
		clickButtonById ( "react-burger-menu-btn" );
		
		// waiting for the logout button to be visible
		waitByIdToLoad ( "logout_sidebar_link" );
		
		// clicking the logout button
		clickButtonById ( "logout_sidebar_link" );
		
		// getting the current to verify the logout
		String url = driver.getCurrentUrl();
		
		// checking if the logout was successful and link is changed
		Assert.assertEquals ( "https://www.saucedemo.com/", url );
	}

}
