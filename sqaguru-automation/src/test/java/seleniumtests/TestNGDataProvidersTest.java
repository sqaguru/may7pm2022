package seleniumtests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commonlib.SeleniumUtils;

public class TestNGDataProvidersTest {
	@DataProvider(name = "GoogleSearchDataProvider")
	public Object[][] createData1() {
		return new Object[][] { { "chrome", "selenium dev" }, { "edge", "testng.org" }, { "firefox", "java oops" } };
	}

	@Test(dataProvider = "GoogleSearchDataProvider")
	public void parameterTest(String browserName, String searchKey) {
		SeleniumUtils seleniumUtils = new SeleniumUtils();
		WebDriver driver = seleniumUtils.launchBrowser(browserName);
		driver.get("http://www.google.com/");
		driver.findElement(By.name("q")).click();
		driver.findElement(By.name("q")).sendKeys(searchKey, Keys.ENTER);
		String title = driver.getTitle();
		Reporter.log("search result title for Selenium dev: " + title, true);
	}

	@Test(dataProvider = "GoogleSearchDataProvider")
	public void test2(String browserName, String searchKey) {
		Reporter.log("browserName: " + browserName, true);
		Reporter.log("searchKey: " + searchKey, true);
	}

}
