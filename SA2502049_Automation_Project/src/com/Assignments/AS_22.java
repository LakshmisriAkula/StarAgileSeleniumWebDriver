package com.Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.TestBase.BaseFunction;

public class AS_22 extends BaseFunction {
//	22.	Open https://demoqa.com/automation-practice-form
//		a.	Enter or select your birth date
	@Test
	public void birthDate() {
		launchBrowser("Chrome");
		launchURL("https://demoqa.com/automation-practice-form");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		
        
		WebElement dobInput = driver.findElement((By.id("dateOfBirthInput")));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dobInput);


		dobInput.click();

		Select month = new Select(driver.findElement(By.className("react-datepicker__month-select")));
		month.selectByVisibleText("July");

		Select date = new Select(driver.findElement(By.className("react-datepicker__year-select")));
		date.selectByValue("1994");

		driver.findElement(By.cssSelector("div[aria-label='Choose Sunday, July 3rd, 1994']")).click();

		System.out.println("Selected date " + dobInput.getDomAttribute("value"));
		
		driver.close();

	}

}
