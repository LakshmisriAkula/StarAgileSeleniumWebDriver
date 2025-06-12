package com.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.TestBase.BaseFunction;

public class AS_24 extends BaseFunction {

//	24.	Open https://register.rediff.com/register/register.php?FormName=user_details 
//		a.	Select your birth date
//		b.	Display the birth date as 
//		e.g. My Birth Date is 01 JAN 2000
	@Test
	public void birthDate() {
		launchBrowser("Chrome");
		launchURL("https://register.rediff.com/register/register.php?FormName=user_details");
		Select dobDay = new Select(driver.findElement(By.className("day")));
		dobDay.selectByValue("03");

		dobDay.getFirstSelectedOption();

		Select dobMonth = new Select(driver.findElement(By.className("middle")));
		dobMonth.selectByContainsVisibleText("JUL");

		Select dobYear = new Select(driver.findElement(By.className("year")));
		dobYear.selectByContainsVisibleText("1994");

		System.out.println("My Birth Date is " + dobDay.getFirstSelectedOption().getText() + " "
				+ dobMonth.getFirstSelectedOption().getText() + " " + dobYear.getFirstSelectedOption().getText());

		driver.close();
	}

}
