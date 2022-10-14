package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

public class FindByXpath {
    public static void main(String[] args) {
        ConfigReader configReader = new ConfigReader();
        WebDriver driver = configReader.launchUrl();
        driver.findElement(By.linkText("BUTTONS")).click();

        //Finding by Absolute Xpath
        //driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]")).click();

        //finding by relative xpath
        //driver.findElement(By.xpath("//button[@id='btn_one']")).click();

        //xpath options
        //xpath option 1 using or
        //driver.findElement(By.xpath("//*[@id='btn_one' or @type='button']")).click();

        //xpath option 2 using and
        //driver.findElement(By.xpath("//*[@id='btn_one' and @type='button']")).click();

        //xpath option 3 using contains()
        //driver.findElement(By.xpath("//*[contains(@id,'btn_one')]")).click();

        //xpath option 4 using starts-with()
        //driver.findElement(By.xpath("//*[starts-with(@id,'btn_o')]")).click();

        //xpath option 5 using text()
        //driver.findElement(By.xpath("//*[text()='Button One']")).click();

        //xpath option 6 chained xpath
        driver.findElement(By.xpath("//div[@class='col-4 col-12-medium']//button[@id='btn_one']")).click();
        driver.quit();
    }
}
