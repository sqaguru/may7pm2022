package seleniumtests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WebSliderTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\sqa-guru\\bat-may22-6-7pm\\batch-may-2022-7pm-ws\\automation-testing-batch-may-2022-7pm\\resources\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		// WebDriver - An interface - containing all methods with signatures
		// chromedriver - is a class, to launch chrome browser

		driver.get("https://demoqa.com/slider");

		Thread.sleep(1000);

		WebElement source = driver.findElement(By.xpath("//input[@type='range']"));

		Actions action = new Actions(driver);

		Rectangle sourceRect = source.getRect();

		System.out.println("x-offset : before move: " + sourceRect.getX());
		System.out.println(sourceRect.getY());
		System.out.println(sourceRect.x);
		System.out.println(sourceRect.y);

		int xOffset = sourceRect.getX() + 5;
		action.dragAndDropBy(source, xOffset, sourceRect.getY()).build().perform();
		System.out.println("x-offset : before move: " + sourceRect.getX());

		driver.get("https://demoqa.com/automation-practice-form");

		driver.findElement(By.id("dateOfBirthInput")).clear();

		driver.findElement(By.id("dateOfBirthInput")).sendKeys(Keys.CONTROL, "a");
		driver.findElement(By.id("dateOfBirthInput")).sendKeys("25 May 2022");

		driver.get("https://www.facebook.com/");

		driver.findElement(By.linkText("Facebook Pay")).click();

		int totalWindows = driver.getWindowHandles().size();

		System.out.println("totalWindows: " + totalWindows);

	}

}
