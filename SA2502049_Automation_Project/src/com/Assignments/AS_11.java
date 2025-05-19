package com.Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.TestBase.BaseFunction;

public class AS_11 extends BaseFunction {

	public static void main(String[] args) throws InterruptedException {
//		Open https://echoecho.com/htmlforms10.htm
//			a.	Display the status of every radio button (Enabled, visible, selected)
//			b.	Click on every radio button
//			c.	Display the status

		String url = "https://echoecho.com/htmlforms10.htm";
		launchBrowser("Chrome");
		launchURL(url);
		List<WebElement> radioButtons = driver.findElements(By.xpath("//td[@class='table5']//input[@type='radio']"));

		for (WebElement ele : radioButtons) {
			Thread.sleep(2000);
			System.out.println("Before Clicking on checkbox " + ele.getAttribute("value"));
			System.out.println("Checking Visibility of checkbox " + ele.isDisplayed());
			System.out.println("Checking default state of checkbox " + ele.isSelected());
			System.out.println("Checking enability of checkbox " + ele.isEnabled());

			if (!ele.isSelected()) {
				ele.click();

				System.out.println("After Clicking on checkbox " + ele.getAttribute("value"));
				System.out.println("Checking Visibility of checkbox " + ele.isDisplayed());
				System.out.println("Checking default state of checkbox " + ele.isSelected());
				System.out.println("Checking enability of checkbox " + ele.isEnabled());
			} else {
				System.out.println("Already Selcted: " + ele.getAttribute("value"));

			}

		}

		driver.close();

	}

}
