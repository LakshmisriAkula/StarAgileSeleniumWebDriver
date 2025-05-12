package com.Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.TestBase.BaseFunction;

public class AS_17 extends BaseFunction {

	public static void main(String[] args) {
//		16.Open https://www.rediff.com/ 
//			a.	Click on Money
//			b.	Click on More Gainers
//			c.	Display title of all the headers
//			d.	Display total no of rows
//			e.	Display any row randomly
//			f.	Display list of all the companies (Company name only)
//			g.	Read all current price and display the highest price.
//				(Read all the current price, store in array and then sort an array so you will get highest price)

		launchBrowser("Chrome");
		launchURL("https://www.rediff.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.linkText("Money")).click();

		driver.findElement(By.linkText("Gainers")).click();

		List<WebElement> headers = driver.findElements(By.xpath("//table[@class='dataTable']/thead/tr/th"));

		for (WebElement headerName : headers) {

			System.out.println("title of all the headers : " + headerName.getText());
		}

		System.out.println(
				"total no of rows: " + driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr")).size());

		List<WebElement> rowData = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[3]/td"));

		for (WebElement data : rowData) {

			System.out.println(" any row randomly " + data.getText());
		}

		List<WebElement> companyNamesList = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]"));

		for (WebElement compName : companyNamesList) {

			System.out.println(" list of all the companies " + compName.getText());
		}

		List<WebElement> currentPrices = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[4]"));

		List<Double> prices = new ArrayList();

		for (WebElement priceValue : currentPrices) {

			String priceText = priceValue.getText().replace(",", "").trim();

			if (!priceText.isEmpty()) {
				try {
					double price = Double.parseDouble(priceText);
					prices.add(price);
				} catch (NumberFormatException e) {
					System.out.println("Invalid price format: " + priceText);
				}
			}
		}

		// Sort in descending order

		Collections.sort(prices, Collections.reverseOrder());

		// Print the sorted list
		System.out.println("Sorted Prices (High to Low):");

		for (double price : prices) {
			System.out.println(price);
		}

		// Highest price
		if (!prices.isEmpty()) {
			System.out.println("Highest Price: " + prices.get(0));
		}

		driver.close();
	}

}
