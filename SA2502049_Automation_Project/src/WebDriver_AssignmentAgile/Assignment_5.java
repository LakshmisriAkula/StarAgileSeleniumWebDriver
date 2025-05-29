package WebDriver_AssignmentAgile;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Assignment_5 {

//	5. Write a WebDriver script to capture a screenshot of a webpage and save it to a specific location

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://staragile.melimu.com/login/index.php");
		try {
			File sourceFileLocation = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			FileHandler.copy(sourceFileLocation, new File("screenshot.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.close();

	}

}
