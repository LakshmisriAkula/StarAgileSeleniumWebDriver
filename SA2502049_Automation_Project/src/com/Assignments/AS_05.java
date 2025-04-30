package com.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AS_05 {

	public static void main(String[] args) throws InterruptedException {
//		 5.	Open https://www.facebook.com/
//				Enter valid user name as test@gmail.com  (Use xpath)
//				Enter invalid password (Use xpath)
//				Click on Login button (Use xpath)
//				Display the error message 

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.facebook.com/");

		driver.findElement(
				By.xpath("html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[1]/div/input"))
				.sendKeys("test@gmail.com");

		driver.findElement(
				By.xpath("html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[1]/div[2]/div/input"))
				.sendKeys("1234");

		driver.findElement(By.xpath("html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[2]/button"))
				.click();

		Thread.sleep(5000);

		String errMsg = driver.findElement(By.className("_9ay7")).getText();

		if (errMsg.contains("The password that you've entered is incorrect."))

			System.out.println(errMsg);

		else

			System.out.println("No validation found");
		
		driver.close();

	}

}
