package com.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AS_04 {

	public static void main(String[] args) throws InterruptedException {
//		4. a. Find any login and automate with using Id and class locators in css
//	    b. Find any login and automate with using # and . in locators in css
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.facebook.com/");

		driver.findElement(By.cssSelector("#email")).sendKeys("star@it.com");

		driver.findElement(By.cssSelector("input[class^='inputtext']")).sendKeys("pass");

		driver.findElement(By.cssSelector("button[class*='selected']")).click();

		Thread.sleep(5000);

		driver.close();
	}

}
