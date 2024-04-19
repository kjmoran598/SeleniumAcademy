import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LogInWithExplicitWait {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		Thread.sleep(3);
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("learning");
		
		driver.findElement(By.xpath("//span[contains(text(),'User')]")).click();										//Radio Button by text
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div[class='modal-content']")));	//Wait for Modal form to be visible
		driver.findElement(By.cssSelector("button[id='okayBtn']")).click();
		
		driver.findElement(By.cssSelector("select[class='form-control']")).click();										//Dropdown menu select with Select class
		WebElement staticDropdown = driver.findElement(By.cssSelector("select[class='form-control']"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByVisibleText("Consultant");
		
		
		driver.findElement(By.cssSelector("input[name='terms']")).click();												//Checkbox 
		driver.findElement(By.id("signInBtn")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='nav-link btn btn-primary']")));			//Wait for new form to load div[class='card h-100]
		
		List<WebElement> products = driver.findElements(By.cssSelector("div[class='card h-100']"));						//Count total products and click each Add button separately

		for(int i=0; i < products.size(); i++) {
			driver.findElements(By.cssSelector("button[class='btn btn-info']")).get(i).click();
		}
		
		driver.findElement(By.cssSelector("a[class='nav-link btn btn-primary']")).click();
		
		
	}

}
