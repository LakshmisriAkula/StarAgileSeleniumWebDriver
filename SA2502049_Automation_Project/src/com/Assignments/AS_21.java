package com.Assignments;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TestBase.BaseFunction;

public class AS_21 extends BaseFunction{
//	21.	Assignment for TestNG
//	a.	Launch Browser
//	b.	Open https://www.amazon.in/
//	c.	Print the title
//	d.	Click on Sell link
//	e.	Print the title
//	f.	Open https://www.amazon.in/
//	g.	Print the title
//	h.	Click on Best Sellers link
//	i.	Print the title
//	j.	Open https://www.amazon.in/
//	k.	Print the title
//	l.	Click on Mobiles link
//	m.	Print the title
//	n.	Open https://www.amazon.in/
//	o.	Print the title
//	p.	Click on Best Electronics link
//	q.	Print the title
//	r.	Close the browser
	
	@Test(dataProvider="sendData")
	public void Amazon(String menu) throws InterruptedException {
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText(menu)).click();
		Thread.sleep(1500);
		System.out.println(driver.getTitle());

		
	}
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		System.out.println("BeforeMethod");
		launchBrowser("Chrome");
		launchURL("https://www.amazon.in/");
		Thread.sleep(3000);

	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {

		System.out.println("AfterMethod");
		driver.close();
}
	
	@DataProvider
	public Object[][] sendData() {

		Object[][] data = new Object[4][1];

		// row 1
		data[0][0] = "Sell";

		// row 2
		data[1][0] = "Bestsellers";
		
		data[2][0] = "Mobiles";
		
		data[3][0] = "Electronics";



		return data;

	}

}