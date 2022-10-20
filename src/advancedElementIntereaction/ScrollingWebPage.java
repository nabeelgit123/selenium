package advancedElementIntereaction;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.ConfigReader;

public class ScrollingWebPage {

	public static void main(String[] args) {
		ConfigReader configReader = new ConfigReader();
		WebDriver driver = configReader.launchUrl();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement tablesElement = driver.findElement(By.linkText("TABLES"));
		js.executeScript("arguments[0].scrollIntoView();", tablesElement);
		tablesElement.click();
	}

}
