package advancedElementIntereaction;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import utils.ConfigReader;

public class ManageCookies {

	public static void main(String[] args) {
		ConfigReader configReader = new ConfigReader();
		WebDriver driver = configReader.launchUrl();
		Set<Cookie> allCookie = driver.manage().getCookies();
		System.out.println(allCookie.size());

		// display all cookies
		for (Cookie cookie : allCookie) {
			System.out.println("The cookie name is : " + cookie.getName());
			System.out.println("The cookie value is : " + cookie.getValue());
		}

		// add cookies
		Cookie newCookie = new Cookie("myCookie", "this is myCookie value");
		driver.manage().addCookie(newCookie);

		// gives full cookie details
		System.out.println(driver.manage().getCookieNamed("myCookie"));

		Set<Cookie> afterAddingCookie = driver.manage().getCookies();
		System.out.println(afterAddingCookie.size());

		for (Cookie addedCookie : afterAddingCookie) {
			System.out.println("The cookie name is : " + addedCookie.getName());
			System.out.println("The cookie value is : " + addedCookie.getValue());
		}

		// deleting cookie
		driver.manage().deleteCookie(newCookie);

		Set<Cookie> afterdeletingCookie = driver.manage().getCookies();
		System.out.println(afterdeletingCookie.size());
		driver.manage().deleteAllCookies();

		Set<Cookie> afterdeletingAllCookie = driver.manage().getCookies();
		System.out.println("After deleting all the cookies : " + afterdeletingAllCookie.size());

	}

}
