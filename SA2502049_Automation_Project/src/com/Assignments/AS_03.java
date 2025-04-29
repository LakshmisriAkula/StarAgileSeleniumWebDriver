package com.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AS_03 {

	public static void main(String[] args) throws InterruptedException {
//		 3. Open facebook.com/
//		 	a. Enter valid username (Use className)
//		 	b. Enter valid password (Use className)
//		 	c. click login button (Use className)

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.facebook.com/");

		driver.findElement(By.className("inputtext")).sendKeys("star@it.com");

		driver.findElement(By.cssSelector(".inputtext._55r1._6luy._9npi")).sendKeys("pass");

		driver.findElement(By.cssSelector("button[type='submit']")).click();

		Thread.sleep(5000);

		driver.close();
	}

}
