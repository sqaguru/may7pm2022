package seleniumtests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commonlib.ExcelReader;
import commonlib.SeleniumUtils;

public class TestNGDataProvidersUsingExcelTest {
	@DataProvider(name = "GoogleSearchDataProvider")
	public Object[] createData1() throws FileNotFoundException, IOException {
		return (Object[]) ExcelReader.readExcelData();
	}

	@Test(dataProvider = "GoogleSearchDataProvider")
	public void parameterTest(HashMap<String, String> testData) {
		SeleniumUtils seleniumUtils = new SeleniumUtils();
		WebDriver driver = seleniumUtils.launchBrowser(testData.get("BrowserName"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get("http://www.google.com/");

		driver.findElement(By.name("q")).click();
		driver.findElement(By.name("q")).sendKeys(testData.get("SearchKey"), Keys.ENTER);
		String title = driver.getTitle();
		Reporter.log("verify search result title for Selenium dev: " + title + " is same as expected - "
				+ testData.get("SearchResultTitle"), true);

		Assert.assertEquals(title, testData.get("SearchResultTitle"), "Verify search result title: ");
	}
}
