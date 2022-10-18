package interactionWithwebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.ConfigReader;

public class CeckboxAndIsSelected {

	public static void main(String[] args) throws InterruptedException {
		ConfigReader configReader = new ConfigReader();
		WebDriver driver = configReader.launchUrl();
		driver.findElement(By.linkText("DROPDOWN CHECKBOX RADIO")).click();
		WebElement redCheckBox = driver.findElement(By.id("cb_red"));
		// 1-> verifying red checkbox is selected or not
		if (redCheckBox.isSelected()) {
			System.out.println("red checkbox is selected");
		} else {
			System.out.println("red checkbox is not selected");
		}

		WebElement greenCheckBox = driver.findElement(By.xpath("//label[@for='cb_green']"));
		// 2->verifying green checkbox is selected or not
		if (greenCheckBox.isSelected()) {
			System.out.println("green checkbox is selected");
		} else {
			System.out.println("green checkbox is not selected");
		}

		// 3->selecting green checkbox and verifying both red and green checkbox is
		// selected or not
		driver.findElement(By.xpath("//label[@for='cb_green']")).click();
		WebElement afterCheck = driver.findElement(By.id("cb_green"));
		if (redCheckBox.isSelected()) {
			System.out.println("red checkbox is selected");
		} else {
			System.out.println("red checkbox is not selected");
		}

		if (afterCheck.isSelected()) {
			System.out.println("green checkbox is selected");
		} else {
			System.out.println("green checkbox is not selected");

		}
		driver.quit();

	}

}
