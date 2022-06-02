package seleniumtests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\sqa-guru\\bat-may22-6-7pm\\batch-may-2022-7pm-ws\\automation-testing-batch-may-2022-7pm\\resources\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		// WebDriver - An interface - containing all methods with signatures
		// chromedriver - is a class, to launch chrome browser

		driver.get("https://www.google.com/");

		driver.findElement(By.name("q")).isDisplayed();// verify search bar exist

		driver.findElement(By.name("q")).sendKeys("Selenium dev");// type text on search bar

		String titleBeforeSubmit = driver.getTitle();

		System.out.println("titleBeforeSubmit: " + titleBeforeSubmit);

		driver.findElement(By.name("q")).submit();

		String titleAfterSubmit = driver.getTitle();

		System.out.println("titleAfterSubmit: " + titleAfterSubmit);

		if (titleBeforeSubmit.equals(titleAfterSubmit)) {
			System.out.println("FAIL");
		} else {
			System.out.println("PASS");
		}

	}

}
