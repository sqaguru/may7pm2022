package seleniumtests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementCheckBoxTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\sqa-guru\\bat-may22-6-7pm\\batch-may-2022-7pm-ws\\automation-testing-batch-may-2022-7pm\\resources\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		// WebDriver - An interface - containing all methods with signatures
		// chromedriver - is a class, to launch chrome browser

		driver.get("https://demoqa.com/automation-practice-form");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		/*
		 * WebElement element = driver .findElement(By.xpath(
		 * "//LABEL[@title=''][text()='Reading']/preceding-sibling::input"));
		 * 
		 * JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		 * javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);",
		 * element);
		 * 
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60)); try {
		 * wait.until(ExpectedConditions.elementToBeClickable(element));
		 * element.click(); } catch (TimeoutException timeoutException) {
		 * System.out.println(timeoutException.getMessage()); }
		 */

		WebElement element2 = driver.findElement(By.xpath("//label[text()='Reading']"));
		element2.click();

		System.out.println("element2 clicked:");

	}

}
