package mymavenProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class simpleExtentReports {

	public static void main(String[] args) {

		ExtentSparkReporter htmlReport = new ExtentSparkReporter("AutomationReport.html");

		ExtentReports report = new ExtentReports();

		report.attachReporter(htmlReport);

		ExtentTest test1;
		report.setSystemInfo("Project Name", "MavenAutoamtionProject");
		report.setSystemInfo("Machine", "Apple Mac");
		report.setSystemInfo("OS", "APPLE OS");
		report.setSystemInfo("Company", "Open Source");
		report.setSystemInfo("User", "Nitin");
		report.setSystemInfo("Browser", "Google Chrome");

		// Configuration and look and feel of reports;

		htmlReport.config().setDocumentTitle("MyAutomationReport");
		htmlReport.config().setReportName("Selenium Automation");
		htmlReport.config().setTheme(Theme.STANDARD);
		htmlReport.config().setTimeStampFormat("dd-MMMM-YYYY");

		WebDriver driver = new ChromeDriver();
		driver.get("https://facebook.com");
		driver.manage().window().maximize();

		System.out.println(driver.getTitle());

		driver.close();

		test1 = report.createTest("Home Page");

		test1.log(Status.PASS, MarkupHelper.createLabel("Home Page", ExtentColor.RED));

		report.flush();
	}

}
