package com.testNG;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.TestBase.BaseFunction;

public class TNG_09_Amazon_GroupsExecutionScript extends BaseFunction {
	String expecteUTL = "https://www.nitin.in/b/32702023031?node=32702023031&ld=AZINSOANavDesktop_T3&ref_=nav_cs_sell_T3";

	@BeforeTest(alwaysRun = true)
	public void openBrowser() {
		launchBrowser("Chrome");
	}

	@BeforeMethod(alwaysRun = true)
	public void openAmazon() throws InterruptedException {
		launchURL("https://www.amazon.in/");
		Thread.sleep(2000);
	}

	@Test(priority = 1, groups = "Sell")
	public void testSellLink() {
		driver.findElement(By.linkText("Sell")).click();

		String currentURL = driver.getCurrentUrl();
		System.out.println("testSellLink");

		Assert.assertEquals(currentURL, expecteUTL, " sell url is invalid, please verify");

	}

	@Test(priority = 2, groups = "Sell")
	public void testBestSellerLink() {
		driver.findElement(By.partialLinkText("Best")).click();
		System.out.println("testBestSellerLink");
	}

	@Test(priority = 3, groups = "Devices")
	public void testElectronicLink() {
		driver.findElement(By.partialLinkText("Electronics")).click();
		System.out.println("testElectronicLink");
	}

	@Test(priority = 4, groups = "Devices")
	public void testMobilesLink() {
		driver.findElement(By.partialLinkText("Mobiles")).click();
		System.out.println("testMobilesLink");
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		System.out.println("execution done!");
	}

	@AfterTest(alwaysRun = true)
	public void stopExecution() {
		driver.close();
	}

}
