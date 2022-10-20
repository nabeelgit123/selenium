package advancedElementIntereaction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import utils.ConfigReader;

public class ChromeOptionImplementation {

	public static void main(String[] args) {
		ConfigReader configReader = new ConfigReader();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		options.addArguments("start-maximized");
		String driverPath = configReader.getDriverPath();
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.automationtesting.co.uk/popups.html");

	}

}
