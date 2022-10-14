package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConfigReader {
    public  WebDriver launchUrl()
    {
        System.setProperty("webdriver.chrome.driver", "E:\\seleniumdoc\\chromedriver\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationtesting.co.uk/index.html");

        return driver;
    }
}
