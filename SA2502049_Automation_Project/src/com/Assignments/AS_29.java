package com.Assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.TestBase.BaseFunction;

public class AS_29 extends BaseFunction {

//	29. Scrape data from a webpage and store it in an Excel file.
//    1.Visit a product listing site like https://automationexercise.com/products.
//    2.Extract the product name, price, and availability.
//    3.Write the scraped data into an Excel sheet products.xlsx with appropriate headers. 

	File file;
	FileOutputStream fos;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow rows;
	XSSFCell cell;

	@Test
	public void RetrievingAndWritingData() {

		rows = sheet.createRow(0);
		rows.createCell(0).setCellValue("ProductName");
		rows.createCell(1).setCellValue("Price");
		rows.createCell(2).setCellValue("Availability");

		List<WebElement> productElements = driver.findElements(By.xpath("//div[@class='productinfo text-center']"));
		
		int rowNum = 1;

		for (WebElement product : productElements) {
			String name = product.findElement(By.tagName("p")).getText();
			String value = product.findElement(By.tagName("h2")).getText();

			String price = value.replaceAll("[^0-9]", "");

			String availability = "Available";

			rows = sheet.createRow(rowNum++);
			rows.createCell(0).setCellValue(name);
			rows.createCell(1).setCellValue(price);
			rows.createCell(2).setCellValue(availability);

		}

	}

	@BeforeTest
	public void beforeTest() {

		launchBrowser("Chrome");
		launchURL("https://automationexercise.com/products");

		file = new File("AS_29.xlsx"); // create a file.
		try {
			fos = new FileOutputStream(file);
			wb = new XSSFWorkbook();
			// sheet = wb.createSheet(); this function create sheet by index
			sheet = wb.createSheet("ProductData");
		} catch (FileNotFoundException e) { // checked | compilation

			e.getMessage();
		}
	}

	@AfterTest
	public void afterTest() throws IOException {
		wb.write(fos);
		wb.close();
		fos.close();
	}

}
