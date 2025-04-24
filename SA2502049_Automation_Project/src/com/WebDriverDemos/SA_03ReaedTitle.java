package com.WebDriverDemos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SA_03ReaedTitle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		String pageTitle = driver.getTitle();
		System.out.println("Page Title:" + " " + pageTitle);
		System.out.println("Page Url:" + " " + driver.getCurrentUrl());

		if (pageTitle.equals("Google"))
//			if (pageTitle.equals("fb"))

			System.out.println("Passed title printed");
		else
			System.out.println("Failed");

		driver.close();

	}

}
