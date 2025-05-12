package com.Assignments;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.TestBase.BaseFunction;

public class AS_20 extends BaseFunction {

	public static void main(String[] args) {
//		19. Navigate to https://omayo.blogspot.com/		
//		    a. Click on Selenium Tutorial link.
//		    b. get the title
//		    c. Click on  check our youtube channel.
//		    d. get validate youtube window title.

		launchBrowser("Chrome");
		launchURL("https://omayo.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		String parentWindow = driver.getWindowHandle();

		// a. Click on Selenium Tutorial link
		driver.findElement(By.linkText("SeleniumTutorial")).click();

		Set<String> allWindows = driver.getWindowHandles();
		String seleniumWindow = "";
		for (String window : allWindows) {
			if (!window.equals(parentWindow)) {
				seleniumWindow = window;
				driver.switchTo().window(window);
				break;
			}
		}

		System.out.println("Selenium Tutorial Title: " + driver.getTitle());

		// c. Click "check our youtube channel"
		driver.findElement(By.xpath("//div[@id='HTML4']//table/tbody/tr/td[2]/a")).click();

		// d. Wait until 3 windows are opened
		new WebDriverWait(driver, Duration.ofSeconds(20))
				.until((ExpectedCondition<Boolean>) d -> d.getWindowHandles().size() == 3);

		// Get YouTube window
		Set<String> updatedWindows = driver.getWindowHandles();
		for (String win : updatedWindows) {
			if (!win.equals(parentWindow) && !win.equals(seleniumWindow)) {
				driver.switchTo().window(win);
				break;
			}
		}

		// Optional wait to let YouTube load title
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(d -> !d.getTitle().isEmpty());

		String youtubeTitle = driver.getTitle();
		if (youtubeTitle.toLowerCase().contains("youtube")) {
			System.out.println("YouTube Window Title: " + youtubeTitle);
		} else {
			System.out.println("YouTube title not found. Actual title: " + youtubeTitle);
		}

		driver.close();

	}

}
