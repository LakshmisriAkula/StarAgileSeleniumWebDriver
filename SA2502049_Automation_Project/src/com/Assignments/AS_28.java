package com.Assignments;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.TestBase.BaseFunction;

public class AS_28 extends BaseFunction {

//	Create an Excel file loginData.xlsx with columns: Username, Password.
//    Read each row using Apache POI.
//    Open the login page of a demo website (e.g., https://the-internet.herokuapp.com/login).
//    Perform login attempts using credentials from the Excel sheet.
//    Write the result (Success or Failure) back to a new column in the same Excel file. 

	File file;
	FileInputStream fis;
	FileOutputStream fos;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	int index = 0;

	@Test
	public void login() {

		int totalRowCount = sheet.getPhysicalNumberOfRows();
		int totalCellCount = sheet.getRow(0).getPhysicalNumberOfCells();

		row = sheet.getRow(0);

		row.createCell(2).setCellValue("Result");

		for (int i = 1; i < totalRowCount; i++) {

			row = sheet.getRow(i);

			String username = row.getCell(0).getStringCellValue();
			String password = row.getCell(1).getStringCellValue();

			launchBrowser("Chrome");
			launchURL("https://the-internet.herokuapp.com/login");
			driver.findElement(By.id("username")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.cssSelector("button.radius")).click();

			String result = driver.findElement(By.id("flash")).getText();

			cell = row.createCell(2);
			cell.setCellValue(result);

		}

	}

	@BeforeTest
	public void beforeTest() throws IOException {
		file = new File(
				"E:\\StarAgile Webdriver\\StarAgileSeleniumWebDriver\\SA2502049_Automation_Project\\src\\Excel\\loginData.xlsx");
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet("LoginData");

		fos = new FileOutputStream(file);
	}

	@AfterTest
	public void afterTest() throws IOException {
		wb.write(fos);
		wb.close();
		fis.close();
		driver.quit();
	}

}
