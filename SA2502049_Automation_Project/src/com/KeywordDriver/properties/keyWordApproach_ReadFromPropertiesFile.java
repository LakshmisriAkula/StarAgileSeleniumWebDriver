package com.KeywordDriver.properties;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.TestBase.BaseFunction;

public class keyWordApproach_ReadFromPropertiesFile extends BaseFunction {
	File file;
	FileInputStream fis;
	Properties prop;

	// keyword driver approach.
	@Test
	public void LoginFacebook() {
		System.out.println("Application URL " + driver.getTitle());

		driver.findElement(By.id(prop.getProperty("Login_Username_Id"))).sendKeys(prop.getProperty("Login_Username"));
		driver.findElement(By.id(prop.getProperty("Login_Password_Id"))).sendKeys(prop.getProperty("Login_Password"));
		driver.findElement(By.name(prop.getProperty("Login_Button_Name"))).click();
	}

	@BeforeTest
	public void beforeTest() {

		try {

			file = new File(
					"E:\\StarAgile Webdriver\\StarAgileSeleniumWebDriver\\SA2502049_Automation_Project\\src\\KeyWord.properties");
			fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis); // load the each key(property) at run time to access testcases.

		} catch (Exception e) {
			System.out.println("Message " + e.getMessage());
		}

		String[] appURL = prop.getProperty("appURL").split(",");
		System.out.println("1 URl" + appURL[0]);
		System.out.println("2 URl" + appURL[1]);
		String faceBookURL = appURL[0];

		launchBrowser("Chrome");
		launchURL(faceBookURL);

	}

	@AfterTest
	public void afterTest() {

		driver.quit();
	}

}