package com.Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

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

//		RedBus.com
        // b. Enter "Kolh" in FROM input and select 1st suggestion
//        WebElement fromInput = driver.findElement(By.id("src"));
//        fromInput.click();
//        fromInput.sendKeys("Kolh");
//        Thread.sleep(5000); // Wait for suggestions to load
//
//        
//        driver.findElement(By.xpath("//ul[@class='sc-dnqmqq dZhbJF']/li[1]")).click();
//        
//        Thread.sleep(1000);
//
//        // c. Enter "Ban" in TO input and select 1st suggestion
//        WebElement toInput = driver.findElement(By.id("dest"));
//        toInput.click();
//        toInput.sendKeys("Ban");
//        Thread.sleep(5000); // Wait for suggestions to load
//        driver.findElement(By.xpath("//ul[@class='sc-dnqmqq dZhbJF']/li[1]")).click();
//
//
//        // d. Click on calendar icon
//        WebElement dateInput = driver.findElement(By.id("onwardCal"));
//        dateInput.click();
//        Thread.sleep(1000);
//
//        // e. Click on date 31 (first match from calendar)
//        List<WebElement> dateList = driver.findElements(By.xpath("//span[text()='31']"));
//        if (!dateList.isEmpty()) {
//            dateList.get(0).click();
//        } else {
//            System.out.println("Date 31 not available.");
//            driver.quit();
//            return;
//        }
//
//        // f. Click Search Buses button
//        WebElement searchButton = driver.findElement(By.id("search_button"));
//        searchButton.click();
//
//        // g. Wait for search results and extract first bus name
//        Thread.sleep(6000);
//        List<WebElement> busList = driver.findElements(By.xpath("(//div[@class='travels lh-24 f-bold d-color'])[1]"));
//        if (!busList.isEmpty()) {
//            System.out.println("First Bus Name: " + busList.get(0).getText());
//        } else {
//            System.out.println("No buses found.");
//        }

		
		

		
        // b. Enter "Kolh" in FROM input and select 1st suggestion
		driver.findElement(By.cssSelector("div[class='label___201428 ']")).click();
        WebElement fromInput = driver.findElement(By.cssSelector("(//div[contains(text(),'From')]"));
//        fromInput.click();
        fromInput.sendKeys("Kolh");
        Thread.sleep(2000); // Wait for suggestions to load
        fromInput.sendKeys(Keys.DOWN);
        fromInput.sendKeys(Keys.ENTER);

        // c. Enter "Ban" in TO input and select 1st suggestion
        WebElement toInput = driver.findElement(By.xpath("//input[@placeholder='To']"));
        toInput.click();
        toInput.sendKeys("Ban");
        Thread.sleep(2000); // Wait for suggestions to load
        toInput.sendKeys(Keys.DOWN);
        toInput.sendKeys(Keys.ENTER);

        // d. Click on calendar icon
        WebElement dateInput = driver.findElement(By.xpath("//div[contains(@class,'DatePicker')]/input"));
        dateInput.click();
        Thread.sleep(1000);

        // e. Click on date 31 (first match from calendar)
        List<WebElement> dateList = driver.findElements(By.xpath("//span[text()='31']"));
        if (!dateList.isEmpty()) {
            dateList.get(0).click();
        } else {
            System.out.println("Date 31 not available.");
            driver.quit();
            return;
        }

        // f. Click Search Buses button
        WebElement searchButton = driver.findElement(By.xpath("//button[text()='Search Buses']"));
        searchButton.click();

        // g. Wait for search results and extract first bus name
        Thread.sleep(6000);
        List<WebElement> busList = driver.findElements(By.xpath("//div[@class='travels lh-24 f-bold d-color']"));
        if (!busList.isEmpty()) {
            System.out.println("First Bus Name: " + busList.get(0).getText());
        } else {
            System.out.println("No buses found.");
        }

        // Close browser
        driver.quit();
    }
}