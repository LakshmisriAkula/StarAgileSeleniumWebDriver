package com.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AS_01 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

//		1.Open https://www.echotrak.com/Login.aspx?ReturnUrl=%2f 
//		     a. Enter username as yourname (using locator name)
//		     b. Enter password as yourname_123 (using locator name)
//		     c. click on login button (using locator name) 

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.echotrak.com/Login.aspx?ReturnUrl=%2f");

		driver.findElement(By.name("txtCustomerID")).sendKeys("star@it.com");

		driver.findElement(By.name("txtPassword")).sendKeys("pass");

		driver.findElement(By.name("Butsub")).click();

		Thread.sleep(2000);

		driver.close();
	}

}
