package advancedElementIntereaction;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.ConfigReader;

public class FillContatctUsJavaScript {

	public static void main(String[] args) {
		ConfigReader configReader = new ConfigReader();
		WebDriver driver = configReader.launchUrl();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(By.linkText("CONTACT US FORM TEST")).click();
		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("nabeel ");
		driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("shaikh");
		driver.findElement(By.name("email")).sendKeys("abcd@gmail.com");
		driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("shaikh");

		WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
		js.executeScript("arguments[0].click()", submit);

		// js.executeScript("document.getElementsByClassName('contact_button')[1].click()");
	}

}
