package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

public class FindByTagName {
    public static void main(String[] args) {
        ConfigReader configReader = new ConfigReader();
        WebDriver driver = configReader.launchUrl();
        driver.findElement(By.linkText("BUTTONS")).click();
        //Finding By tagName
        driver.findElement(By.tagName("button")).click();
        driver.quit();
    }
}
