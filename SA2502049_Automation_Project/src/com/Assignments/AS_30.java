package com.Assignments;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.TestBase.BaseFunction;

public class AS_30 extends BaseFunction {

//	30.Fill out a web form using data from Excel.
//	   1.Excel file formData.xlsx has columns: FirstName, LastName, Email, Message.
//	   2.Automate filling a form at https://demoqa.com/automation-practice-form using this data.
//	   3.Validate form submission and log the result (e.g., Submitted, Error) back to the Excel file.
	String filePath = "D:\\SA2502049_SeleniumWebdriver_Git\\StarAgileSeleniumWebDriver\\SA2502049_Automation_Project\\src\\Excel\\formatData.xlsx";

	File file;
	FileInputStream fis;
	FileOutputStream fos;

	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow rows;
	XSSFCell cell;

	@Test
	public void fillForm() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		int totalRows = sheet.getPhysicalNumberOfRows();
		rows = sheet.getRow(0);
		rows.createCell(3).setCellValue("Message");

		for (int i = 1; i < totalRows; i++) {

			rows = sheet.getRow(i);

			WebElement firstName = driver.findElement(By.id("firstName"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstName);

			firstName.sendKeys(rows.getCell(0).getStringCellValue());
			driver.findElement(By.id("lastName")).sendKeys(rows.getCell(1).getStringCellValue());
			driver.findElement(By.id("userEmail")).sendKeys(rows.getCell(2).getStringCellValue());
			WebElement genderRadio = driver.findElement(By.id("gender-radio-1"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", genderRadio);

			driver.findElement(By.id("userNumber")).sendKeys("9642285699");

			WebElement hobbiesCheckbox = driver.findElement(By.id("hobbies-checkbox-1"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", hobbiesCheckbox);

			driver.findElement(By.id("uploadPicture"))
					.sendKeys("C:\\Users\\srban\\Downloads\\Payslip_BaluS_Nov-2024 (1).pdf");

			driver.findElement(By.id("currentAddress")).sendKeys("MVP");

//			WebElement state = driver.findElement(By.xpath("//div[contains(text(),'Select State')]"));
//			((JavascriptExecutor) driver).executeScript("arguments[0].click();", state);
//			
//			driver.findElement(By.xpath("//div[contains(text(),'Andhra')]")).click();
//
//
//			driver.findElement(By.xpath("//div[contains(text(),'Select City')]")).sendKeys("Karnal", Keys.ENTER);

			WebElement submit = driver.findElement(By.id("submit"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", submit);

			String result = driver.findElement(By.id("example-modal-sizes-title-lg")).getText();

			rows.createCell(3).setCellValue(result);
			
			driver.navigate().refresh();

			Thread.sleep(1000);
		}

	}

	@BeforeTest
	public void beforeTest() throws IOException {

		launchBrowser("Chrome");
		launchURL("https://demoqa.com/automation-practice-form");

		file = new File(filePath);

		try {
			fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheet("Data");
			// wb.getSheetAt(0);

			fos = new FileOutputStream(file);

		} catch (FileNotFoundException e) { // checked | compilation

			e.getMessage();
		}

	}

	@AfterTest
	public void afterTest() throws IOException {
		wb.write(fos);
		wb.close();
		fis.close();

	}

}
