package stepsDefinition;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//Cucumber anotations
//try to build one scenario by using hooks (after and before)
//	1. navigate to https://automationexercise.com/
//	2. pick testcase no. 6
//	1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//3. Verify that home page is visible successfully
//4. Click on 'Contact Us' button
//5. Verify 'GET IN TOUCH' is visible
//6. Enter name, email, subject and message
//7. Upload file
//8. Click 'Submit' button
//9. Click OK button
//10. Verify success message 'Success! Your details have been submitted successfully.' is visible
//11. Click 'Home' button and verify that landed to home page successfully
	

public class Assignment {
	
	WebDriver driver;
	
	@Before
	public void setUp() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}

	@After
	public void tearDown() {
		driver.close();
		
	}
	@Given("I launch the browser and navigate to {string}")
	public void i_launch_the_browser_and_navigate_to(String url) {
	    driver.get(url);
	}

	@Then("I should see the home page successfully")
	public void i_should_see_the_home_page_successfully() {
	     Assert.assertTrue(driver.getTitle().contains("Automation Exercise"));
	}

	@When("I click on the Contact Us button")
	public void i_click_on_the_button() {
	     driver.findElement(By.xpath("//a[normalize-space()='Contact us']")).click();
	}

	@Then("I should see {string}")
	public void i_should_see(String text) {
		String resultText = driver.findElement(By.xpath("//div[@class='contact-form']/h2")).getText();
	     Assert.assertEquals(text,resultText);
	}

	@When("I enter name {string}, email {string}, subject {string} and message {string}")
	public void i_enter_name_email_subject_and_message(String name, String email, String subject, String message) {
		driver.findElement(By.name("name")).sendKeys(name);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("subject")).sendKeys(subject);
        driver.findElement(By.name("message")).sendKeys(message);
	}

	@When("I upload file {string}")
	public void i_upload_file(String filePath) {
        driver.findElement(By.name("upload_file")).sendKeys(filePath);

	}

	@When("I click the Submit button and accept the alert")
	public void i_click_the_button_and_accept_the_alert() throws InterruptedException {
		  driver.findElement(By.xpath("//input[@name='submit']")).click();
		  Thread.sleep(3000);
	        driver.switchTo().alert().accept();
	}

	@Then("I should see the success message {string}")
	public void i_should_see_the_success_message(String successMessage) {
        assertTrue(driver.getPageSource().contains(successMessage));

	}

	@When("I click the Home button")
	public void i_click_the_button() {
	     driver.findElement(By.xpath("//a[normalize-space()='Home']")).click();
	}

	@Then("I should be navigated to the home page successfully")
	public void i_should_be_navigated_to_the_home_page_successfully() {
        assertTrue(driver.getTitle().contains("Automation Exercise"));

	}

	

	
}
