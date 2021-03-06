package seleniumtests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WebElementMoveToElementTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\sqa-guru\\bat-may22-6-7pm\\batch-may-2022-7pm-ws\\automation-testing-batch-may-2022-7pm\\resources\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://demoqa.com/tool-tips");

		Actions action = new Actions(driver);

		Thread.sleep(5000);

		action.moveToElement(driver.findElement(By.id("toolTipButton"))).build().perform();

		driver.findElement(By.xpath("//*[text()='You hovered over the Button']")).isDisplayed();
	}

}
