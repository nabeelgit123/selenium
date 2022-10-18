package interactionWithwebElements;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.ConfigReader;

public class PopUp {
	WebDriver driver;

	ConfigReader configReader = new ConfigReader();

	public static void main(String[] args) throws Exception {
		PopUp pop = new PopUp();
		pop.open();
	}

	public void open() {
		String driverPath = configReader.getDriverPath();
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.automationtesting.co.uk/popups.html");
		driver.findElement(By.cssSelector("[onclick='popup\\(\\)']")).click();

		// getting the window handle id of the main window
		String MainWindow = driver.getWindowHandle();

		// using a set to store all the open window handle id's
		Set<String> handles = driver.getWindowHandles();

		// creating an iterator object to parse through each value in the set
		Iterator<String> iterate = handles.iterator();
		while (iterate.hasNext()) {
			String child = iterate.next();
			if (!MainWindow.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				driver.close();
			}
		}
		driver.switchTo().window(MainWindow);
		driver.findElement(By.xpath("//div[@id='main']/div[@class='inner']//button[.='Trigger Alert']")).click();
		driver.switchTo().alert().accept();
		driver.quit();
	}
}