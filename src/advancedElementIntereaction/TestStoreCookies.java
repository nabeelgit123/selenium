package advancedElementIntereaction;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.ConfigReader;

public class TestStoreCookies {

	public static void main(String[] args) throws IOException {
		ConfigReader configReader = new ConfigReader();
		WebDriver driver = configReader.launchUrl();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement storeElement = driver.findElement(By.linkText("TEST STORE"));
		js.executeScript("arguments[0].scrollIntoView()", storeElement);
		storeElement.click();
		driver.findElement(By.cssSelector("[class='user-info']")).click();

		driver.findElement(By.cssSelector("[data-link-action='sign-in']")).click();
		driver.findElement(By.xpath("//div[@class=\"col-md-6\"]//input[@name=\"email\"]")).sendKeys("abcd@gmail.com");
		driver.findElement(By.cssSelector("[name=\"password\"]")).sendKeys("123456789");
		driver.findElement(By.id("submit-login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		System.out.println(driver.findElement(By.xpath("//span[contains(text(),'Sagar Mahajan')]")).getText());
		driver.findElement(By.cssSelector("[href=\"http://teststore.automationtesting.co.uk/3-clothes\"]")).click();

		driver.findElement(By.linkText("Hummingbird Printed T-Shirt")).click();
		driver.findElement(By.cssSelector("[class=\"btn btn-primary add-to-cart\"]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.cssSelector(".btn.btn-secondary")).click();

		String actualCartCount = driver.findElement(By.cssSelector("span.cart-products-count")).getText();
		String expectedCartCount = "(1)";
		System.out.println(actualCartCount);
		Assert.assertEquals(expectedCartCount, actualCartCount);
		Set<Cookie> allCookies = driver.manage().getCookies();
		System.out.println(allCookies.size());
		for (Cookie showcookie : allCookies) {
			System.out.println(showcookie.getName());
		}

		driver.manage().deleteAllCookies();
		Set<Cookie> allCookiesdel = driver.manage().getCookies();
		System.out.println(allCookiesdel.size());
		driver.navigate().refresh();

		String CartCount = driver.findElement(By.cssSelector("span.cart-products-count")).getText();
		System.out.println(CartCount);

		configReader.takeScreenShot("C1");
		System.out.println("done");
		driver.quit();
	}

}
