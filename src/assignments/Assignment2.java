package assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConfigReader;

/*
 * Open a Chrome browser.
Navigate to “http://www.fb.com”
Verify that the page is redirected to “https://www.facebook.com/”, by getting the current URL.
Verify that there is a “Create an account” section on the page.
Fill in the text boxes: First Name, Surname, Mobile Number or email address, “Re-enter mobile number”, new password.
Update the date of birth in the drop-down.
Select gender.
Click on “Create an account”.
Verify that the account is created successfully.

 */
public class Assignment2 {

	public static void facebookSignUp(WebDriver driver) {
		driver.findElement(By.cssSelector("[aria-label='First name']")).sendKeys("Virat");
		driver.findElement(By.cssSelector("[aria-label='Surname']")).sendKeys("Sharma");
		driver.findElement(By.cssSelector("[aria-label='Mobile number or email address']")).sendKeys("12345678890");
		driver.findElement(By.cssSelector("[aria-label='Mobile number or email address']")).clear();
		driver.findElement(By.cssSelector("[aria-label='Mobile number or email address']"))
				.sendKeys("viratsharma123@gmail.com");
		driver.findElement(By.id("password_step_input")).sendKeys("user1@123");
		WebElement dayDropDown = driver.findElement(By.id("day"));
		Select dayDrop = new Select(dayDropDown);
		dayDrop.selectByIndex(0);

		WebElement monthDropDown = driver.findElement(By.id("month"));
		Select monDrop = new Select(monthDropDown);
		monDrop.selectByIndex(0);

		WebElement yearDropDown = driver.findElement(By.id("year"));
		Select yrDrop = new Select(yearDropDown);
		yrDrop.selectByVisibleText("2001");
		driver.findElement(By.xpath("//input[@value='2']")).click();

		driver.findElement(By.cssSelector("[aria-label='Re-enter email address']"))
				.sendKeys("viratsharma123@gmail.com");

		System.out.println("clicking on Signing up");
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();

		WebElement havAcc = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//*[contains(text(),'Do you already have a Facebook account?')]")));

		System.out.println(havAcc.getText());
	}

	public static void main(String[] args) {
		ConfigReader configReader = new ConfigReader();
		String driverPath = configReader.getDriverPath();
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("http://www.fb.com");
		String currentPageUrl = driver.getCurrentUrl();
		System.out.println(currentPageUrl);
		String facebookUrl = "https://www.facebook.com/";

		if (currentPageUrl.equalsIgnoreCase(facebookUrl)) {
			System.out.println("fb has redirected to facebook");
		} else {
			System.out.println("No redirection happened");
		}

		driver.findElement(By.cssSelector("[data-testid='open-registration-form-button']")).isDisplayed();

		driver.findElement(By.cssSelector("[data-testid='open-registration-form-button']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		boolean signupButton = driver.findElement(By.xpath("//div[contains(text(),'Sign Up')]")).isDisplayed();
		if (signupButton) {
			facebookSignUp(driver);
		} else {
			System.out.println("Sign Up button not displayed");
		}

	}

}
