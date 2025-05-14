package com.ActionEvents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.TestBase.BaseFunction;

public class SA30_HandlingMouseHover extends BaseFunction {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		launchBrowser("Chrome");
		launchURL("https://www.istqb.in/");
		Actions a = new Actions(driver);

//		a.moveToElement(driver.findElement(By.linkText("SPECIALIST"))).build().perform();

		List<WebElement> istqbNavigationLinks = driver.findElements(By.xpath("//nav[@role='navigation']/ul/li"));

		System.out.println("Total No. if links " + istqbNavigationLinks.size());
		for (WebElement menuItem : istqbNavigationLinks) {
			System.out.println(menuItem.getText());
			a.moveToElement(menuItem).build().perform();
			Thread.sleep(1000);
		}

		driver.close();

	}

}
