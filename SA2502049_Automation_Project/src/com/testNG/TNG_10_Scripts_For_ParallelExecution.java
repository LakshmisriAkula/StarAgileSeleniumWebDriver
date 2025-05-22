package com.testNG;

import org.testng.annotations.Test;

import com.TestBase.BaseFunction;

public class TNG_10_Scripts_For_ParallelExecution extends BaseFunction {
	@Test(priority = 1)
	public void openAmazon() throws InterruptedException {
		launchBrowser("Chrome");
		launchURL("https://www.amazon.in/");
		Thread.sleep(1500);
	}

	@Test(priority = 2)
	public void OpenFaceBook() throws InterruptedException {
		launchBrowser("Chrome");
		launchURL("https://www.facebook.com/");
		Thread.sleep(1500);
	}

	@Test(priority = 3)
	public void OpenMyntra() throws InterruptedException {
		launchBrowser("Chrome");
		launchURL("https://www.myntra.com/");
		Thread.sleep(1500);

	}

	@Test(priority = 4)
	public void OpenGoogle() throws InterruptedException {
		launchBrowser("Chrome");
		launchURL("https://www.google.co.in");
		Thread.sleep(1500);

	}
}
