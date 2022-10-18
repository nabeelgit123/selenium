package webDriverWaits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ConfigReader;

public class ImplicitWait {

	public static void main(String[] args) {
		ConfigReader configReader = new ConfigReader();
		WebDriver driver = configReader.launchUrl();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.linkText("LOADER")).click();
		driver.findElement(By.id("loaderBtn")).click();
		driver.quit();
	}

}
//REsponse 
//Exception in thread "main" org.openqa.selenium.ElementNotInteractableException: element not interactable
//Code: when the wait is of 4 seconds