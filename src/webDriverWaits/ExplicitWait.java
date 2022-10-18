package webDriverWaits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConfigReader;

public class ExplicitWait {

	public static void main(String[] args) {
		ConfigReader configReader = new ConfigReader();
		WebDriver driver = configReader.launchUrl();
		driver.findElement(By.linkText("LOADER")).click();
		WebElement button = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.id("loaderBtn")));
		button.click();

	}

}
//Response :Exception in thread "main" org.openqa.selenium.TimeoutException: 
//Expected condition failed: waiting for element to be clickable: By.id: loaderBtn (tried for 4 second(s) 
//with 500 milliseconds interval) 

//Code when the timeout is of 4 second