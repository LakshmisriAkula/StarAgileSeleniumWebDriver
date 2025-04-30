package com.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class AS_08 {

	public static void main(String[] args) throws InterruptedException {
//		8. 	Open https://www.facebook.com/
//			a.	Enter valid user name as test@gmail.com  (Use Relative Locator)
//			b.	Enter invalid password (Use Relative Locator)
//			c.	Click on Login button (Use Relative Locator)
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.facebook.com/");

		driver.findElement(RelativeLocator.with(By.xpath("//input[@type='text']")).above(By.xpath("//input[@type='password']"))).sendKeys("test@gmail.com");
		
		driver.findElement(RelativeLocator.with(By.xpath("//input[@type='password']")).below(By.xpath("//input[@type='text']"))).sendKeys("123");
		
		driver.findElement(RelativeLocator.with(By.xpath("//*[@type='submit']")).below(By.xpath("//input[@type='password']"))).click();
		Thread.sleep(5000);

		
		
		driver.close();
	}

}
