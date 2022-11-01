package PracticeAssessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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

	public static void login() throws Exception {
		try {
			driver.findElement(By.cssSelector("#username")).sendKeys("rahulshettyacademy");
			driver.findElement(By.cssSelector("#password")).sendKeys("learning");
			WebElement dropDown = driver.findElement(By.cssSelector("[data-style=\"btn-info\"]"));
			Select option = new Select(dropDown);
			option.selectByIndex(0);
			WebElement termsConditions = driver.findElement(By.cssSelector("#terms"));
			termsConditions.click();
			System.out.println("terms and condition = " + termsConditions.isSelected());
			driver.findElement(By.cssSelector("#signInBtn")).click();
		} catch (Exception e) {
			WebElement errorMsg = new WebDriverWait(driver, Duration.ofSeconds(5)).until(
					ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert.alert-danger.col-md-12")));
			System.out.println(errorMsg.isDisplayed());
			if (errorMsg.isDisplayed()) {
				throw new Exception("login failed" + errorMsg.getText());
			}
		}
	}

	public static void verifyHomePg() throws Exception {
		WebElement loginSuccess = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(" div > nav > a")));
		String text = loginSuccess.getText();
		System.out.println(text);
	}

	public static void addToCart() throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// pressing add to cart button
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement checkOutOption = driver.findElement(By.cssSelector("#navbarResponsive > ul > li > a"));
		System.out.println("before adding item to cart ,cart count = " + checkOutOption.getText());
		WebElement addToCartBtn = driver
				.findElement(By.cssSelector("app-card:nth-child(1) > div > div.card-footer > button"));
		js.executeScript("arguments[0].scrollIntoView;", addToCartBtn);
		addToCartBtn.click();
	}

	public static void cartCountVerify() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement checkOutOption = driver.findElement(By.cssSelector("#navbarResponsive > ul > li > a"));
		js.executeScript("arguments[0].scrollIntoView;", checkOutOption);
		String expectedCountOfItems = "1";
		String actualCartCount = checkOutOption.getText();
		System.out.println("actual cart count, after adding  item to cart = " + actualCartCount);
		if (actualCartCount.contains(expectedCountOfItems))
			System.out.println("correct count of items added to the cart");
		else
			throw new Exception("correct count of items not added to the cart");
	}

	public static void addQuantity(String quantity) throws Exception {
		WebElement checkOutOption = driver.findElement(By.cssSelector("#navbarResponsive > ul > li > a"));
		checkOutOption.click();
		String itemName = driver.findElement(By.xpath("//h4/a")).getText();
		System.out.println("item added to cart = " + itemName);
		driver.findElement(By.cssSelector("#exampleInputEmail1")).clear();
		driver.findElement(By.cssSelector("#exampleInputEmail1")).sendKeys(quantity);
	}

	public static void priceVerify(String quantity) throws Exception {
		// getting price of one product then applying logic to get price according to
		// the quantity

		String priceOfOne = driver.findElement(By.cssSelector(" td:nth-child(3) > strong")).getText();
		double priceFormatted = priceFormatter(priceOfOne);
		int quan = Integer.parseInt(quantity);
		double totalExpected = quan * priceFormatted;

		String getActualTotal = driver.findElement(By.cssSelector("h3 > strong")).getText();
		double actualTotalFormatted = priceFormatter(getActualTotal);
		System.out.println("expected toptal = " + totalExpected);
		System.out.println("actual total = " + actualTotalFormatted);
		if (totalExpected == actualTotalFormatted)
			System.out.println("total price expected and actual  are same");
		else
			throw new Exception("Total is not as expected");

	}

	public static void purchaseDetails() throws Exception {
		driver.findElement(By.cssSelector("tbody > tr:nth-child(3) > td:nth-child(5) > button")).click();
		// purchasing the product last step
		System.out.println("purchasing last step");
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
	}

	public static void purchaseVerify() throws Exception {

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
			throw new Exception("purchaseVerify failed with : success message not displayed");
	}

	public static double priceFormatter(String price) {
		System.out.println(price);
		price = price.replace("₹", " ");
		System.out.println(price);
		price = price.replace(".", " ");
		System.out.println(price);
		price = price.replace(" ", "");
		System.out.println(price);
		double formattedPrice = Double.parseDouble(price);
		return (formattedPrice);
	}

	public static void main(String[] args) throws InterruptedException {
		String quantity = "4";
		ConfigReader configReader = new ConfigReader();
		driver = configReader.launchAssessmentUrl();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		try {
			login();
			verifyHomePg();
			addToCart();
			cartCountVerify();
			addQuantity(quantity);
			priceVerify(quantity);
			purchaseDetails();
			purchaseVerify();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
