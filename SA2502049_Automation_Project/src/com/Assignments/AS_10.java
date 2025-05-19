package com.Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.TestBase.BaseFunction;

public class AS_10 extends BaseFunction {

	public static void main(String[] args) {
//		10. Open https://omayo.blogspot.com/
//		     a.	Display the status of Pen, Book and Laptop, Bag checkboxes (Enabled, visible, selected)
//			 b.	Select the check box that is not selected
//		     c.	Display the status of Pen, Book and Laptop, Bag checkboxes 

		String url = "https://omayo.blogspot.com/";
		launchBrowser("Chrome");
		launchURL(url);

		List<WebElement> chkbox = driver.findElements(By.cssSelector("[name='accessories']"));

		for (WebElement stationary : chkbox) {
			System.out.println("Before Clicking on checkbox " + stationary.getAttribute("value"));
			System.out.println("Checking Visibility of checkbox " + stationary.isDisplayed());
			System.out.println("Checking default state of checkbox " + stationary.isSelected());
			System.out.println("Checking enability of checkbox " + stationary.isEnabled());

			if (!stationary.isSelected()) {
				stationary.click();

				System.out.println("After Clicking on checkbox " + stationary.getAttribute("value"));
				System.out.println("Checking Visibility of checkbox " + stationary.isDisplayed());
				System.out.println("Checking default state of checkbox " + stationary.isSelected());
				System.out.println("Checking enability of checkbox " + stationary.isEnabled());
			}
			else {
			System.out.println("Already Selcted: " + stationary.getAttribute("value"));
			
			}

		}

		driver.close();

	}

}
