package commonlib;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.io.Files;

public class SeleniumUtils {

	private String projectDirectory;

	public SeleniumUtils() {
		setProjectPath(System.getProperty("user.dir"));
	}

	public void captureScreenShot(WebDriver driver, String fileName) throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File destFile = new File(this.getProjectPath() + "\\resources\\results\\" + fileName + ".png");

		Files.copy(srcFile, destFile);
	}

	public String getProjectPath() {
		return this.projectDirectory;
	}

	private void setProjectPath(String projectPath) {
		this.projectDirectory = projectPath;
	}

	/* capture screenshot for single element */
	public void captureElementScreenshotFor(WebDriver driver, String fileName, By locator) throws IOException {

		File srcFile = driver.findElement(locator).getScreenshotAs(OutputType.FILE);

		File destFile = new File(this.getProjectPath() + "\\resources\\results\\" + fileName + ".png");

		Files.copy(srcFile, destFile);

	}

	public WebDriver launchBrowser(String browserName) {
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", getProjectPath() + "\\resources\\drivers\\chromedriver.exe");

			return new ChromeDriver();
		} else if (browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", getProjectPath() + "\\resources\\drivers\\msedgedriver.exe");

			return new EdgeDriver();
		} else {
			System.setProperty("webdriver.gecko.driver", getProjectPath() + "\\resources\\drivers\\geckodriver.exe");

			return new FirefoxDriver();
		}

	}
}
