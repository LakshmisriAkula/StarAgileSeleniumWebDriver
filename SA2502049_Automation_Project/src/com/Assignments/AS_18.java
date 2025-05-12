package com.Assignments;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.TestBase.BaseFunction;

public class AS_18 extends BaseFunction {

	public static void main(String[] args) {
//		17.	Open a webpage that has a link to open a new tab or window (e.g., https://demoqa.com/browser-windows).
//			Click the Alert,Frame & Windows
//			Click on Browser Window
//			Write an automation scripts to handle window on 
//				1. New Tab  - get and print message from tab
//				2. New Window - get and print message from window
//				3. New Window Message.	- get and print message from window

		launchBrowser("Chrome");
		launchURL("https://demoqa.com/browser-windows");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

		driver.findElement(By.xpath("(//li[@id='item-0'])[3]")).click();

		String parentWindow = driver.getWindowHandle();

		// ===== 1. Handle New Tab =====
		driver.findElement(By.id("tabButton")).click();

		Set<String> handlesAfterTab = driver.getWindowHandles();

		for (String handle : handlesAfterTab) {
			if (!handle.equals(parentWindow)) {
				driver.switchTo().window(handle);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sampleHeading")));
				System.out.println("New Tab Text: " + driver.findElement(By.id("sampleHeading")).getText());
				driver.close();
			}
		}

		driver.switchTo().window(parentWindow);

		// ===== 2. Handle New Window =====

		WebElement windowBtn = driver.findElement(By.id("windowButton"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", windowBtn);
		windowBtn.click();

		Set<String> handlesAfterWindow = driver.getWindowHandles();

		for (String handle : handlesAfterWindow) {
			if (!handle.equals(parentWindow)) {
				driver.switchTo().window(handle);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sampleHeading")));
				System.out.println("New Window Text: " + driver.findElement(By.id("sampleHeading")).getText());
				driver.close();
			}
		}

		driver.switchTo().window(parentWindow);

		// ===== 3. Handle New Window Message =====

		WebElement msgWindowBtn = driver.findElement(By.id("messageWindowButton"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", msgWindowBtn);
		msgWindowBtn.click();
		Set<String> handlesAfterMsgWindow = driver.getWindowHandles();

		for (String handle : handlesAfterMsgWindow) {
			if (!handle.equals(parentWindow)) {
				driver.switchTo().window(handle);
				try {
					Thread.sleep(2000); // Give time for content to render
					String message = "";
					try {
						message = driver.findElement(By.tagName("body")).getText();
						System.out.println("New Window Message: " + message);
					} catch (Exception e) {
						System.out.println("Unable to retrieve message from new window (likely non-HTML content).");
					}
				} catch (InterruptedException ie) {
					System.out.println("Interrupted while waiting.");
				} finally {
					driver.close(); // Ensure window is closed
				}
			}
		}

		driver.switchTo().window(parentWindow);

		driver.close();

	}

}
