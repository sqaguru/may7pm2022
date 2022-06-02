package seleniumtests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementAlertTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\sqa-guru\\bat-may22-6-7pm\\batch-may-2022-7pm-ws\\automation-testing-batch-may-2022-7pm\\resources\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		// WebDriver - An interface - containing all methods with signatures
		// chromedriver - is a class, to launch chrome browser

		driver.get("https://demoqa.com/alerts");

		driver.findElement(By.id("confirmButton")).click();

		driver.switchTo().alert().accept();

		String actualText = driver.findElement(By.id("confirmResult")).getText();

		System.out.println("after accept: " + actualText);

		driver.findElement(By.id("confirmButton")).click();

		driver.switchTo().alert().dismiss();

		actualText = driver.findElement(By.id("confirmResult")).getText();

		System.out.println("after dismiss: " + actualText);

		driver.findElement(By.id("timerAlertButton")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.alertIsPresent());

		driver.switchTo().alert().accept();

		System.out.println("alert is present");

	}

}
