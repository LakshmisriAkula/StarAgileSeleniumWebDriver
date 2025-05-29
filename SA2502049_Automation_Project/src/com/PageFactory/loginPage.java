package com.PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.BaseFunction;

public class loginPage extends BaseFunction {

	static @FindBy(id = "email") WebElement email;
	static @FindBy(id = "pass") WebElement password;
	static @FindBy(name = "login") WebElement submit;

	public static void main(String[] args) {
		launchBrowser("Chrome");
		launchURL("https://www.facebook.com/");
		PageFactory.initElements(driver, loginPage.class);
		login();

	}

	public static void login() {
		email.sendKeys("nithin@gmail.com");
		password.sendKeys("nithin@123");
		submit.click();
		driver.close();
	}

}
