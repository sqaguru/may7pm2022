package seleniumtests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementLinkTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\sqa-guru\\bat-may22-6-7pm\\batch-may-2022-7pm-ws\\automation-testing-batch-may-2022-7pm\\resources\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		// WebDriver - An interface - containing all methods with signatures
		// chromedriver - is a class, to launch chrome browser

		driver.get("https://demoqa.com/links");

		driver.findElement(By.linkText("Home")).click();

		System.out.println("clicked on home link");

		driver.findElement(By.linkText("Created")).isDisplayed();// containing text of link

		driver.findElement(By.linkText("Created")).click();

		System.out.println("clicked on created link");

	}

}
