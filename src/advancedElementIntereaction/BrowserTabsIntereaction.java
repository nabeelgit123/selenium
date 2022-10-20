package advancedElementIntereaction;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ConfigReader;

public class BrowserTabsIntereaction {

	public static void main(String[] args) {
		ConfigReader configReader = new ConfigReader();
		WebDriver driver = configReader.launchUrl();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.linkText("BROWSER TABS")).click();

		String parentWindowHandle = driver.getWindowHandle();

		for (int i = 0; i <= 2; i++) {
			driver.findElement(By.xpath("//input[@value=\"Open Tab\"]")).click();
			driver.switchTo().window(parentWindowHandle);
		}

		Set<String> allWindowHandles = driver.getWindowHandles();
		int size = allWindowHandles.size();
		System.out.println("total number of tabs = " + size);
		ArrayList<String> allTabs = new ArrayList<String>(allWindowHandles);
		for (String child : allTabs) {
			driver.switchTo().window(child);
		}

		System.out.println("switching to the parentWindow");
		driver.switchTo().window(parentWindowHandle);
	}

}
