package advancedElementIntereaction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.ConfigReader;

public class IframeIntereaction {

	public static void main(String[] args) {
		ConfigReader configReader = new ConfigReader();
		WebDriver driver = configReader.launchUrl();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.linkText("IFRAMES")).click();

		driver.switchTo().frame(0);
		driver.findElement(By.cssSelector(".toggle")).click();
		driver.switchTo().parentFrame();
		driver.findElement(By.cssSelector(".toggle")).click();

		driver.switchTo().frame(1);
		WebElement playButton = driver.findElement(By.cssSelector("[aria-label='Play']"));
		playButton.click();

	}

}
