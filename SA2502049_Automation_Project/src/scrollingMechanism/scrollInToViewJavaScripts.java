package scrollingMechanism;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.TestBase.BaseFunction;

public class scrollInToViewJavaScripts extends BaseFunction {

	public static void main(String[] args) {
		launchBrowser("Chrome");
		launchURL("https://automationexercise.com/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement subs_Email = driver.findElement(By.id("susbscribe_email"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", subs_Email);
		subs_Email.sendKeys("nithin@gmail.com");
		driver.close();
	}

}
