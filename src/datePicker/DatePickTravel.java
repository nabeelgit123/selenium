package datePicker;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConfigReader;

public class DatePickTravel {

	public static void main(String[] args) {
		ConfigReader configReader = new ConfigReader();
		String driverPath = configReader.getDriverPath();
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://phptravels.net/");
		// code flaky takes long time to open site
		WebElement dateMenu = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='depart form-control']")));
		dateMenu.click();

	}
}
