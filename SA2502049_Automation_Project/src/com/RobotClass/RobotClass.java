package com.RobotClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import com.TestBase.BaseFunction;

public class RobotClass extends BaseFunction {

	public static void main(String[] args) throws AWTException, InterruptedException {

		Robot rbt = new Robot();
		launchBrowser("Chrome");
		launchURL("https://sampleapp.tricentis.com/101/app.php");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Automobile")).click();

		driver.findElement(By.linkText("Enter Insurant Data")).click();

		driver.findElement(By.id("open")).click();
		Thread.sleep(2000);
		rbt.keyPress(KeyEvent.VK_TAB);

		rbt.keyPress(KeyEvent.VK_ENTER);

	}

}
