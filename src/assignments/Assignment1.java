package assignments;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.ConfigReader;

/*
 * Small Assignment 1:
Open the Chrome browser.
Maximize the browser window.
Navigate to “http://qatechhub.com”.
Write a method to print PASS if the title of the page matches with
 “QA Automation Tools Trainings and Tutorials | QA Tech Hub” else FAIL. 
 (use assert statement to give a verdict of the pass or fail status.
Navigate to the Facebook page (https://www.facebook.com)
Navigate back to the QA Tech Hub website.
Print the URL of the current page.
Navigate forward.
Reload the page.
Close the Browser.


 */
public class Assignment1 {

	public static void main(String[] args) {
		ConfigReader configReader = new ConfigReader();
		String driverPath = configReader.getDriverPath();
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("http://qatechhub.com");
		String facbookUrl = "https://www.facebook.com";

		String actualTitleOfQa = driver.getTitle();
		String expectedTitleOfQa = "QA Automation Tools Trainings and Tutorials | QA Tech Hub";

		Assert.assertEquals(expectedTitleOfQa, actualTitleOfQa);

		System.out.println("Passed");

		driver.navigate().to(facbookUrl);
		System.out.println(driver.getTitle());
		driver.navigate().back();

		System.out.println(driver.getTitle());
		System.out.println("current page Url" + driver.getCurrentUrl());
		driver.navigate().forward();

		driver.navigate().refresh();
		System.out.println("done");

		driver.quit();
	}
}
