package webDriverWaits;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import utils.ConfigReader;

public class FluentWaitDriver {

	public static void main(String[] args) {
		ConfigReader configReader = new ConfigReader();
		WebDriver driver;

		driver = configReader.launchUrl();
		driver.get("https://www.automationtesting.co.uk/loadertwo.html");

		Wait<WebDriver> fluent = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		WebElement para = fluent.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.cssSelector("#appears"));
			}
		});
		System.out.println(para.getText());
		driver.quit();
	}
}
