package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Base {
	protected WebDriver driver;

	@BeforeGroups("GROUP_1")
	public void beforeGroups() {
		System.out.println("before groups");
	}

	@AfterGroups("GROUP_1")
	public void afterGroups() {
		System.out.println("after groups");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before suite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("after suite");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("before Test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("after Test");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("before class method");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("after class method");
	}

	@BeforeMethod(groups = "GROUP_1")
	public void beforeMethod() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"D:\\sqa-guru\\bat-may22-6-7pm\\batch-may-2022-7pm-ws\\automation-testing-batch-may-2022-7pm\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();// maximize the browser
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
