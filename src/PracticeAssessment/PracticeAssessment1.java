package PracticeAssessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import utils.ConfigReader;

/*
Practice assessment 1:
Goto https://rahulshettyacademy.com/loginpagePractise/ and login with username: rahulshettyacademy and Password: learning
Verify if you are logged in
Add any product to cart
Verify if product is added to cart
Goto Checkout page
Increase quantity by 4
Verify the price
Checkout and purchase
*/
public class PracticeAssessment1 {
	static WebDriver driver;

	public static void login() throws InterruptedException {
		driver.findElement(By.cssSelector("#username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("#password")).sendKeys("learning");
		WebElement dropDown = driver.findElement(By.cssSelector("[data-style=\"btn-info\"]"));
		Select option = new Select(dropDown);
		option.selectByIndex(0);
		WebElement termsConditions = driver.findElement(By.cssSelector("#terms"));
		termsConditions.click();
		System.out.println("terms and condition = " + termsConditions.isSelected());

		driver.findElement(By.cssSelector("#signInBtn")).click();

		Thread.sleep(2000);
		try {

			boolean incorrectDetailsMsg = driver.findElement(By.cssSelector("div.alert.alert-danger.col-md-12"))
					.isDisplayed();
			if (incorrectDetailsMsg) {
				WebElement erMsg = driver.findElement(By.cssSelector("div.alert.alert-danger.col-md-12"));
				System.out.println("wrong details entered ,error message = " + erMsg.getAttribute("textContent"));
			}
		} catch (Exception e) {
			System.out.println("NO ERROR ALL DETAILS RIGHT");
			WebElement siteName = driver.findElement(By.cssSelector("div > nav > a"));
			if (siteName.isDisplayed()) {
				System.out.println("all details are correct successfully logged into " + siteName.getText());
				System.out.println("Adding items to cart ");
				cartToCheckout();
			}
		}

	}

	public static void cartToCheckout() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String quantity = "4";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// pressing add to cart button
		WebElement checkOutOption = driver.findElement(By.cssSelector("#navbarResponsive > ul > li > a"));
		System.out.println("before adding item to cart ,cart count = " + checkOutOption.getText());
		WebElement addToCartBtn = driver
				.findElement(By.cssSelector("app-card:nth-child(1) > div > div.card-footer > button"));
		js.executeScript("arguments[0].scrollIntoView;", addToCartBtn);
		addToCartBtn.click();
		// pressing checkout button and getting the text of checkout (for count of
		// items)

		js.executeScript("arguments[0].scrollIntoView;", checkOutOption);
		String expectedCountOfItems = "1";
		String actualCartCount = checkOutOption.getText();
		System.out.println("actual cart count, after adding  item to cart = " + actualCartCount);
		if (actualCartCount.contains(expectedCountOfItems))
			System.out.println("correct count of items added to the cart");
		else
			System.out.println("correct count of items not added to the cart");

		checkOutOption.click();
		String itemName = driver.findElement(By.xpath("//h4/a")).getText();
		System.out.println("item added to cart = " + itemName);
		driver.findElement(By.cssSelector("#exampleInputEmail1")).clear();
		driver.findElement(By.cssSelector("#exampleInputEmail1")).sendKeys(quantity);
		// getting price of one product then applying logic to get price according to
		// the quantity
		String priceOfOne = driver.findElement(By.cssSelector(" td:nth-child(3) > strong")).getAttribute("textContent");
		String priceModi = priceFormatter(priceOfOne);
		double price = Double.parseDouble(priceModi);
		int quan = Integer.parseInt(quantity);
		double totalExpected = quan * price;

		String getActualTotal = driver.findElement(By.cssSelector("h3 > strong")).getAttribute("textContent");
		String actualTotalModi = priceFormatter(getActualTotal);
		double actualTotal = Double.parseDouble(actualTotalModi);
		System.out.println("expected toptal = " + totalExpected);
		System.out.println("actual total = " + actualTotal);

		if (totalExpected == actualTotal)
			System.out.println("total price expected and actual  are same");
		else
			System.out.println("Total is not as expected");
		driver.findElement(By.cssSelector("tbody > tr:nth-child(3) > td:nth-child(5) > button")).click();
		// purchasing the product last step
		System.out.println("purchasing last step");
		purchaseOption();
	}

	public static void purchaseOption() {
		driver.findElement(By.cssSelector("#country")).sendKeys("India");
		WebElement checkbox = driver.findElement(By.cssSelector(
				"body > app-root > app-shop > div > app-checkout > div > div.checkbox.checkbox-primary > label"));
		System.out.println("clicking the checkbox terms and condition of purchase");
		checkbox.click();
		try {
			driver.findElement(
					By.xpath("/html/body/app-root/app-shop/div/app-checkout/div[1]/ngx-smart-modal/div[2]/button[1]"))
					.click();
		} catch (Exception e) {
			System.out.println("popup of terms and conditions didnt appear this time");
		}
		driver.findElement(By.cssSelector("div.suggestions > ul > li > a")).click();
		System.out.println("clicking purchase btn");
		driver.findElement(
				By.cssSelector("body > app-root > app-shop > div > app-checkout > div:nth-child(3) > form > input"))
				.click();
		System.out.println("terms and condition checked= " + driver.findElement(By.id("checkbox2")).isSelected());
		boolean successPurchaseMsg = driver.findElement(By.cssSelector(" div:nth-child(5) > div")).isDisplayed();
		if (successPurchaseMsg) {
			String msg = driver.findElement(By.cssSelector(" div:nth-child(5) > div")).getText();
			System.out.println("success purchase msg shown, message shown = " + msg);

		} else
			System.out.println("success purchaase not shown");
	}

	public static String priceFormatter(String price) {
		// System.out.println(price.length());
		System.out.println(price);
		price = price.replace("₹", " ");
		System.out.println(price);
		price = price.replace(".", " ");
		System.out.println(price);
		price = price.replace(" ", "");
		System.out.println(price);
		return (price);

	}

	public static void main(String[] args) throws InterruptedException {
		ConfigReader configReader = new ConfigReader();
		String driverPath = configReader.getDriverPath();
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		System.out.println("Login details");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement siginBtn = driver.findElement(By.cssSelector("#signInBtn"));
		if (siginBtn.isDisplayed())
			login();
		else
			System.out.println("sigin in option not available");

	}

}
