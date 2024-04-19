import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScopeExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Give me the count of links on the entire page
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//Give me the number of links in footer section (Limiting WebDriver scope)
		WebElement footerDriver =  driver.findElement(By.id("gf-BIG"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		
		//Give me the number of links in that footer but only in the first column (limit WebDriver Scope again)
		WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columnDriver.findElements(By.tagName("a")).size());
		
		//Of those links in that footer column, click on each link below the header text 
		for(int i = 1; i < columnDriver.findElements(By.tagName("a")).size(); i++)
		{
			String clickOnLink = Keys.chord(Keys.COMMAND, Keys.ENTER);
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
			
		}
		
		// Get the current window handleString 
		String mainWindowHandle = driver.getWindowHandle();
		// Get all window handles
		Set<String> allWindowHandles = driver.getWindowHandles();
		// Switch to a specific tab (e.g., the second tab)
		for (String handle : allWindowHandles) 
		{    
			if (!handle.equals(mainWindowHandle)) 
			{        
				driver.switchTo().window(handle);  
				System.out.println(driver.getTitle());
				    
			}
		}
		
		//This is an alternate way to print out each title page using Iterator class
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		
		while(it.hasNext()) 
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		
		

	}

}
