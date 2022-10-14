package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

public class FindByPartialLinkText {
    public static void main(String[] args) {
        ConfigReader configReader = new ConfigReader();
        WebDriver driver = configReader.launchUrl();
        // Finding by PartialLinkText
        driver.findElement(By.partialLinkText("BUT")).click();
        //Finding by Id
        driver.findElement(By.id("btn_one")).click();
        driver.quit();
    }
}
