import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
public class AutoSuggestDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
	    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	      
	    //Open a dropdown with search and type a few letters
	    driver.findElement(By.cssSelector(".ui-autocomplete-input")).sendKeys("Uni");
	    
	    //Capture all web elements for all values that are returned and cycle through each one looking for a match
	    List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] div"));

	    for(WebElement option: options) {
	    	//Use the down key to cycle through each possible match
	    	driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
	    	
	    	//When you get a match, break out of the loop and the current highligted value should be the match
	    	if(option.getText().equalsIgnoreCase("United Kingdom (UK)"))
	    	{
	    		//driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
	    		//option.click();
	    		break;
	    	}
	    }
	    System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
	    
	}

}
