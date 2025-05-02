package com.Assignments;

import org.openqa.selenium.By;

import com.WebDriverDemos.BaseFunction;

public class AS_13 extends BaseFunction {

	public static void main(String[] args) throws InterruptedException {
//		13.	Open https://www.redbus.in/ 
//			a.	 In From Enter first 4 characters of your city (Kolhapur -> Kolh)
//			b.	Select 1st Option from the list displayed
//			c.	In To Enter first 4 characters of your city (Banglore -> Ban)
//			d.	Select 1st Option from the list displayed
//			e.	Click on Calendar icon
//			f.	Click on Date 31
//			g.	Click on Search Buses button
//			h.	Display the name of 1st Bus from the list 

		String url = "https://www.redbus.in/";
		launchBrowser("Chrome");
		launchURL(url);

		Thread.sleep(1000);
//
		driver.findElement(By.cssSelector("[class*='srcDest']")).click();

		Thread.sleep(1000);
		

		driver.findElement(By.cssSelector(".inputWrapper___6e522f")).sendKeys("Visa"); 
//		driver.findElement(By.cssSelector(".sc-bxivhb.dsDRlf")).sendKeys("visa");
		
		
		Thread.sleep(3000);

//		driver.findElement(By.className("sc-gZMcBi hviMLb")).click();
		driver.findElement(By.xpath("//ul[@class='autoFill']/li[1]")).click();
		

		Thread.sleep(3000);

//		driver.findElement(By.xpath("(//div[@class='label___7cec60 '])[2]")).click();

		driver.findElement(By.className("inputWrapper___6e522f")).sendKeys("Hyd");

		Thread.sleep(3000);

		driver.findElement(By.xpath("//ul[@class='autoFill']/li[1]")).click();

		Thread.sleep(3000);

		driver.findElement(By.className("doj___7d7da6")).click();

		driver.findElement(By.xpath("//*[contains(@text,'31')]")).click();

		Thread.sleep(2000);

		driver.findElement(By.className("primaryButton___d6c460 searchButtonWrapper___ef701a")).click();

		Thread.sleep(3000);

		String text = driver.findElement(By.xpath("(//*[@class='rtcName___a725bd'])[1]")).getText();

		System.out.println("name of 1st Bus from the list " + text);

//        driver.findElement(By.xpath("//ul[@class='autoFill']/li[1]")).click();
//
//        // Enter To city (Bangalore -> Ban)
//        driver.findElement(By.id("dest")).sendKeys("Ban");
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//ul[@class='autoFill']/li[1]")).click();
//
//        // Click on calendar icon
//        driver.findElement(By.id("onward_cal")).click();
//        Thread.sleep(1000);
//
//        // Click on Date 31 (Make sure it exists in current month)
//        try {
//            driver.findElement(By.xpath("//td[text()='31']")).click();
//        } catch (Exception e) {
//            System.out.println("Date 31 not available in the current month.");
//            driver.quit();
//            return;
//        }
//
//        // Click on Search Buses button
//        driver.findElement(By.id("search_btn")).click();
//        Thread.sleep(5000);
//
//        // Display the name of the 1st bus
//        try {
//            String text = driver.findElement(By.xpath("(//div[@class='travels lh-24 f-bold d-color'])[1]")).getText();
//            System.out.println("Name of 1st Bus from the list: " + text);
//        } catch (Exception e) {
//            System.out.println("Unable to fetch first bus name. It may not have loaded yet.");
//        }

	}
	
	

}
