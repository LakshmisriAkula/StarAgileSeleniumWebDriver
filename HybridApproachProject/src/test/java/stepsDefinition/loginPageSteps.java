package stepsDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.loginPage;

public class loginPageSteps {
	loginPage lpage = new loginPage();

	@Given("The user launch the application URL {string}")
	public void the_user_launch_the_application_url(String URL) {
		lpage.launchURL(URL);
	}

	@When("The User enter email {string} and password {string}")
	public void the_user_enter_email_and_password(String un, String pwd) {
		lpage.login(un, pwd);
	}
}
