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

public class AS_31 extends BaseFunction {
//	
//	31. Write WebTable Data into excel file 
//    1. Use a page like https://www.techlistic.com/p/demo-selenium-practice.html.
//    2. Read web table data and write into excel.

	File file;
	FileOutputStream fos;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow rows;
	XSSFCell cell;

	@Test
	public void WebDataIntoExcel() throws InterruptedException {

		List<WebElement> rowSize = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));

		for (int i = 0; i < rowSize.size(); i++) {

			rows = sheet.createRow(i);
			List<WebElement> columnData = rowSize.get(i).findElements(By.xpath("th|td"));

			for (int j = 0; j < columnData.size(); j++) {

				rows.createCell(j).setCellValue(columnData.get(j).getText());

			}

		}

	}

	@BeforeTest
	public void beforeTest() throws IOException {

		launchBrowser("Chrome");
		launchURL("https://www.techlistic.com/p/demo-selenium-practice.html");

		file = new File("WebTableDataIntoExcel.xlsx");

		try {
			fos = new FileOutputStream(file);
			wb = new XSSFWorkbook();
			sheet = wb.createSheet("Data");
			// wb.getSheetAt(0);

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
