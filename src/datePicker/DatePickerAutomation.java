package datePicker;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ConfigReader;

public class DatePickerAutomation {

	public static void main(String[] args) {
		ConfigReader configReader = new ConfigReader();
		WebDriver driver = configReader.launchUrl();
		driver.findElement(By.linkText("DATE PICKER")).click();
		driver.findElement(By.xpath("//*[@id=\"basicDate\"]")).click();
		String currentMonth = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/span")).getText();
		System.out.println(currentMonth);
		String expectedMon = "October";
		// needs modifications
		while (true) {
			String currentMon = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/span")).getText();
			if (expectedMon.equals(currentMon)) {
				System.out.println(currentMon);
				break;
			} else {
				driver.findElement(By.xpath("//body/div[2]/div[1]/span[2]")).click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			}
		}
		System.out.println("Done");
		driver.quit();
	}
}
