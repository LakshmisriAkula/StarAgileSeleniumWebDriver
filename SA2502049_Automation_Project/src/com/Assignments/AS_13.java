package com.Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.TestBase.BaseFunction;

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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement fromInput = driver.findElement(By.id("src"));
		fromInput.click();
		fromInput.sendKeys("Kolh");

		driver.findElement(By.xpath("//ul[@class='sc-dnqmqq dZhbJF']/li[1]")).click();

		WebElement toInput = driver.findElement(By.id("dest"));
		toInput.click();
		toInput.sendKeys("Ban");
		driver.findElement(By.xpath("//ul[@class='sc-dnqmqq dZhbJF']/li[1]")).click();

		WebElement dateInput = driver.findElement(By.id("onwardCal"));
		dateInput.click();

		List<WebElement> dateList = driver.findElements(By.xpath("//span[text()='31']"));
		if (!dateList.isEmpty()) {
			dateList.get(0).click();
		} else {
			System.out.println("Date 31 not available.");
			driver.quit();
			return;
		}

		WebElement searchButton = driver.findElement(By.id("search_button"));
		searchButton.click();

		List<WebElement> busList = driver.findElements(By.xpath("(//div[@class='travels lh-24 f-bold d-color'])[1]"));
		if (!busList.isEmpty()) {
			System.out.println("First Bus Name: " + busList.get(0).getText());
		} else {
			System.out.println("No buses found.");
		}

		driver.close();
	}
}