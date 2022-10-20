package advancedElementIntereaction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import utils.ConfigReader;

public class DesieredCapabilitesImplementation {

	public static void main(String[] args) {
		ConfigReader configReader = new ConfigReader();
		ChromeOptions options = new ChromeOptions();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(capabilities);
		options.addArguments("start-maximized");
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

		String driverPath = configReader.getDriverPath();
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");

	}

}
