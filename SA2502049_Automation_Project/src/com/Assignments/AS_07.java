package com.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AS_07 {

	public static void main(String[] args) {
//		7.	Open https://www.google.com
//			a.	Enter sachin tendulkar in search box using Xpath
//			b.	Hit Enter
//			c.	Verify the title (Title should contain sachin

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.google.com");

		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("sachin tendulkar", Keys.ENTER);

		String title = driver.getTitle();

		if (title.contains("sachin"))
			System.out.println(title);
		else
			System.out.println(driver.getTitle());

		driver.close();

	}

}
