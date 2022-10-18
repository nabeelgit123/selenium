package interactionWithwebElements;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.ConfigReader;

public class HandleWindows {

	public static void main(String[] args) throws InterruptedException {
		ConfigReader configReader = new ConfigReader();
		String driverPath = configReader.getDriverPath();
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.automationtesting.co.uk/popups.html");

		driver.findElement(By.cssSelector("div.col-12.col-12-small > button:nth-child(4)")).click();

		String firstWindowHandle = driver.getWindowHandle();
		System.out.println("first" + firstWindowHandle);

		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> itr = windowHandles.iterator();
		while (itr.hasNext()) {
			String childWindow = itr.next();
			if (!firstWindowHandle.equalsIgnoreCase(childWindow)) {
				System.out.println("this is after pop window" + childWindow);
				driver.switchTo().window(childWindow);
				driver.close();

			}

		}

		driver.switchTo().window(firstWindowHandle);
		System.out.println("reached to main window");
		driver.findElement(By.cssSelector(
				"div:nth-child(1) div.inner:nth-child(1) div.row:nth-child(8) div.col-12.col-12-small > button:nth-child(3)"))
				.click();
		driver.switchTo().alert().accept();
		driver.quit();

	}

}
