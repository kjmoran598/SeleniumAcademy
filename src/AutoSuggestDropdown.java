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
	      
	    driver.findElement(By.cssSelector(".ui-autocomplete-input")).sendKeys("Uni");
	    List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] div"));
	    for(WebElement option: options) {
    		driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);

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
