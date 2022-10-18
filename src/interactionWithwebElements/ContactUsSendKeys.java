package interactionWithwebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ConfigReader;

public class ContactUsSendKeys {

	public static void main(String[] args) {
		ConfigReader configReader = new ConfigReader();
		WebDriver driver = configReader.launchUrl();
		driver.findElement(By.xpath("//a[contains(text(),'Contact Us Form Test')]")).click();
		driver.findElement(By.xpath("//input[@name=\"first_name\"]")).sendKeys("nabeel ");
		driver.findElement(By.xpath("//input[@name=\"last_name\"]")).sendKeys("shaikh");
		driver.findElement(By.name("email")).sendKeys("abcd@gmail.com");
		driver.findElement(By.xpath("//textarea[@name=\"message\"]")).sendKeys("shaikh");
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		driver.quit();
	}

}
