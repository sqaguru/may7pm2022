package seleniumtests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import commonlib.SeleniumUtils;

public class WebElementDropDownTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		SeleniumUtils seleniumUtils = new SeleniumUtils();
		WebDriver driver;
		String browserName = "edge";

		driver = seleniumUtils.launchBrowser(browserName);
		// WebDriver - An interface - containing all methods with signatures
		// chromedriver - is a class, to launch chrome browser

		driver.get("https://demoqa.com/select-menu");

		seleniumUtils.captureScreenShot(driver, "1_NavigateToDemoQAMenu");

		seleniumUtils.captureElementScreenshotFor(driver, "1_DropDownElement", By.id("oldSelectMenu"));

		try {
			JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

			javascriptExecutor.executeScript("arguments[0].scrollIntoView1(true);", driver.findElement(By.id("cars")));
		} catch (JavascriptException javascriptException) {
			System.out.println("javascriptException exception occured and handled");
		}

		Select selectColor = new Select(driver.findElement(By.id("oldSelectMenu")));

		selectColor.selectByVisibleText("Yellow");

		seleniumUtils.captureScreenShot(driver, "2_selectedYelloOption");

		Thread.sleep(1000);

		selectColor.selectByValue("6");

		seleniumUtils.captureScreenShot(driver, "3_selectedByValue6");

		Thread.sleep(1000);

		selectColor.selectByIndex(2);

		seleniumUtils.captureScreenShot(driver, "4_selectedByIndex2");

		Thread.sleep(1000);

		seleniumUtils.captureElementScreenshotFor(driver, "1_SelectDrodpwonColor",
				By.xpath("//*[@id=\"selectOne\"]/div/div[1]"));

		driver.findElement(By.xpath("//*[@id=\"selectOne\"]/div/div[1]")).click();

		driver.findElement(By.xpath("//*[.='Mrs.']")).click();

		seleniumUtils.captureElementScreenshotFor(driver, "2_div", By.xpath("//*[.='Mrs.']"));

		driver.findElement(By.xpath("//*[.='Mrs.']")).click();

		Thread.sleep(2000);

		Select carSelect = new Select(driver.findElement(By.id("cars")));

		boolean hasMultipleSelection = carSelect.isMultiple();

		System.out.println("hasMultipleSelection: " + hasMultipleSelection);

		carSelect.selectByVisibleText("Audi");

		if (hasMultipleSelection) {
			carSelect.selectByVisibleText("Volvo");
		}

		Thread.sleep(1000);

		carSelect.deselectAll();

	}

}
