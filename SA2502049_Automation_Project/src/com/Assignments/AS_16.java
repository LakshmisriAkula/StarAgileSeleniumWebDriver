package com.Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.TestBase.BaseFunction;

public class AS_16 extends BaseFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		 navigate to https://www.cricbuzz.com/live-cricket-scorecard/115345/kkr-vs-csk-57th-match-indian-premier-league-2025
//				and print complete web table data(scoreboard) in to console.

		launchBrowser("Chrome");
		launchURL(
				"https://www.cricbuzz.com/live-cricket-scorecard/115345/kkr-vs-csk-57th-match-indian-premier-league-2025");

		System.out.println("No. of rows: " + driver.findElements(By.xpath("//*[@id=\"innings_1\"]/div[1]/div")).size());

		System.out.println(
				"No. of columns: " + driver.findElements(By.xpath("//*[@id=\"innings_1\"]/div[1]/div[3]/div")).size());

		List<WebElement> rowData = driver.findElements(By.xpath("//*[@id=\"innings_1\"]/div[1]/div"));

		for (WebElement row : rowData) {
			List<WebElement> columns = row.findElements(By.xpath("./div"));
			for (WebElement cell : columns) {
				System.out.print(cell.getText() + "\t");
			}
			System.out.println(); // Move to next line after each row
		}

		driver.close();
	}
}