package com.testNG;

import java.io.File;
import org.openqa.selenium.io.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.TestBase.BaseFunction;

public class TNG_08_GetScreenshot_SkipFunction_Assertions extends BaseFunction {

	String expecteUTL = "https://www.nitin.in/b/32702023031?node=32702023031&ld=AZINSOANavDesktop_T3&ref_=nav_cs_sell_T3";

	@BeforeTest
	public void openBrowser() {
		launchBrowser("Chrome");
	}

	@BeforeMethod
	public void openAmazon() throws InterruptedException {
		launchURL("https://www.amazon.in/");
		Thread.sleep(2000);
	}

	@Test(priority = 1,enabled = false)
	public void testSellLink() {
		 driver.findElement(By.linkText("Sell")).click();

		 String currentURL = driver.getCurrentUrl();
		System.out.println("testSellLink");

		 Assert.assertEquals(currentURL,expecteUTL," sell url is invalid, please verify");

		// takeScreenShots();
	}

	@Test(priority = 2)
	public void testBestSellerLink() {
		// driver.findElement(By.partialLinkText("Best")).click();
		System.out.println("testBestSellerLink");
	}

	@Test(priority = 3)
	public void testElectronicLink() {
		// driver.findElement(By.partialLinkText("Electronics")).click();
		System.out.println("testElectronicLink");
	}

	@Test(priority = 4)
	public void testMobilesLink() {
		// driver.findElement(By.partialLinkText("Mobiles")).click();
		System.out.println("testMobilesLink");
	}

	@AfterMethod
	public void closeBrowser() {
		System.out.println("execution done!");
		takeScreenShots();
	}

	@AfterTest
	public void stopExecution() {
		driver.quit(); //
		// driver.close(); // amazon.com
	}

	private void takeScreenShots() {
		// TODO Auto-generated method stub
		try {
			File sourceFileLocation = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(sourceFileLocation, new File("lucky.jpeg"));
			File file = new File("lucky.jpeg");
		} catch (Exception e) {
			System.out.println("error " + e.getMessage());
		}
	}
}
