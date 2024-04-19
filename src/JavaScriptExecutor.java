import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;



public class JavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum = 0;
		for(int i = 0; i < values.size(); i++)
		{
			System.out.println(Integer.parseInt(values.get(i).getText()));
			sum += Integer.parseInt(values.get(i).getText());
		}
		
		System.out.println("Sum = " + sum);
		
		String actual = driver.findElement(By.cssSelector(".totalAmount")).getText();
		System.out.println(actual);
		actual = actual.split(":")[1].trim();
		Assert.assertEquals(sum, Integer.parseInt(actual));
		
	}

}
