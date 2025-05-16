package com.Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.TestBase.BaseFunction;

public class AS_26 extends BaseFunction {
//	26. Open https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
//		a. Login with Admin 
//		b. Click on PIM
//		c. Click on + Add button
//		d. Enter First Name 
//		e. Enter Middle Name
//		f. Enter Last Name
//		g. Click on Create Login Details
//		h. Enter User Name
//		i. Enter Password
//		j. Enter Confirm Password
//		k. Click on Save Button
//		l. Logout
//
//		m. Login using data provided in step no h & i
//		n. Display name of employee on logout link
//		o. Click on My Info
//		p. Display the Employee ID
//		q. Logout

		String empUsername = "empuser" + System.currentTimeMillis();
	    String empPassword = "Emp@12345";

	@Test(priority = 1)
	public void addEmployeeAsAdmin() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// a. Login with Admin
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		Thread.sleep(2000);
		// b. Click on PIM
		driver.findElement(By.xpath("//span[text()='PIM']")).click();

		// c. Click on + Add button
		driver.findElement(By.xpath("//button[text()=' Add ']")).click();

		// d-f. Enter First, Middle, Last Name
		driver.findElement(By.name("firstName")).sendKeys("John");
		driver.findElement(By.name("middleName")).sendKeys("M");
		driver.findElement(By.name("lastName")).sendKeys("Doe");

		Thread.sleep(1500);
		// g. Click on Create Login Details
		driver.findElement(By.xpath("//span[text()='Create Login Details']")).click();

		// h-j. Enter Username, Password, Confirm Password
		driver.findElement(By.xpath("//label[text()='Username']/../following-sibling::div/input"))
				.sendKeys(empUsername);
		driver.findElement(By.xpath("//label[text()='Password']/../following-sibling::div/input"))
				.sendKeys(empPassword);
		driver.findElement(By.xpath("//label[text()='Confirm Password']/../following-sibling::div/input"))
				.sendKeys(empPassword);

		// k. Click on Save
		driver.findElement(By.xpath("//button[text()=' Save ']")).click();
		Thread.sleep(3000); // wait for redirection

		// l. Logout
		driver.findElement(By.className("oxd-userdropdown-tab")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
	}

	@Test(priority = 2)
	public void loginWithNewEmployee() throws InterruptedException {
		// m. Login using newly created credentials
		driver.findElement(By.name("username")).sendKeys(empUsername);
		driver.findElement(By.name("password")).sendKeys(empPassword);
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		// n. Display name on logout link
		String employeeName = driver.findElement(By.className("oxd-userdropdown-name")).getText();
		System.out.println("Logged-in Employee Name: " + employeeName);

		// o. Click on My Info
		driver.findElement(By.xpath("//span[text()='My Info']")).click();

		// p. Display Employee ID
		Thread.sleep(2000);
		WebElement empIdField = driver
				.findElement(By.xpath("//label[text()='Employee Id']/../following-sibling::div/input"));
		System.out.println("Employee ID: " + empIdField.getAttribute("value"));

		// q. Logout
		driver.findElement(By.className("oxd-userdropdown-tab")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
	}

	@BeforeClass
	public void setup() throws InterruptedException {
		launchBrowser("Chrome");
		launchURL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}
}