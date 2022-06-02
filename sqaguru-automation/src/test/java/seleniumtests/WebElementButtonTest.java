package seleniumtests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.openqa.selenium.support.events.EventFiringDecorator;

import commonlib.Listener;

public class WebElementButtonTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\sqa-guru\\bat-may22-6-7pm\\batch-may-2022-7pm-ws\\automation-testing-batch-may-2022-7pm\\resources\\drivers\\chromedriver.exe");

		WebDriver driverOrigin = new ChromeDriver();

		Listener listener = new Listener();

		WebDriver driver = new EventFiringDecorator(listener).decorate(driverOrigin);

		// WebDriver - An interface - containing all methods with signatures
		// chromedriver - is a class, to launch chrome browser

		driver.get("https://demoqa.com/buttons");

		driver.findElement(By.xpath("//button[text()='Click Me']")).click();// action

		driver.findElement(By.xpath("//*[@id=\"dynamicClickMessage\"]")).isDisplayed();// verification/assertions/checks

	}

}
