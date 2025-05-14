package com.RandomScenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.TestBase.BaseFunction;

public class SA_29HandlingElementAttributes extends BaseFunction {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		launchBrowser("Chrome");
		launchURL("https://demoqa.com/text-box");
		WebElement userName = driver.findElement(By.id("userName"));
		String placeHolder = userName.getDomAttribute("placeholder");
		System.out.println(placeHolder);
		userName.sendKeys("Nithin");
		Thread.sleep(500);
		userName.clear();
		Thread.sleep(500);
		driver.close();
	}

}
