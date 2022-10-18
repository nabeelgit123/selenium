package interactionWithwebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.ConfigReader;

public class RadioButtons {

	public static void main(String[] args) {
		ConfigReader configReader = new ConfigReader();
		WebDriver driver = configReader.launchUrl();
		driver.findElement(By.linkText("DROPDOWN CHECKBOX RADIO")).click();
		WebElement buttonOne = driver.findElement(By.xpath("//label[contains(text(),'One')]"));
		buttonOne.click();

		WebElement buttonTwo = driver.findElement(By.xpath("//label[contains(text(),'Two')]"));
		buttonTwo.click();

		WebElement buttonThree = driver.findElement(By.xpath("//label[contains(text(),'Three')]"));
		buttonThree.click();
		driver.quit();
	}

}
