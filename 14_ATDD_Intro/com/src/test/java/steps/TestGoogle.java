package steps;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestGoogle {
	
	WebDriver driver = null;

	@Given("Open your prefered web browser")
	public void open_your_prefered_web_browser() {
		// setting the Chrome driver location based on the running machines OS
		String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
		String location = "";
		if ( OS.equals( "linux" ) ) {
			location = "/usr/bin/chromedriver";
		} else if ( OS.equals( "windows 11") || OS.equals( "windows 10" ) ) {
			location = "./chromeDriver/chromedriver.exe";
		} else {
			System.out.println ( "Unknown OS. Test Can't run." );
		}
		System.setProperty ( "webdriver.chrome.driver", location );

		driver = new ChromeDriver ();
	}
	@Given("load the google search web page")
	public void load_the_google_search_web_page() {
		driver.get("https://google.com/");
	}
	@When("i search for {string} in google")
	public void i_search_for_in_google(String string) {
		WebElement inputField = driver.findElement(By.tagName("textarea"));
		inputField.sendKeys( string );
		inputField.sendKeys(Keys.ENTER);
	}
	@When("go to the first search result")
	public void go_to_the_first_search_result() {
		WebElement firstLink = driver.findElement(By.tagName("h3"));
		firstLink.click();
	}
	@Then("i found the {string} as the webpage link")
	public void i_found_the_as_the_webpage_link(String string) {
		assertEquals ( string, driver.getCurrentUrl() );
	}
	@Then("the title should be {string}")
	public void the_title_should_be(String string) {
		assertEquals ( string, driver.getTitle() );
	}
	@Then("close the web browser")
	public void close_the_web_browser() {
		driver.close();
	}

}
