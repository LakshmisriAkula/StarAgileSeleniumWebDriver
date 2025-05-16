package com.Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.TestBase.BaseFunction;

public class AS_23 extends BaseFunction {
//	23.	Open https://dash.bling-center.com/platform/signIn.html 
//		a.	Click on forgot password
//		b.	Enter email id
//		c.	Enter email id
//		d.	Click on Reset Password
//		e.	Display the messages (in green color)
	@Test
	public void forgetPwd() throws InterruptedException {
		launchBrowser("Chrome");
		launchURL("https://dash.bling-center.com/platform/signIn.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.findElement(By.xpath("//button[@class='forget-password-btn']/p")).click();
		driver.findElement(By.id("email1")).sendKeys("anju@it.com");
		driver.findElement(By.cssSelector(".reset-pwd.signIn-btn")).click();
		Thread.sleep(1000);
		WebElement success = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resetsuccess")));

		System.out.println("Reset Message: " + success.getText());
		driver.close();
	}

}
