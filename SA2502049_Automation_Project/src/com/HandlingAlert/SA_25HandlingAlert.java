package com.HandlingAlert;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.TestBase.BaseFunction;

public class SA_25HandlingAlert extends BaseFunction {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		Alert alt;
		launchBrowser("Chrome");
		launchURL("https://demoqa.com/alerts");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.findElement(By.id("alertButton")).click();

		Thread.sleep(500);

		alt = driver.switchTo().alert();

		alt.accept();

		driver.switchTo().defaultContent();

		driver.findElement(By.id("timerAlertButton")).click();

		wait.until(ExpectedConditions.alertIsPresent());

		alt = driver.switchTo().alert();

		System.out.println(alt.getText());

		alt.accept();

		driver.close();

	}

}
