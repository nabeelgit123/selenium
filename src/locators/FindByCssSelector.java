package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ConfigReader;

public class FindByCssSelector {
	public static void main(String[] args) {
		ConfigReader configReader = new ConfigReader();
		WebDriver driver = configReader.launchUrl();
		// Tag and id
		driver.findElement(By.linkText("BUTTONS")).click();
		// Finding by cssSelector method 1
		// driver.findElement(By.cssSelector("button#btn_one")).click();
		// Finding by cssSelector method 2
		// driver.findElement(By.cssSelector("#btn_one")).click();

		// Tag and attribute method 1
		// Attribute 1
		// driver.findElement(By.cssSelector("button[type=button]")).click();
		// Attribute 2
		// driver.findElement(By.cssSelector("button[onclick='myFunction()']")).click();

		// Tag and attribute method 2
		// Attribute 1
		// driver.findElement(By.cssSelector("[type=button]")).click();
		// Attribute 2
		driver.findElement(By.cssSelector("[onclick='myFunction()']")).click();
		driver.quit();
	}
}
