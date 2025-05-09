package com.HandlingAlert;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.TestBase.BaseFunction;

public class SA_26HandlingPromptAlert extends BaseFunction {

	public static void main(String[] args) {
		Alert alt;
		launchBrowser("Chrome");
		launchURL("https://demoqa.com/alerts");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.findElement(By.id("promtButton")).click();
		alt = driver.switchTo().alert();

		alt.sendKeys("Nitin John"); // will enter data
		alt.accept(); // accpet the alert

		String alertMessage = driver.findElement(By.id("promptResult")).getText();
		System.out.println(" alert message " + alertMessage);

		driver.findElement(By.id("confirmButton")).click();

		alt = driver.switchTo().alert();

		alt.accept();

		if (driver.findElement(By.id("confirmResult")).isDisplayed()) {

			System.out.println(driver.findElement(By.id("confirmResult")).getText());
		}

		else {

			System.out.println("You selected Ok");
		}

		driver.findElement(By.id("confirmButton")).click();

		alt = driver.switchTo().alert();

		alt.dismiss();

		if (driver.findElement(By.id("confirmResult")).isDisplayed()) {

			System.out.println(driver.findElement(By.id("confirmResult")).getText());
		}

		else {

			System.out.println("You selected Cancel");
		}

		driver.close();

	}

}
