package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConfigReader {

	private Properties properties;
	private final String propertyFilePath = "C:\\Users\\Khalid\\eclipse-workspace12\\projectSelenium\\configs\\confi.properties";
	WebDriver driver;

	public ConfigReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {

				properties.load(reader);
				reader.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public String getDriverPath() {
		String path = properties.getProperty("driverPath");
		if (path != null)
			return path;
		else
			throw new RuntimeException("driverPath not specified in the Config.properties file." + path);

	}

	public String getUrl() {
		String url = properties.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("URL not specified in the Config.properties file." + url);

	}

	public WebDriver launchUrl() {
		System.setProperty("webdriver.chrome.driver", getDriverPath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(getUrl());
		return driver;
	}
}
