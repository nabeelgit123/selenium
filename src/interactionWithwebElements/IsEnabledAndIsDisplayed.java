package interactionWithwebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.ConfigReader;

public class IsEnabledAndIsDisplayed {

	public static void main(String[] args) {
		ConfigReader configReader = new ConfigReader();
		WebDriver driver = configReader.launchUrl();
		driver.findElement(By.linkText("BUTTONS")).click();
		WebElement buttonThree = driver.findElement(By.id("btn_three"));
		if (buttonThree.isEnabled()) {
			System.out.println("button three enabled");
		} else {
			System.out.println("button three not enabled");
		}

		if (buttonThree.isDisplayed()) {
			System.out.println("button three is displayed");
		} else {
			System.out.println("button three not displayed");
		}

		WebElement buttonFour = driver.findElement(By.id("btn_four"));
		if (buttonFour.isEnabled()) {
			System.out.println("button four enabled");
		} else {
			System.out.println("button four not enabled");
		}

		if (buttonFour.isDisplayed()) {
			System.out.println("button four is displayed");
		} else {
			System.out.println("button four not displayed");
		}
		driver.quit();

	}

}
