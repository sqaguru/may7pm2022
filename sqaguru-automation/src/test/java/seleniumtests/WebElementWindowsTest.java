package seleniumtests;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementWindowsTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\sqa-guru\\bat-may22-6-7pm\\batch-may-2022-7pm-ws\\automation-testing-batch-may-2022-7pm\\resources\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		// WebDriver - An interface - containing all methods with signatures
		// chromedriver - is a class, to launch chrome browser

		driver.get("https://demoqa.com/browser-windows");

		String parentWindowId = driver.getWindowHandle();

		System.out.println("parentWindowId: " + parentWindowId);

		driver.findElement(By.id("tabButton")).click();

		Set<String> windowHandles = driver.getWindowHandles();

		for (String windowId : windowHandles) {
			System.out.println("window id: " + windowId);
			if (!windowId.equals(parentWindowId)) {
				driver.switchTo().window(windowId);
			}
		}

		String headerTitleSecondWindow = driver.findElement(By.id("sampleHeading")).getText();

		System.out.println("headerTitle: " + headerTitleSecondWindow);
		
		driver.close();//closing current window
		
		driver.switchTo().window(parentWindowId);
		
		driver.findElement(By.id("windowButton")).isDisplayed();

	}

}
