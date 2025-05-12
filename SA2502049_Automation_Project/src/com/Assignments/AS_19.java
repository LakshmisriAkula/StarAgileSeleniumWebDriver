package com.Assignments;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.TestBase.BaseFunction;

public class AS_19 extends BaseFunction {

	public static void main(String[] args) {
//		18 navigate to https://omayo.blogspot.com/ and automate all alert related scenario.

		launchBrowser("Chrome");
		launchURL("https://omayo.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		Alert alt;
		driver.findElement(By.id("alert1")).click();

		alt = driver.switchTo().alert();

		alt.accept();

		driver.findElement(By.id("prompt")).click();

		alt = driver.switchTo().alert();

		alt.sendKeys("Lakshmisri");

		alt.accept();

		driver.findElement(By.id("confirm")).click();

		alt = driver.switchTo().alert();

		alt.accept();

		driver.findElement(By.id("confirm")).click();

		alt = driver.switchTo().alert();

		alt.dismiss();
		
		driver.close();

	}

}
