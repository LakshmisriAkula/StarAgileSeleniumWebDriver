package com.Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.TestBase.BaseFunction;

public class AS_09 extends BaseFunction {

	public static void main(String[] args) {
//		9. Open https://www.chabadpotomac.com/templates/articlecco_cdo/aid/6617538/jewish/Hebrew-School-New-Student.htm
//			   a. automation radio button  	- Hebrew Reading Proficiency		

		String url = "https://www.chabadpotomac.com/templates/articlecco_cdo/aid/6617538/jewish/Hebrew-School-New-Student.htm";
		launchBrowser("Chrome");
		launchURL(url);

		List<WebElement> allRadioButtons = driver.findElements(By.cssSelector("[id^='input_25']"));

		for (WebElement radio : allRadioButtons) {

			if (!radio.isSelected()) {

				radio.click();

				if (radio.isSelected()) {

					String buttonName = radio.getAttribute("value");

					System.out.println(buttonName);
				}

			}
		}

		driver.close();
	}

}
