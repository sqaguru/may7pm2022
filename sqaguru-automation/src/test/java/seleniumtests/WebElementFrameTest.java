package seleniumtests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementFrameTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\sqa-guru\\bat-may22-6-7pm\\batch-may-2022-7pm-ws\\automation-testing-batch-may-2022-7pm\\resources\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		// WebDriver - An interface - containing all methods with signatures
		// chromedriver - is a class, to launch chrome browser

		driver.get("https://demoqa.com/frames");

		driver.switchTo().frame("frame1");

		int totalSampleHeaderText = driver.findElements(By.xpath("//*[text()='This is a sample page']")).size();

		System.out.println("totalSampleHeaderText: " + totalSampleHeaderText);

		driver.switchTo().defaultContent();

		driver.switchTo().frame("frame2");

		int totalSampleHeaderText2 = driver.findElements(By.xpath("//*[text()='This is a sample page']")).size();

		System.out.println("totalSampleHeaderText2: " + totalSampleHeaderText2);
		
		driver.switchTo().parentFrame();

	}

}
