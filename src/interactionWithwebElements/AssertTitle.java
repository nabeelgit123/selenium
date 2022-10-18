package interactionWithwebElements;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import utils.ConfigReader;

public class AssertTitle {

	public static void main(String[] args) {
		ConfigReader configReader = new ConfigReader();
		WebDriver driver = configReader.launchUrl();
		String actualTitle = driver.getTitle();
		System.out.println("the actual title =" + actualTitle);
		String expectedTitle = "Homepage";
		Assert.assertEquals(actualTitle, expectedTitle);
		driver.quit();
	}

}
// if expected title was passed as Homepag. got below error
// Exception in thread "main" org.junit.ComparisonFailure: expected:<Homepag[e]> but was:<Homepag[]>