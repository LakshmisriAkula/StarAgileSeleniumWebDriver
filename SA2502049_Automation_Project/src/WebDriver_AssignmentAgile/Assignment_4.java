package WebDriver_AssignmentAgile;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_4 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://demoqa.com/automation-practice-form");

		driver.findElement(By.id("firstName")).sendKeys("Lakshmisri");

		driver.findElement(By.id("lastName")).sendKeys("Akula");

		driver.findElement(By.id("userEmail")).sendKeys("akulalakshmisri@gmail.com");

		WebElement genderRadio = driver.findElement(By.id("gender-radio-1"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", genderRadio);

		driver.findElement(By.id("userNumber")).sendKeys("9642285699");

		WebElement hobbiesCheckbox = driver.findElement(By.id("hobbies-checkbox-1"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", hobbiesCheckbox);

		driver.findElement(By.id("uploadPicture"))
				.sendKeys("C:\\Users\\Lakshmi Sri Akula\\Downloads\\Payslip_Template1_Latest.pdf");

		driver.findElement(By.id("currentAddress")).sendKeys("MVP");

		WebElement submit = driver.findElement(By.id("submit"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", submit);

		String result = driver.findElement(By.id("example-modal-sizes-title-lg")).getText();

		if (result.contains("Thanks for submitting the form")) {
			System.out.println("Form submitted successfully.");
		} else {
			System.out.println("Form not submitted due to validations.");
		}

	}

}
