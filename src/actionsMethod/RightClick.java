package actionsMethod;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import utils.ConfigReader;

public class RightClick {

	public static void main(String[] args) throws IOException {
		ConfigReader configReader = new ConfigReader();
		String driverPath = configReader.getDriverPath();
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		WebElement rightClick = driver.findElement(By.cssSelector("[class=\"context-menu-one btn btn-neutral\"]"));
		action.contextClick(rightClick).build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement copyOption = driver
				.findElement(By.xpath("//ul[@class=\"context-menu-list context-menu-root\"]//li[3]"));
		System.out.println(copyOption.getText());
		System.out.println("Done");
		driver.quit();
	}

}
