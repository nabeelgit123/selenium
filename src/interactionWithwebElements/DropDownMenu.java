package interactionWithwebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.ConfigReader;

public class DropDownMenu {

	public static void main(String[] args) {
		ConfigReader configReader = new ConfigReader();
		WebDriver driver = configReader.launchUrl();
		driver.findElement(By.linkText("DROPDOWN CHECKBOX RADIO")).click();
		WebElement dropDown = driver.findElement(By.id("cars"));
		Select select = new Select(dropDown);
		select.selectByValue("ford");
		driver.quit();
	}

}
