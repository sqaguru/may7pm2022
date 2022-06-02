package seleniumtests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class WebElementDragAndDropTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\sqa-guru\\bat-may22-6-7pm\\batch-may-2022-7pm-ws\\automation-testing-batch-may-2022-7pm\\resources\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://demoqa.com/droppable");

		WebElement draggable = driver.findElement(By.id("draggable"));

		WebElement droppable = driver.findElement(By.id("droppable"));

		Actions action = new Actions(driver);

		action.dragAndDrop(draggable, droppable).build().perform();

		System.out.println("action drag and drop performed");

	}

}
