package seleniumtests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commonlib.SeleniumUtils;

public class TestNGParametersTest {
	@Parameters("browserName")
	@Test
	public void parameterTest(String browserName) {
		SeleniumUtils seleniumUtils = new SeleniumUtils();
		WebDriver driver = seleniumUtils.launchBrowser(browserName);
		driver.get("http://www.google.com/");
		driver.findElement(By.name("q")).click();
		driver.findElement(By.name("q")).sendKeys("selenium dev", Keys.ENTER);
		String title = driver.getTitle();
		Reporter.log("search result title for Selenium dev: " + title, true);
	}
}
