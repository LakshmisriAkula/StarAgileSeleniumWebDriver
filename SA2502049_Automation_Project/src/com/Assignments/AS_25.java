package com.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.TestBase.BaseFunction;

public class AS_25 extends BaseFunction {
//	25. Open https://sampleapp.tricentis.com/101/index.php
//		a. Click on Automobile
//		b. Fill all the fields on this page
//		c. Click on Next Button
//		d. Fill all the fields on this page as well
//		e. Select the picture
//		f. If possible fill the next form as well

	@Test
	public void birthDate() {
		launchBrowser("Chrome");
		launchURL("https://sampleapp.tricentis.com/101/index.php");
		driver.findElement(By.xpath("(//div[@class='main-navigation'])[1]/ul/li[1]")).click();
		Select makeOption = new Select(driver.findElement(By.id("make")));
		makeOption.selectByValue("Honda");

		driver.findElement(By.id("engineperformance")).sendKeys("50");

		driver.findElement(By.id("dateofmanufacture")).sendKeys("03/05/1998");

		Select nunmberOfSeats = new Select(driver.findElement(By.id("numberofseats")));
		nunmberOfSeats.selectByValue("5");

		Select fuelType = new Select(driver.findElement(By.id("fuel")));
		fuelType.selectByValue("Diesel");

		driver.findElement(By.id("listprice")).sendKeys("50");

		driver.findElement(By.id("licenseplatenumber")).sendKeys("5");

		driver.findElement(By.id("annualmileage")).sendKeys("5000");

		driver.findElement(By.id("nextenterinsurantdata")).click();

		// d. Fill all fields - Insurant Data
		driver.findElement(By.id("firstname")).sendKeys("John");
		driver.findElement(By.id("lastname")).sendKeys("Doe");
		driver.findElement(By.id("birthdate")).sendKeys("01/01/1990");
		driver.findElement(By.id("gendermale")).click();
		driver.findElement(By.id("streetaddress")).sendKeys("123 Main St");

		Select country = new Select(driver.findElement(By.id("country")));
		country.selectByVisibleText("India");

		driver.findElement(By.id("zipcode")).sendKeys("560001");
		driver.findElement(By.id("city")).sendKeys("Bangalore");

		Select occupation = new Select(driver.findElement(By.id("occupation")));
		occupation.selectByVisibleText("Employee");

		driver.findElement(By.cssSelector("input[id='speeding']")).click();

		// e. Upload picture
		WebElement fileUpload = driver.findElement(By.id("open"));
		fileUpload.sendKeys("C:\\Path\\To\\Image\\sample.jpg"); // Change to your local image path

		// f. Go to next form (Product Data)
		driver.findElement(By.id("nextenterproductdata")).click();

		// Optional: Add code here to fill Product Data
		System.out.println("Filled Vehicle & Insurant forms successfully.");

		driver.close();
	}
}
