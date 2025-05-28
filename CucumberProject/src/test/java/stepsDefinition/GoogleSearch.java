package stepsDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearch {

	WebDriver driver;

	@Given("Launch google URl on Browser")
	public void launch_google_u_rl_on_browser() {
		// Write code here that turns the phrase above into concrete actions
		driver=new ChromeDriver();
		driver.get("https://www.google.com/");
	}

	@When("Enter data for search in search box")
	public void enter_data_for_search_in_search_box() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("q")).sendKeys("Sachin Tendulkar");
	}

	@When("Hit Enter")
	public void hit_enter() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("q")).sendKeys("Sachin Tendulkar", Keys.ENTER);
	}

	@Then("valid Search result shoult display")
	public void valid_search_result_shoult_display() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println(driver.getTitle().contains("Sachin"));
	}

}
