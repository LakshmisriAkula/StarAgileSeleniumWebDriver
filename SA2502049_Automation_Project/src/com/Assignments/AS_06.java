package com.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AS_06 {

	public static void main(String[] args) throws InterruptedException {
//		Open https://www.echotrak.com/Login.aspx?ReturnUrl=%2f 
//			a.	Enter username as your name (using locator xpath)
//			b.	Enter password as yourname_123 (using locator xpath)
//			c.	Click on login button. (using locator xpath)
//			d.	Display the error message 

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.echotrak.com/Login.aspx?ReturnUrl=%2f");

		driver.findElement(By.xpath("//input[@id='txtCustomerID']")).sendKeys("Lakshmisri");

		driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("123");

		driver.findElement(By.xpath("//*[@class='btn btn-lg btn-block btn-primary']")).click();

		Thread.sleep(5000);

		String errMsg = driver.findElement(By.xpath("//span[@id='lblMsg']")).getText();

		if (errMsg.contains("Invalid Username/Password"))

			System.out.println(errMsg);

		else

			System.out.println("No validation found");

		driver.close();
	}

}
