package com.ActionEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.TestBase.BaseFunction;

public class SA_31HandlingDragNDrop extends BaseFunction {

	public static void main(String[] args) throws InterruptedException {
		launchBrowser("Chrome");
		launchURL("https://jqueryui.com/droppable/");
		Actions a = new Actions(driver);
		// control is on selenium main page
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		// control shift to iframe
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));

		a.dragAndDrop(drag, drop).build().perform();

		// driver.switchTo().parentFrame(); // move selenium control out from iframe.
		driver.close();

	}

}
