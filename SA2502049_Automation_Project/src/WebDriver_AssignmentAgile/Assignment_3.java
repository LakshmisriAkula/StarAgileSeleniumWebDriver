package WebDriver_AssignmentAgile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment_3 {

//	3. Write a WebDriver script to handle a dropdown and select an option based on specific criteria.

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");

		WebElement country = driver.findElement(By.id("country"));

		Select dropdown = new Select(country);

		dropdown.selectByVisibleText("Antigua And Barbuda");

		driver.close();
	}

}
