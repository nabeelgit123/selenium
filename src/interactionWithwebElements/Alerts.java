package interactionWithwebElements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.ConfigReader;

public class Alerts {

	public static void main(String[] args) {
		ConfigReader configReader = new ConfigReader();
		String driverPath = configReader.getDriverPath();
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.automationtesting.co.uk/popups.html");
		driver.findElement(By.xpath("//button[@onclick='alertTrigger()']")).click();
		Alert alertMessage = driver.switchTo().alert();
		System.out.println(alertMessage.getText());
		alertMessage.accept();
		driver.quit();

	}

}
