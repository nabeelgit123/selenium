package interactionWithwebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ConfigReader;

public class HiddenElements {

	public static void main(String[] args) {
		ConfigReader configReader = new ConfigReader();
		WebDriver driver = configReader.launchUrl();
		driver.findElement(By.linkText("HIDDEN ELEMENTS")).click();
		boolean visibleElement = driver.findElement(By.xpath("//p[contains(text(),'This is a visible paragraph.')]"))
				.isDisplayed();
		System.out.println(visibleElement);
		boolean hiddenElement = driver.findElement(By.xpath("//div[@id='myDIV']")).isDisplayed();
		System.out.println(hiddenElement);

		// hidden element after it is visible
		driver.findElement(By.xpath("//button[contains(text(),'Toggle')]")).click();
		boolean hiddenElementVisible = driver.findElement(By.xpath("//div[@id='myDIV']")).isDisplayed();
		System.out.println(hiddenElementVisible);
		driver.quit();
	}

}
