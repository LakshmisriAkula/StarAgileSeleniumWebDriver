package WebDriver_AssignmentAgile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_1 {

//	1. Write a WebDriver script to navigate to a website and click on a specific link.

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.google.com/");

		driver.findElement(By.linkText("About")).click();

		driver.close();

	}

}
