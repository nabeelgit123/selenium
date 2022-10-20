package interactionWithwebElements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.ConfigReader;

public class Alerts {

	public static void main(String[] args) {
		ConfigReader configReader = new ConfigReader();
		WebDriver driver = configReader.launchUrl();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement popUp = driver.findElement(By.xpath("//a[contains(text(),'Pop Ups & Alerts')]"));
		js.executeScript("arguments[0].scrollIntoView", popUp);
		popUp.click();
		driver.findElement(By.xpath("//button[@onclick='alertTrigger()']")).click();
		Alert alertMessage = driver.switchTo().alert();
		System.out.println(alertMessage.getText());
		alertMessage.accept();
		driver.quit();

	}

}
