package com.testNG;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.TestBase.BaseFunction;

public class TNG_05RandomScenarioWithTestNG extends BaseFunction {

	@Parameters({ "Username", "Password" })

	@Test(priority = 1)
	public void loginHRM(String un, String pwd) throws InterruptedException {

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/i")).click();
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/ul/li[4]/a")).click();
	}

	@Test(priority = 2)
	public void loginHRM1() {

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Nitin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Test(priority = 3)
	public void loginHRM2() {

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("sachin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("BeforeTest");
		launchBrowser("Chrome");

	}

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		System.out.println("Before Method");
		launchURL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(1500);
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {

		System.out.println("AfterMethod");
		Thread.sleep(1000);
	}

	@AfterTest
	public void exitDriver() {

		System.out.println("AfterTest");
		driver.close();
	}

}
