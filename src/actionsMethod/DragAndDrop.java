package actionsMethod;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import utils.ConfigReader;

public class DragAndDrop {

	public static void main(String[] args) throws IOException {
		ConfigReader configReader = new ConfigReader();
		String driverPath = configReader.getDriverPath();
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		driver.get("https://jqueryui.com/droppable/");

		driver.switchTo().frame(0);
		WebElement draggableElement = driver.findElement(By.id("draggable"));
		WebElement dropableElement = driver.findElement(By.id("droppable"));

		action.dragAndDrop(draggableElement, dropableElement).build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("Done");
		driver.quit();

	}

}
