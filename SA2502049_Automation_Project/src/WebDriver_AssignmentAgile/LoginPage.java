package WebDriver_AssignmentAgile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	By userNameField = By.id("username");
	By passwordField = By.id("password");
	By loginButton = By.id("loginbtn");

	public LoginPage(WebDriver driver) {

		this.driver = driver;

	}

	public void enterUserName(String username) {
		
		driver.findElement(userNameField).sendKeys(username);

	}

	public void enterPassword(String password) {
		
		driver.findElement(passwordField).sendKeys(password);


	}

	public void clickLoginButton() {
		
		driver.findElement(loginButton).click();


	}

}
