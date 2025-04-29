package com.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AS_02 {

	public static void main(String[] args) throws InterruptedException {

//		2.Open https://www.echotrak.com/Login.aspx?ReturnUrl=%2f 
//		     a. Enter username as yourname (using locator id)
//		     b. Enter password as yourname_123 (using locator id)
//		     c. click on login button (using locator id)
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.echotrak.com/Login.aspx?ReturnUrl=%2f");

		driver.findElement(By.id("txtCustomerID")).sendKeys("star@it.com");

		driver.findElement(By.id("txtPassword")).sendKeys("pass");

		driver.findElement(By.id("Butsub")).click();

		Thread.sleep(1000);

		driver.close();
	}

}
