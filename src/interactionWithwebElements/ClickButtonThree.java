package interactionWithwebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ConfigReader;

public class ClickButtonThree {

	public static void main(String[] args) {
		ConfigReader configReader = new ConfigReader();
		WebDriver driver = configReader.launchUrl();
		driver.findElement(By.linkText("BUTTONS")).click();
		driver.findElement(By.id("btn_three")).click();
		driver.quit();
	}

}
