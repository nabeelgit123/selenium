package advancedElementIntereaction;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import utils.ConfigReader;

public class ScreenShot {

	public static void main(String[] args) throws IOException {

		ConfigReader configReader = new ConfigReader();
		WebDriver driver = configReader.launchUrl();
		configReader.takeScreenShot("FirstSs1");
		System.out.println("Done");
		driver.quit();
	}

}
