package seleniumtests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementTextBoxTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\sqa-guru\\bat-may22-6-7pm\\batch-may-2022-7pm-ws\\automation-testing-batch-may-2022-7pm\\resources\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//wait for an element for the given time period, until the element is loaded
		//once the element is loaded, perform the action
		//if element is not not loaded in the given period, script should terminiate
		//implicit wait is applicable the browser level, implicitly wait

		// WebDriver - An interface - containing all methods with signatures
		// chromedriver - is a class, to launch chrome browser

		driver.get("https://demoqa.com/text-box");

		driver.findElement(By.id("userName")).sendKeys("Sqaguru");
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("userEmail")));

		driver.findElement(By.id("userEmail")).sendKeys("guru99@sqaguru.co.in");

	}

}
