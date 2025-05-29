package WebDriver_AssignmentAgile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageTest {

//	2. Implement a Page Object Model for a login page using WebDriver.

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://staragile.melimu.com/login/index.php?id=1&code=Star%20Agile");

		LoginPage login = new LoginPage(driver);

		login.enterUserName("akulalakshmisri@gmail.com");
		login.enterPassword("test@123");
		login.clickLoginButton();

		driver.close();

	}

}
