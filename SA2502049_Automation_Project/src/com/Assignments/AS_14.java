package com.Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.TestBase.BaseFunction;

public class AS_14 extends BaseFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "https://www.redbus.in/";
		launchBrowser("Chrome");
		launchURL(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement fromInput = driver.findElement(By.id("src"));
		fromInput.click();
		fromInput.sendKeys("Kolh");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='sc-dnqmqq dZhbJF']/li[1]")))
				.click();

		WebElement toInput = driver.findElement(By.id("dest"));
		toInput.click();
		toInput.sendKeys("Ban");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='sc-dnqmqq dZhbJF']/li[1]")))
				.click();

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
		List<WebElement> busList = wait.until(ExpectedConditions
				.presenceOfAllElementsLocatedBy(By.xpath("(//div[@class='travels lh-24 f-bold d-color'])[1]")));

		if (!busList.isEmpty()) {
			System.out.println("First Bus Name: " + busList.get(0).getText());
		} else {
			System.out.println("No buses found.");
		}

		driver.close();
	}
}