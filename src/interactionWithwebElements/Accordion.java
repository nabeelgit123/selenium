package interactionWithwebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ConfigReader;

public class Accordion {

	public static void main(String[] args) {
		ConfigReader configReader = new ConfigReader();
		WebDriver driver = configReader.launchUrl();
		driver.findElement(By.linkText("ACCORDION")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Platform Portability')]")).click();
		String className = driver.findElement(By.xpath("//div[contains(text(),'Platform Portability')]"))
				.getAttribute("class");
		System.out.println(className);
		if (className.endsWith("active")) {
			System.out.println("the accordion is active");
		} else {
			System.out.println("the accordion is not active");
		}
		driver.quit();
	}

}
