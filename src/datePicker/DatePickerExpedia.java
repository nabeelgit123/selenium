package datePicker;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.ConfigReader;

public class DatePickerExpedia {

	public static void main(String[] args) {
		ConfigReader configReader = new ConfigReader();
		String driverPath = configReader.getDriverPath();
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.expedia.ca/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("d1-btn")).click();
		String text = driver.findElement(By.xpath(
				"//*[@id=\"wizard-hotel-pwa-v2-1\"]//div[2]//div[2]//div//div//div[1]//div//div[2]//div//div[1]//div[2]//div[1]//h2[contains(text(),'November 2022')]"))
				.getText();
		System.out.println(text);
		if (text.equals("November 2022")) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
		System.out.println("Done");
		driver.quit();
	}
}
