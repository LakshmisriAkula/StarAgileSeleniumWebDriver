package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SA_04Locators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		WebElement userName = driver.findElement(By.name("email"));
		userName.sendKeys("lakshmisri@gmail.com");
		WebElement password = driver.findElement(By.name("pass"));
		password.sendKeys("lakshmisri");
		driver.findElement(By.name("login")).click();
//		driver.close();
	}

}
